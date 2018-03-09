
<form action="RealizarOrden" class="checkout"
	method="get">

	<div id="customer_details" class="col2-set">
		<div class="col-1">
			<div class="woocommerce-billing-fields">
				<h3>Detalles de la Orden</h3>
				<p id="billing_first_name_field"
					class="form-row form-row-first validate-required">
					<label class="" for="billing_first_name">Nombres<abbr
						title="required" class="required">*</abbr>
					</label> <input type="text" value="${user.nombres}" placeholder="" id="billing_first_name"
						name="billing_first_name" class="input-text ">
				</p>

				<p id="billing_last_name_field"
					class="form-row form-row-last validate-required">
					<label class="" for="billing_last_name">Apellidos<abbr
						title="required" class="required">*</abbr>
					</label> <input type="text" value="${user.apellidoPaterno} ${user.apellidoMaterno}" placeholder="" id="billing_last_name"
						name="billing_last_name" class="input-text ">
				</p>
				<div class="clear"></div>

				<p id="billing_address_1_field"
					class="form-row form-row-wide address-field validate-required">
					<label class="" for="billing_address_1">Direccion <abbr
						title="required" class="required">*</abbr>
					</label> <input type="text" value="Domicilio Conocido" placeholder="Street address"
						id="billing_address_1" name="billing_address_1"
						class="input-text ">
				</p>

				<div class="clear"></div>

				<p id="billing_email_field"
					class="form-row form-row-first validate-required validate-email">
					<label class="" for="billing_email">Email<abbr
						title="required" class="required">*</abbr>
					</label> <input type="text" value="${user.email}" placeholder="" id="billing_email"
						name="billing_email" class="input-text ">
				</p>

				<div class="clear"></div>
			</div>
		</div>
	</div>

	<h3 id="order_review_heading">Your order</h3>

	<div id="order_review" style="position: relative;">
		<table class="shop_table">
			<thead>
				<tr>
					<th class="product-name">Descripcion</th>
					<th class="product-total">Total</th>
				</tr>
			</thead>
			<tbody>
				<tr class="cart-subtotal">
					<th>Carrito Subtotal</th>
					<td><span class="amount">${carrito.precioTotal}</span></td>
				</tr>
				<tr class="cart-subtotal">
					<th>Total de articulos</th>
					<td><span class="amount">${carrito.cantidadTotal}</span></td>
				</tr>
				<tr class="shipping">
					<th>Envio</th>
					<td>Envio gratis!<input type="hidden" class="shipping_method"
						value="free_shipping" id="shipping_method_0" data-index="0"
						name="shipping_method[0]">
					</td>
				</tr>


				<tr class="order-total">
					<th>Total de Orden</th>
					<td><strong><span class="amount">${carrito.precioTotal}</span></strong></td>
				</tr>

			</tbody>
			<tfoot>


			</tfoot>
		</table>
		<div class="form-row place-order">
			<input type="submit" data-value="Place order" value="Realizar Orden"
				id="place_order" name="woocommerce_checkout_place_order"
				class="button alt">
		</div>
	</div>
</form>