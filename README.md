# Almacen



Implementar una aplicación por consola que implemente un CRUD (Create, Read, Update, Delete) que sirve para mantener un almacén de productos con los siguientes campos:
```sh
int código;    // Código del producto, se utiliza para buscar
String nombre; // Nombre un texto
int stock :    // existencia actuales
int stock_min; // Número mínimo de existencias recomedadas
float precio;  // Precio
```
El programa deberá implementar el siguiente menú

1. **Nuevo producto →**  Etrada de productos, dos productos no pueden tener el mismo código. Precio y stock tienen que ser mayor que 0
2. **Consulta producto →** Se pide un código y se muestra su información
3. **Borrar producto →** Se pide un código, se muestra su información y se piden confirmar la eliminación.
4. **Modificar precio →** Se pide un código, se muestra su información y se pide el nuevo valor de precio, que no puede ser negativo o 0
5. **Compra de productos →** Se solicita un código y la cantidad de productos comprados, se  incrementa es stock
6. **Venta de productos →**  Se solicita un código y la cantidad de productos vendidos,  se decrementa el stock ( No puede ser negativo, no se puede vender más productos de los hay en stock)
7. **Listado completo de productos →** Muestra un listado formateado de productos
8. **Listado de productos con stock inferior al mínimo. →** Muestra un listado de los productos cuyo stock_min es superior al stock actual.
9. **Terminar →** Termina el programa




>  Se tiene que tratar la excepciones debidas a la entrada de datos con formato erróneo.
> Se debe implementa una clase MiAlmacen con un método main y los métodos estáticos auxiliares que se consideren necesarios. ( No hacer métodos incluido el main leerPrecio, leerOpción, mostrarMenu, buscarProducto....
