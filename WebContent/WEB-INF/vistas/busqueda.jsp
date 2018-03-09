<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Busqueda</h2>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="single-product-area" ng-app="springapp"
	ng-controller="ProductController as ctrl">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
				<c:forEach items="${productos}" var="producto">
					<div class="col-md-3 col-sm-6">
						<div class="single-shop-product">
							<div class="product-upper">
								<a href="producto?codigo=${producto.idProducto}"><img
									src="${producto.imagenURL}" alt="" width="195" height="247"></a>
							</div>
							<h2>
								<a>${producto.marca}</a> <a>${producto.nombre}</a>
							</h2>
							<div class="product-carousel-price">
								<ins>Precio: </ins>
								<ins>${producto.precio}</ins>
							</div>

							<div class="product-option-shop">
								<button type="button" ng-click="ctrl.agregar(${producto.idProducto})"
									class="btn btn-success custom-width">Add to cart</button>
							</div>
						</div>
					</div>
				</c:forEach>
		</div>
	</div>
</div>
<script src="<c:url value='/service/product_service.js' />"></script>
<script src="<c:url value='/controller/producto_controller.js' />"></script>
<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>