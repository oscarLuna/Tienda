<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<!-- End mainmenu area -->

<!-- Slider -->
<div class="block-slider block-slider4">
	<ul class="" id="bxslider-home4">
		<li><img src="<c:url value='/static/img/iphone.png' />"
			alt="Slide">
			<div class="caption-group">
				<h2 class="caption title">
					<span class="primary"> <strong>IPhone 7 Plus</strong></span>
				</h2>
				<a class="caption button-radius" href="producto?codigo=13"><span
					class="icon"></span>Shop now</a>
			</div></li>
		<li><img src="<c:url value='/static/img/s8.jpg' />" alt="Slide">
			<div class="caption-group">
				<h2 class="caption title">
					<span class="primary"><strong>Samsung Galaxy S8</strong></span>
				</h2>

				<a class="caption button-radius" href="producto?codigo=12"><span
					class="icon"></span>Shop now</a>
			</div></li>

		<li><img src="<c:url value='/static/img/matrice.jpg' />" alt="Slide">
			<div class="caption-group">
				<h2 class="caption title">
					<span class="primary"><strong>DJI Matrice 600</strong></span>
				</h2>

				<a class="caption button-radius" href="producto?codigo=16"><span
					class="icon"></span>Shop now</a>
			</div></li>
	</ul>
</div>
<!-- ./Slider -->
<!-- End slider area -->

<div class="promo-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo1">
					<i class="fa fa-refresh"></i>
					<p>30 dias de devolucion</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo2">
					<i class="fa fa-truck"></i>
					<p>Envio Gratis!</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo3">
					<i class="fa fa-lock"></i>
					<p>Pago Seguro</p>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="single-promo promo4">
					<i class="fa fa-gift"></i>
					<p>Productos Nuevos</p>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End promo area -->

<div class="maincontent-area">
	<div class="zigzag-bottom"></div>
	<div class="container"></div>
</div>
<!-- End product widget area -->

<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>