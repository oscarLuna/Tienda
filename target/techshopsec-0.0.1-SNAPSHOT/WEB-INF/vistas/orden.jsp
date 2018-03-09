
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>
<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Orden de compra</h2>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Search Products</h2>
					<form action="busqueda">
						<input type="text" name="search" placeholder="Search products..."> <input
							type="submit" value="Search">
					</form>
				</div>

				<div class="single-sidebar">
					<h2 class="sidebar-title">Otros Productos</h2>
					<div class="thubmnail-recent">
						<img src="img/productos/product-13-thumb.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="producto?codigo=13">iPhone 7</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$17,000</ins>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img src="img/productos/product-17-thumb.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="producto?codigo=17">MUVI Quadcopter Veho</a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$10,879</ins>
						</div>
					</div>
					<div class="thubmnail-recent">
						<img src="img/productos/product-8-thumb.jpg" class="recent-thumb" alt="">
						<h2>
							<a href="producto?codigo=8">DELL Alienware Alpha </a>
						</h2>
						<div class="product-sidebar-price">
							<ins>$22,499</ins>
						</div>
					</div>
				</div>

			</div>

			<div class="col-md-8">
				<div class="product-content-right">
					<div class="woocommerce">
						<c:choose>
							<c:when test="${user==null}">
								<div class="woocommerce-info">
									Inicia sesion para realizar tu orden de compra<br/>
									No has entrado? <a class="showlogin" href="login">Click para entrar</a> o <a class="showlogin" href="registro">Registrate</a>
								</div>

							</c:when>
							<c:when test="${carrito==null || carrito.precioTotal <= 0}">
							<h2>Tu carrito esta vacio!</h2>
							</c:when>
							<c:when test="${user!=null && carrito!=null && carrito.precioTotal > 0}">
								<jsp:include page="includes/contenidoOrden.jsp" flush="true"></jsp:include>
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>
