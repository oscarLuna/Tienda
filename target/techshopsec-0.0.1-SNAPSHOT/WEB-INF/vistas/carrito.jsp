<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<div class="single-product-area" ng-app="springapp"
	ng-controller="CarritoController as ctrl">
	<div class="zigzag-bottom"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="single-sidebar">
					<h2 class="sidebar-title">Buscar Productos</h2>
					<form action="busqueda">
						<input type="text" name="search" placeholder="Buscar Productos...">
						<input type="submit" value="Search">
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
						<form>
							<table cellspacing="0" class="shop_table cart">
								<thead>
									<tr>
										<th class="product-remove">&nbsp;</th>
										<th class="product-thumbnail">&nbsp;</th>
										<th class="product-name">Producto</th>
										<th class="product-price">Precio</th>
										<th class="product-quantity">Cantidad</th>
										<th class="product-subtotal">Subtotal</th>
									</tr>
								</thead>
								<tbody>
									<tr class="cart_item" ng-repeat="c in ctrl.carrito.productos">
										<td class="product-remove"><button type="button"
												ng-click="ctrl.deleteItem(c.producto.idProducto)"
												class="btn btn-danger custom-width">Quitar</button>
											<button type="button" ng-click="ctrl.updateItem(c)"
												class="btn btn-success custom-width">Actualizar</button></td>

										<td class="product-thumbnail"><a
											href="producto?codigo={{c.producto.idProducto}}"><img
												width="145" height="145" alt="poster_1_up"
												class="shop_thumbnail" src="{{c.producto.imagenURL}}"></a></td>

										<td class="product-name"><a
											href="producto?codigo={{c.producto.idProducto}}"
											ng-bind="c.producto.nombre"></a></td>

										<td class="product-price"><span class="amount"
											ng-bind="c.producto.precio"></span></td>

										<td class="product-quantity">
											<div class="quantity buttons_added">
												<input type="number" size="4" class="input-text qty text"
													title="Qty" ng-model="c.cantidad" min="1" step="1">
											</div>
										</td>

										<td class="product-subtotal"><span class="amount"
											ng-bind="c.subtotal"></span></td>
									</tr>
									<tr>
										<td class="actions" colspan="6"><input type="submit"
											value="Realizar Pedido" ng-click="ctrl.pedido()" name="proceed"
											class="checkout-button button alt wc-forward"> <input
											type="submit" ng-click="ctrl.deleteCart()" value="Vaciar Carrito" name="proceed"
											class="checkout-button button alt wc-forward"></td>
									</tr>
								</tbody>

							</table>
						</form>

						<div class="cart-collaterals">
							<div class="cart_totals ">
								<h2>Total de Carrito</h2>

								<table cellspacing="0">
									<tbody>
										<tr class="shipping">
											<th>Numero de Articulos</th>
											<td ng-bind="ctrl.carrito.cantidadTotal"></td>
										</tr>
										<tr class="cart-subtotal">
											<th>Total</th>
											<td><span class="amount"
												ng-bind="ctrl.carrito.precioTotal"></span></td>
										</tr>
									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/service/carrito_service.js' />"></script>
<script src="<c:url value='/controller/carritoController.js' />"></script>

<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>
