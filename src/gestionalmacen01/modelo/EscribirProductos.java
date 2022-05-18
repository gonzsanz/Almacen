package gestionalmacen01.modelo;

/**
 * 
 *   Escribe datos de prueba en el fichero de productos.
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class EscribirProductos {

    public static void main(String[] args) {

        {
            try (FileOutputStream fos = new FileOutputStream(ModeloAbs.fichero);
                    ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(new Producto("Morcillas ", 10, 5, 10.5f));
                oos.writeObject(new Producto("Chorizo", 30, 5, 12.5f));
                oos.writeObject(new Producto("Chope", 70, 15, 4.5f));
                oos.writeObject(new Producto("Fuet", 5, 25, 2.5f));
                oos.writeObject(new Producto("Tocino", 10, 5, 1.5f));
                oos.writeObject(new Producto("Jamón York", 60, 50, 10.0f));
                oos.writeObject(new Producto("Cecina", 10, 15, 15.0f));
                oos.writeObject(new Producto("Mortadela", 20, 5, 20.5f));
                oos.writeObject(new Producto("Torreznos", 2340, 5, 13.7f));
                oos.writeObject(new Producto("Jamón Serrano", 10, 3, 12.5f));
                oos.writeObject(new Producto("Lacón ", 10, 15, 20.5f));

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            System.out.println("Fichero generado.");
        }

    }
}
