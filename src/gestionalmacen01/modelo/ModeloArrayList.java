/** Implementa la parte de Modelo de Datos
 * 
 * @gonzsanz
 * @version: 18-05-22
 */
package gestionalmacen01.modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ModeloArrayList implements ModeloAbs {
  private ArrayList<Producto> lista;

  public ModeloArrayList() {
    lista = new ArrayList<Producto>();
    cargarProductos();
  }

  // Implementar los metodos abstractos de ModeloAbs
  public boolean insertarProducto(Producto p) {
    salvarProductos();
    return lista.add(p);
  }

  public boolean borrarProducto(int codigo) {

    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getCodigo() == codigo) {

        lista.remove(i);
        return true;
      }
    }
    return false;
  }

  public Producto buscarProducto(int codigo) {

    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getCodigo() == codigo) {

        return lista.get(i);
      }
    }
    System.out.println("No existe el producto con codigo: " + codigo);
    return null;
  }

  public void listarProductosTodos() {

    for (Producto p : lista) {
      System.out.println(p);
    }
  }

  public void listarProductosStockMin() {

    for (Producto p : lista) {
      if (p.getStock() < p.getStock_min()) {
        System.out.println(p);
      }
    }
  }

  public boolean modificarProducto(Producto nuevo) {

    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i).getCodigo() == nuevo.getCodigo()) {

        lista.set(i, nuevo);
        salvarProductos();
        return true;
      }
    }
    return false;
  }

  @Override
  public void cargarProductos() {

    try (FileInputStream fin = new FileInputStream(ModeloAbs.fichero);
        ObjectInputStream fpo = new ObjectInputStream(fin)) {

      while (true) {

        Producto p = (Producto) fpo.readObject();
        lista.add(p);

      }

    } catch (IOException | ClassNotFoundException e) {

    }

  }

  @Override
  public void salvarProductos() {

    try (FileOutputStream fos = new FileOutputStream(ModeloAbs.fichero);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

      for (Producto p : lista) {
        oos.writeObject(p);
      }
    } catch (IOException e) {

    }

  }

}
