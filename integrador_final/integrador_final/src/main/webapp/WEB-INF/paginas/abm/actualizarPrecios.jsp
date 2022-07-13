<div class="modal fade" id="actualizarPrecios" tabindex="-1" aria-labelledby="actualizarPrecios" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title">Actualizacion masiva de precios</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=actualizarPrecios" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Ingrese porcentaje</label>
                        <input type="number" class="form-control" name="porcentaje" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Actualizar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
