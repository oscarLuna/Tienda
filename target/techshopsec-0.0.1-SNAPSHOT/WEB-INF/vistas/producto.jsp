<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<div class="single-product-area">
	<div class="zigzag-bottom"></div>
	<div class="container" ng-app="springapp" ng-controller="ArticuloController as ctrl">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Search Products</h2>
					<form action="busqueda">
						<input type="text" name="search" placeholder="Buscar Producto"> <input
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
					<div class="product-breadcroumb">
						<a href="tienda">Tienda</a> <a href="busqueda?search=${producto.categoria.categoria}">${producto.categoria.categoria}</a> <a href="#">${producto.marca}-${producto.nombre}</a>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<div class="product-images">
								<div class="product-main-img">
									<img src="${producto.imagenURL}" alt="" height="195" width="297">
								</div>
								
							</div>
						</div>

						<div class="col-sm-6">
							<div class="product-inner">
								<h2 class="product-name">${producto.marca}-${producto.nombre}</h2>
								<div class="product-inner-price">
									<ins>${producto.precio} $</ins>
								</div>

								<form class="cart">
									<div class="quantity">
										<input type="number" size="4" class="input-text qty text"
											title="Qty" value="1" name="quantity" min="1" step="1" ng-model="cantidad">
									</div>
									<button class="add_to_cart_button" type="button"  ng-click="ctrl.addICant(${producto.idProducto})">Agregar
										al carrito</button>
								</form>

								<div class="product-inner-category">
									<p>
										Categoria: <a href="busqueda?search=${producto.categoria.categoria}">${producto.categoria.categoria}</a>
									</p>
									<p ng-bind="ctrl.mensaje"> 
									</p>
								</div>

								<div role="tabpanel">
									<ul class="product-tab" role="tablist">
										<li role="presentation" class="active"><a href="#home"
											aria-controls="home" role="tab" data-toggle="tab">Descripción</a></li>
									</ul>
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane fade in active" id="home">
											<h2>Descripcion del Producto</h2>
											<p>${producto.descripcion}</p>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/service/carrito_service.js' />"></script>
<script src="<c:url value='/controller/articulo_controller.js' />"></script>
<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>
