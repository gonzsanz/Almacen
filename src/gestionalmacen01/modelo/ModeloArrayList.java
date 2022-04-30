/** Implementa la parte de Modelo de Datos
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package gestionalmacen01.modelo;

import java.util.ArrayList;

public class ModeloArrayList implements ModeloAbs {
  private ArrayList<Producto> lista;

  public ModeloArrayList() {
    lista = new ArrayList<Producto>();
  }

  // Implementar los metodos abstractos de ModeloAbs
  public boolean insertarProducto(Producto p) {

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
        return true;
      }
    }
    return false;
  }

}
