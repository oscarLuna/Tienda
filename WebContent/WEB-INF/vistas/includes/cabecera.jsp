<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Tech Shop!</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link href="<c:url value='/static/css/bootstrap.min.css' />"
	rel="stylesheet"></link>

<!-- Font Awesome -->
<link href="<c:url value='/static/css/font-awesome.min.css' />"
	rel="stylesheet"></link>

<!-- Custom CSS -->
<link href="<c:url value='/static/css/owl.carousel.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/responsive.css' />"
	rel="stylesheet"></link>

<!-- angular -->
<script src="<c:url value='/static/js/angular.min.js' />"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/authInterceptor.js'/>"></script>


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
							<li><a href="<c:url value='micuenta'/>"><i class="fa fa-user"></i> My
									Account</a></li>
							<li><a href="<c:url value='carrito'/>"><i class="fa fa-shopping-cart"></i> My
									Cart</a></li>
							<li><a href="<c:url value='orden'/>"><i class="fa fa-user"></i>
									Ordenar</a></li>
							<c:choose>
								<c:when test="${user == null}">
									<li><a href="login"><i class="fa fa-user"></i> Login</a></li>
								</c:when>
							</c:choose>
							
						</ul>
					</div>

				</div>

				<div class="col-md-4">
					<div class="header-right">
						<ul class="list-unstyled list-inline">
							<c:choose>
								<c:when test="${user != null}">
									<li class="dropdown dropdown-small"><a
										data-toggle="dropdown" data-hover="dropdown"
										class="dropdown-toggle" href="#"><span class="key">${user.email}
										</span><b class="caret"></b></a>
										<ul class="dropdown-menu">
											<li><a href="micuenta">Mi Cuenta</a></li>
											<li><a href="logout">Cerrar Sesión</a></li>
										</ul></li>
								</c:when>
							</c:choose>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End header area -->
	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="index"><img src="<c:url value='/img/logo.jpg'/>" width="166" height="80"></a>
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->
	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="index">Home</a></li>
						<li><a href="tienda">Productos</a></li>
						<li><a href="carrito">Carrito</a></li>
						<li><a href="orden">Ordenar</a></li>
						<li><a href="categorias">Categorias</a></li>
						<c:choose>
							<c:when test="${user == null}">
								<li><a href="registro">Registro</a></li>
							</c:when>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
	</div>