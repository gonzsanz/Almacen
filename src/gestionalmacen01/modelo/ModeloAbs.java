package gestionalmacen01.modelo;

/**
 * Abstract class ModeloAbs - Clase de acceso a Modelo de DATOS
 * 
 * @gonzsanz
 * @version: 18-05-2022
 */
public interface ModeloAbs {

    static final String fichero = "productos.objeto";

    public boolean insertarProducto(Producto p);

    boolean borrarProducto(int codigo);

    public Producto buscarProducto(int codigo);

    void listarProductosTodos();

    void listarProductosStockMin();

    boolean modificarProducto(Producto nuevo);

    void cargarProductos();

    void salvarProductos();

}
