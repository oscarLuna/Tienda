<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<div  ng-app="springapp" ng-controller="validarController">

	<form id="login-form-wrap" name="registro" class="login"
		ng-submit="registroUsuario()" >

	<p class="form-row form-row-first">
		<label for="nombres">Nombres: <span class="required">*</span>
		</label> <input type="text" id="nombres" name="nombres"
			ng-model="usuario.nombres" ng-model-options="{ updateOn: 'blur' }"
			required class="input-text"> <span class="messages"
			ng-show="registro.$submitted || registro.nombres.$touched"> <span
			ng-show="registro.nombres.$error.required">El campo es
				obligatorio.</span>
		</span>
	</p>
	<p class="form-row form-row-last">
		<label for="aPaterno">Apellido Paterno <span class="required">*</span>
		</label> <input type="text" id="aPaterno" name="aPaterno"
			ng-model="usuario.apellidoPaterno" ng-model-options="{ updateOn: 'blur' }"
			required class="input-text"> <span class="messages"
			ng-show="registro.$submitted || registro.aPaterno.$touched"> <span
			ng-show="registro.aPaterno.$error.required">El campo es
				obligatorio.</span>
		</span>
	</p>
	<p class="form-row form-row-last">
		<label for="aMaterno">Apellido Materno<span class="required">*</span>
		</label> <input type="text" id="aMaterno" name="aMaterno"
			ng-model="usuario.apellidoMaterno" ng-model-options="{ updateOn: 'blur' }"
			required class="input-text"> <span class="messages"
			ng-show="registro.$submitted || registro.aMaterno.$touched"> <span
			ng-show="registro.aMaterno.$error.required">El campo es
				obligatorio.</span>
		</span>
	</p>
	<p class="form-row form-row-last">
		<label for="sexo">Género</label><br /> <input name="sexo"
			type="radio" ng-model="cliente.sexo" value="masculino" />Masculino <input
			name="sexo" type="radio" ng-model="usuario.sexo" value="femenino" />Femenino
	</p>
	<p class="form-row form-row-last">
		<label for="fechaNac">Fecha de Nacimiento <span
			class="required">*</span></label><input type="date" id="fechaNac"
			name="fechaNac" class="input-text" ng-model="usuario.fechaNacimiento"
			placeholder="aaaa-MM-dd" min="1930-01-01" max="2010-12-31"
			ng-model-options="{ updateOn: 'blur' }" required class="input-text">
		<span class="messages"
			ng-show="registro.$submitted || registro.fechaNac.$touched"> <span
			ng-show="registro.fechaNac.$error.required">El campo es
				obligatorio.</span> <span ng-show="registro.fechaNac.$error.date">Fecha
				no valida debe tener el formato aaaa-MM-dd</span>
		</span>
	</p>

	<p class="form-row form-row-last">
		<label for="username">Email <span class="required">*</span>
		</label> <input type="email" id="email" name="email" class="input-text"
			ng-model="usuario.email" ng-model-options="{ updateOn: 'blur' }"
			required class="input-text"> <span class="messages"
			ng-show="registro.$submitted || registro.email.$touched"> <span
			ng-show="registro.email.$error.required">El campo es
				obligatorio.</span> <span ng-show="registro.email.$error.email">Formato
				de email incorrecto.</span>
		</span>
	</p>
	<p class="form-row form-row-last">
		<label for="password">Contraseña<span class="required">*</span>
		</label> <input type="password" id="password" name="password"
			class="input-text" ng-model="usuario.password"
			ng-model-options="{ updateOn: 'blur'}" required class="input-text">
		<span class="messages"
			ng-show="registro.$submitted || registro.password.$touched"> <span
			ng-show="registro.password.$error.required">El campo es
				obligatorio.</span>
		</span>
	</p>
	<input type="submit" value="registro" />
	
	<div class="alert alert-danger" ng-show="registro.$error">
			<p>{{mensaje}}</p>
	</div>
</form>
</div>

<script src="<c:url value='/static/js/ui-bootstrap.js'/>"></script>
<script src="<c:url value='/static/js/validacion.js'/>"></script>


<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>