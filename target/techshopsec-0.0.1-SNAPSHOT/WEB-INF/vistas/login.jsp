<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<!--Empieza form -->
<form id="login-form-wrap" action="${loginUrl}" class="login"
	method="post">
	<p class="form-row form-row-first">
		<label for="username">Username or email <span class="required">*</span>
		</label> <input type="text" id="ssoId" name="ssoId" class="input-text">
	</p>
	<p class="form-row form-row-last">
		<label for="password">Password <span class="required">*</span>
		</label> <input type="password" id="password" name="password"
			class="input-text">
	</p>
	<div class="clear"></div>


	<p class="form-row">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Login"
			name="login" class="button"> 
	</p>
	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Usuario o contraseña incorrectos</p>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>log out satisfactorio</p>
		</div>
	</c:if>

	<div class="clear"></div>
</form>

<!-- temina el form -->
<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>
