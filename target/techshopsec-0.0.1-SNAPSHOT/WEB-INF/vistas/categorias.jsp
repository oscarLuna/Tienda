<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<div class="product-big-title-area">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="product-bit-title text-center">
					<h2>Categorias</h2>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="single-product-area" ng-app="springapp"
	ng-controller="CategoriaController as ctrl">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div ng-repeat="c in ctrl.categorias">
				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper">
							<a href="busqueda?search={{c.categoria}}"><img
								src="{{c.imagenURL}}" alt="" width="195" height="247"></a>
						</div>
						<h2>
							<a ng-bind="c.categoria"></a>
						</h2>
						<div class="product-carousel-price">
							
						</div>

						<div class="product-option-shop">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/service/categoria_service.js' />"></script>
<script src="<c:url value='/controller/categoria_controller.js' />"></script>
<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>