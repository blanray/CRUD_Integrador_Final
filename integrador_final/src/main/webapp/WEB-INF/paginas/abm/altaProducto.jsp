<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="modal fade" id="altaProducto" tabindex="-1" aria-labelledby="altaProducto" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title">Alta Producto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="descripcion">Descripcion</label>
                        <input type="text" class="form-control" name="descripcion" required="">
                    </div>
                    <div class="form-group">
                        <label class="form-label">Tipo Producto</label>
                        <select class="form-select" aria-label="Default select example" name="selectorTipo">
                            <p:forEach var="producto" items="${tiposProducto}"> 
                                <option value="${producto.tip_id}">${producto.tip_descripcion}</option>
                            </p:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="stock">Stock</label>
                        <input type="number" class="form-control" name="stock" required="" step="1" min="0">
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="number" class="form-control" name="precio" required="" step="0.01" min="0">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
