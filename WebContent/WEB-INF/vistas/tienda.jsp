<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Shop</h2>
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
		 <alert-message alert="alertMessage"></alert-message>
			<div ng-repeat="p in ctrl.products">
				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper">
							<a href="producto?codigo={{p.idProducto}}"><img
								src="{{p.imagenURL}}" alt="" width="195" height="247"></a>
						</div>
						<h2>
							<p ng-bind="p.marca"></p> <p ng-bind="p.nombre"></p>
						</h2>
						<div class="product-carousel-price">
							<ins>Precio: </ins>
							<ins ng-bind="p.precio"></ins>
							<a class="{{p.mensaje}}"></a>
						</div>

						<div class="product-option-shop">
							<button type="button" ng-click="ctrl.agregar(p)"
								class="btn btn-success custom-width">Add to cart</button>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>

<script src="<c:url value='/service/product_service.js' />"></script>
<script src="<c:url value='/controller/producto_controller.js' />"></script>


<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>