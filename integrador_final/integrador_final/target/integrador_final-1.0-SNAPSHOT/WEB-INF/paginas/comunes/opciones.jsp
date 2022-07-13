<div class="container border border-primary p-2">
    <div class="row p-2 ">
        <div class="col">
            <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#altaProducto">
                Alta Producto
            </button>
            <button type="button" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#altaTipoProducto">
                Alta Tipo de Producto
            </button>
            <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#actualizarPrecios">
                Actualizacion Masiva de Precios
            </button>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/paginas/abm/actualizarPrecios.jsp"/>