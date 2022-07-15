<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR" />

<section id="misTipos">
    <div class="container p-2">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center bg-info">
                            Listado de Tipos Productos
                        </h3>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Descripcion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <p:forEach var="tiposProductos" items="${tiposProducto}" varStatus="estado">
                                    <tr>
                                        <td>${estado.count}</td>
                                        <td>${tiposProductos.tip_descripcion}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/servletControlador?accion=editarTipo&temporal=${tiposProductos.tip_id}" class="btn btn-warning">
                                                Editar
                                            </a>
                                        </td>
                                        <td>
                                            
                                            <p:if test="${tiposProductos.eliminar == true}">  
                                                <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminarTipo&temporal=${tiposProductos.tip_id}" class="btn btn-danger">
                                                    Eliminar
                                                </a>
                                            </p:if>  
                                        </td>
                                    </tr>
                                </p:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/abm/altaTipoProducto.jsp"/>