<jsp:include page="intranetValida.jsp" />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>


<title>Intranet Colegio - Jorge Jacinto Gutarra</title>
</head>
<body>
       
<jsp:include page="intranetCabecera.jsp" />
<div class="container">&nbsp;<br>&nbsp;<br>&nbsp;<br>
<h4>Registro de Curso</h4>

<c:if test="${sessionScope.MENSAJE != null}">
		<div class="alert alert-success fade in" id="success-alert">
		 <a href="#" class="close" data-dismiss="alert">&times;</a>
		 <strong>${sessionScope.MENSAJE}</strong>
		</div>
	</c:if>
	<c:remove var="MENSAJE" />
</div>

<div class="container" >
 <div class="col-md-12" align="center"> 
	<form action="registraCursoBD" id="id_form" method="post"> 
			<input type="hidden" name="metodo" value="registra">	
			<div class="form-group">
				<label class="control-label" for="id_codigo">Codigo</label>
				<input class="form-control" type="text" id="id_codigo" name="codigo" placeholder="Ingrese el codigo">
			</div>
			<div class="form-group">
				<label class="control-label" for="id_nombre">Nombre</label>
				<input class="form-control" id="id_nombre" name="nombre" placeholder="Ingrese el nombre" type="text" maxlength="90"/>
			</div>
			       <div class="form-group">
		                                        <label class="control-label" for="id_estado">Estado</label>
		                                      
													<select id="id_estado" name="curso.estado" class='form-control'>
							                                 <option value="" >[SELECCIONE]</option>
							                                 <option value="Activo">ACTIVO</option>
							                                 <option value="Inactivo">INACTIVO</option>
							                         </select>
		                                        
		                                    </div>
		
			<div class="form-group">
				<label class="control-label" for="id_sistema">Sistema de Evaluacion</label>
				<select id="id_sistema" name="sistemaevaluacion.idSistemaEvaluacion" class='form-control'>
					<option value=" ">[Seleccione]</option> 
					<c:forEach var="x" items="${requestScope.objSistema}">
			            <option value="${x.idSistemaEvaluacion}">${x.nombre}</option>
			        </c:forEach>   
				</select>
		    </div>
		    	</form>
		    
		    
			<div class="form-group">
				<button type="submit" class="btn btn-primary" >Registra Curso</button>
			</div>
			
			
<script type="text/javascript">

$("#idBtnElimina").click(function(){
	$("#idFormElimina").submit();
});


function eliminar(id){	
	$('#idModalElimina').modal('show');
	$('#id_elimina').val(id);	
}

function registrar(){	
	$('#idModalRegistra').modal("show");
}

function editar(id,nombre,numHombres,numMujeres,edadMaxima, edadMinima, idDeporte){	
	$('input[id=id_ID]').val(id);
	$('input[id=id_act_nombre]').val(nombre);
	$('input[id=id_act_num_hombres]').val(numHombres);
	$('input[id=id_act_num_mujeres]').val(numMujeres);
	$('input[id=id_act_minima]').val(edadMinima);
	$('input[id=id_act_maxima]').val(edadMaxima);
	$('select[id=id_act_deporte]').val(idDeporte);
	$('#idModalActualiza').modal("show");
}

$(document).ready(function() {
    $('#tablePaginacion').DataTable();
} );
</script>
			
			

	
 </div>
</div> 

 		 		
</body>
</html>