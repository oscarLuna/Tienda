<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="includes/cabecera.jsp" flush="true"></jsp:include>

<table id="table-1" class="table table-stripped">
			<thead>
				<tr>
					<th>nombre</th>
					<th>apellido paterno</th>
					<th>apellido materno</th>
					<th>Fecha Nacimiento</th>
					<th>sexo</t>
					<th>e-mail</t>
				</tr>
			</thead>
			<tbody id="tbody">
				<tr>
					<td>${user.nombres}</td>
					<td>${user.apellidoPaterno}</td>
					<td>${user.apellidoMaterno}</td>
					<td>${user.fechaNacimiento}</td>	
					<td>${user.sexo}</td>
					<td>${user.email}</td>						
				</tr>
			</tbody>
		</table>

<jsp:include page="includes/pie.jsp" flush="true"></jsp:include>