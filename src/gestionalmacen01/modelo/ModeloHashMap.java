
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package gestionalmacen01.modelo;

import java.util.HashMap;
import java.util.Map;

// Faltan incluir los metodos del interfaz 
public class ModeloHashMap implements ModeloAbs {
    private HashMap<Integer, Producto> lista;

    public ModeloHashMap() {
        lista = new HashMap<Integer, Producto>();
    }

    public boolean insertarProducto(Producto p) {

        lista.put(p.getCodigo(), p);
        return true;
    }

    public boolean borrarProducto(int codigo) {

        if (lista.get(codigo) != null) {
            lista.remove(codigo);
            return true;
        }
        return false;
    }

    public Producto buscarProducto(int codigo) {
        if (lista.get(codigo) != null) {
            return lista.get(codigo);
        }
        System.out.println("No existe el producto con codigo: " + codigo);
        return null;
    }

    public void listarProductosTodos() {

        for (Map.Entry<Integer, Producto> entry : lista.entrySet()) {

            System.out.println(entry.getValue().toString());
        }
    }

    public void listarProductosStockMin() {
        for (Map.Entry<Integer, Producto> entry : lista.entrySet()) {
            Producto valor = entry.getValue();
            if (valor.getStock() < valor.getStock_min()) {

                System.out.println(valor);
            }
        }
    }

    public boolean modificarProducto(Producto nuevo) {

        if (lista.get(nuevo.getCodigo()) != null) {
            lista.replace(nuevo.getCodigo(), nuevo);
            return true;
        }
        return false;
    }
}
