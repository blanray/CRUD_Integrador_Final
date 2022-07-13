<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR" />

<section id="miTabla">
    <div class="container p-2">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center bg-info">
                            Listado de Productos
                        </h3>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Descripcion</th>
                                    <th>Tipo</th>
                                    <th>Stock</th>
                                    <th>Precio Unitario</th>
                                </tr>
                            </thead>
                            <tbody>
                                <p:forEach var="producto" items="${productos}" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${producto.prd_descripcion}</td>
                                        <td>${producto.tip_descripcion}</td>
                                        <td>${producto.prd_stock}</td>
                                        <td><fmt:formatNumber value="${producto.prd_precio}" type="currency" /></td>
                                        <td>
                                            <a href="" class="btn btn-warning">
                                                Editar
                                            </a>
                                        </td>
                                        <td>
                                            <a href="" class="btn btn-danger">
                                                Eliminar
                                            </a>
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

<jsp:include page="/WEB-INF/paginas/abm/altaProducto.jsp"/>