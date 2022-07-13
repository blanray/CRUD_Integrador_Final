<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR" />

<section id="misCards">
    <div class="container">
        <h3 class="text-center text-dark p-2 bg-info">Indicadores de Stock</h3>
        <div class="col">
            <div class="card text-center bg-success bg-opacity-50 mb-3">
                <div class="card-body">
                    <h5>${totalGeneral.getTip_descripcion()}</h5>
                    <h6 class="display-9"><fmt:formatNumber value="${totalGeneral.getCantidad()}" type="number"/></h6>
                    <h6 class="display-9"><fmt:formatNumber value="${totalGeneral.getValor()}" type="currency"/></h6>
                </div>
            </div>
            <div class="row card-group">
                <div class="mb-3">
                    <p:forEach var="tipos" items="${totalesPorTipo}">
                        <div class="card text-center bg-warning bg-opacity-50 mb-3">
                            <div class="card-body">
                                <h5>${tipos.getTip_descripcion()}</h5>
                                <h6 class="display-9"><fmt:formatNumber value="${tipos.getCantidad()}" type="number"/></h6>
                                <h6 class="display-9"><fmt:formatNumber value="${tipos.getValor()}" type="currency"/></h6>
                            </div>
                        </div>
                    </p:forEach>
                </div>
            </div>
        </div>
    </div> 


</section>