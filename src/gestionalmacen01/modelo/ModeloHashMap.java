
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

}
