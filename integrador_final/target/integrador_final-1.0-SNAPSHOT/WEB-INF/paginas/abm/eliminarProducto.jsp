<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Eliminar Producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=borrarProducto&idTemp=${tempProd.prd_id}" method="POST" class="was-validated">

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header bg-danger">
                                    <h4>Eliminar Producto</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="descripcion">Descripcion</label>
                                        <input type="text" class="form-control" name="descripcion" required="" value="${tempProd.prd_descripcion}" disabled="true">
                                    </div>
                                    <div class="form-group">
                                        <label for="tipo">Tipo de Producto</label>
                                        <input type="text" class="form-control" name="descripcion" required="" value="${tempProd.tip_descripcion}" disabled="true">
                                    </div>
        <div class="form-group">
                                        <label for="stock">Stock</label>
                                        <input type="number" class="form-control" name="stock" required="" value="${tempProd.prd_stock}" step="1" min="0" disabled="true">
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="number" class="form-control" name="precio" required="" value="${tempProd.prd_precio}" step="0.01" min="0" disabled="true">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <section id="actions" class="py-4 mb-4 bg-light">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-4">
                                <a href="index.jsp" class="btn btn-light btn-block">
                                    Cancelar
                                </a>
                            </div>
                            <div class="col-md-4">
                                <button type="submit" class="btn btn-danger btn-block">
                                    <i class="fas fa-check"></i>
                                    Confirmar eliminacion
                                </button>
                            </div>
                        </div>
                    </div>
                </section>

            </section>
        </form>



        <jsp:include page="/WEB-INF/paginas/comunes/pie.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
