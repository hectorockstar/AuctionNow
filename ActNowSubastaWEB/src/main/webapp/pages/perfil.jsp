<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>

<jsp:include page="../estructura/header-content.jsp" />

<div class="panel panel-default">
  <div class="panel-body">  	
  	
  	  <!--Inicio contenido dinámico-->
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
			  <div class="panel panel-default">
			  	  <div class="panel-heading"><c:out value="${usuarioWeb.getNombreUsuario() }" /> </div>
			  	  <div class="panel-body">
					  <ul class="nav nav-pills nav-stacked">				    
					    <c:forEach items="${listadoMenu}" var="objMenu" varStatus="loop">
					    	<c:choose>
					    		<c:when test="${loop.count == 1 }">
					    			<li class="active"><a data-toggle="pill" href='#p<c:out value="${loop.count}"/>'><c:out value="${objMenu.getNombreMenu()}" /></a></li>
					    		</c:when>
					    		<c:otherwise>
									<li><a data-toggle="pill" href='#p<c:out value="${loop.count}"/>'><c:out value="${objMenu.getNombreMenu()}" /></a></li>			    		
					    		</c:otherwise>
					    	</c:choose>				    						    						    		    		    
					    </c:forEach>				    
					  </ul>
				  </div>	
			  </div>			
			</div>
			
			<div class="col-sm-9">
				<div class="tab-content">				    			    
				  <c:forEach items="${listadoMenu}" var="pages" varStatus="loop">				    	
					    <c:choose>
					    	<c:when test="${loop.count == 1}">
					    		<div id='p<c:out value="${loop.count}"/>' class="tab-pane fade in active">
							      <h3><c:out value="${pages.getNombreMenu() }"></c:out> </h3>							     
							      <c:out value="" />
							      <c:catch var="catchException">
									<c:choose>
								      	<c:when test="${pages.getTipoCatalogo() == 'C'}">
								      		<jsp:include page="menu_perfil_cliente/${pages.getDestinoMenu()}" />
								      	</c:when>
								      	<c:otherwise>
								      		<jsp:include page="menu_perfil_proveedor/${pages.getDestinoMenu()}" />
								      	</c:otherwise>
								     </c:choose>
							      </c:catch>	
							      <c:if test="${catchException  != null}">
							      	<jsp:include page="../error/404.jsp" />
							      </c:if>						      
							    </div>
					    	</c:when>
					    	<c:otherwise>
					    		<div id='p<c:out value="${loop.count}"/>' class="tab-pane fade">
							      <h3><c:out value="${pages.getNombreMenu() }"></c:out> </h3>							      							     
							      <c:catch var="catchException">
							      	<c:choose>
										<c:when test="${pages.getTipoCatalogo() == 'C'}">
											<jsp:include page="menu_perfil_cliente/${pages.getDestinoMenu()}" />
										</c:when>
										<c:otherwise>
											<jsp:include page="menu_perfil_proveedor/${pages.getDestinoMenu()}" />
										</c:otherwise>
								     </c:choose>
							      </c:catch>
							      <c:if test="${catchException  != null}">
							      	<jsp:include page="../error/404.jsp" />
							      	<c:out value="${pages.getDestinoMenu() }" />
							      </c:if>	
							    </div>
					    	</c:otherwise>
					    </c:choose>
				    </c:forEach>
				    <%-- <div id='p1' class="tab-pane fade in active">
				      <h3>registro solicitud usuario </h3><br>							      							     
				      <jsp:include page="menu_perfil/detalle_registro_solicitud.jsp" />
				    </div> --%>
			  	</div>
		  	</div>
		  	
		</div>
	</div>	
  	
  </div>
</div>  

<jsp:include page="../estructura/footer-content.jsp" />