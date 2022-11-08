
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>CollegeEazy</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/index-styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">College Eazy</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="index.jsp">Home Page</a></li>
								
				</ul>
			</div>
		</div>
	</nav>
<!-- Masthead-->
<header class="masthead bg-primary text-white text-center">
	<div class="container d-flex align-items-center flex-column">
		<!-- Masthead Heading-->
		<h1 class="masthead-heading text-uppercase mb-0">Upload Notes</h1>
		<!-- Icon Divider-->
		<div class="divider-custom divider-light">
			<div class="divider-custom-line"></div>
			<div class="divider-custom-icon">
				<i class="fas fa-star"></i>
			</div>
			<div class="divider-custom-line"></div>
		</div>
</header>
<div class = "container">
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-body">
				<% 
					String msg = (String)session.getAttribute("msg");
					if(msg!=null){
					%>
					<h4 class = "text-center"><%=msg %></h4>	
					<%
					session.removeAttribute("msg");
					}
					%>
					
					<form method="post" action="upload" enctype="multipart/form-data">
						<div class="mb-3">
							<label>Notes</label><input type="file" name="files" class="form-control">
						</div>
						<div class="mb-3">
							<label>Subject</label><input type="text" name="subject " class="form-control">
						</div>
						<div class="mb-3">
							<label>Uploaded Note's Description</label><input type="text" name="description" class="form-control">
						</div>
						<div class="text-center">
							<button class="btn btn-primary">Upload</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<table class="table - 5">
		<thead>
			<tr>
  				<th scope="col">#</th>
  				<th scope="col">File Type</th>
	 			<th scope="col">Subject</th>
  				<th scope="col">Description</th>
			</tr>
		</thead>
<tbody>
		<%
		Connection conn = DbConnect.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from Notes");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
		%>
		<tr>
  			<th scope="row">
  			<img alt="" src="images/">
  			</th>
 		 	<td>Mark</td>
</tr>
		
		}
		%>
	</tbody>
</table>
</div>
	<!-- Footer-->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Contact Us-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="text-uppercase mb-4">Contact Us</h4>
					<h6 class="lead mb-0">Shashank Pandey </h6>
				</div>
			</div>
		</div>
	</footer>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>

	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
