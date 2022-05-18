
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @gonzsanz
 * @version 18-05-22
 */
package gestionalmacen01.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

// Faltan incluir los metodos del interfaz 
public class ModeloHashMap implements ModeloAbs {
    private HashMap<Integer, Producto> lista;

    public ModeloHashMap() {
        lista = new HashMap<Integer, Producto>();
        cargarProductos();
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
            salvarProductos();
            return true;
        }
        return false;
    }

    @Override
    public void cargarProductos() {
        try (FileInputStream fin = new FileInputStream(ModeloAbs.fichero);
                ObjectInputStream fpo = new ObjectInputStream(fin)) {

            while (true) {

                Producto p = (Producto) fpo.readObject();
                lista.put(p.getCodigo(), p);

            }

        } catch (IOException | ClassNotFoundException e) {

        }
    }

    @Override
    public void salvarProductos() {
        try (FileOutputStream fos = new FileOutputStream(ModeloAbs.fichero);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            for (int i = 0; i < Producto.autocodigo; i++) {
                oos.writeObject(lista.get(i));
            }

        } catch (IOException e) {

        }
    }
}
