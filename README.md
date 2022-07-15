# CRUD_Integrador_Final

Ejercicio CRUD Integrador Final Codo a Codo.

Se trata de dos tablas: productos y tipos_producto que se relacionan mediante el id del tipo de producto.

En la pagina se puede hacer el ABM de ambas tablas con la particularidad que en la seccion de los Tipos de Producto, el boton "Eliminar" solo se muestra en aquellos casos donde es posible eliminarlo, es decir, que no tiene Productos asociados, puesto que de otra forma daria un error el SQL por tratar de borrar un registro que es clave foranea de otra tabla.

Adicionalmente, se permite una accion de actualiacion masiva de precios y se presentan cards a modo de dashboard con informacion resumen del stock general y los totales por cada tipo de producto.
