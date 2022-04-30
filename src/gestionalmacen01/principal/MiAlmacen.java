/**
 *  MiAlmacen
 *  Programa principal de gestión de un almacén de productos
 *  implementa un CRUD ( Creat, Read, Update, Delete) ofreciendo varios
 *  informes.
 */
package gestionalmacen01.principal;

import java.util.Scanner;

import gestionalmacen01.modelo.ModeloAbs;
import gestionalmacen01.modelo.ModeloArrayList;
import gestionalmacen01.modelo.Producto;

//Completar los métodos
public class MiAlmacen {
    // Defino como estaticas para que puedan usarse
    // dentro de la clase sin necesidad de pasarlas como
    // parametros.
    static private ModeloAbs almacen;
    static private Scanner sc;

    public static void main(String[] args) {
        almacen = new ModeloArrayList();
        sc = new Scanner(System.in);
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerOpcion(1, 9);
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    consultar();
                    break;
                case 3:
                    borrar();
                    break;
                case 4:
                    modificarPrecio();
                    break;
                case 5:
                    comprar();
                    break;
                case 6:
                    vender();
                    break;
                case 7:
                    listar();
                    break;
                case 8:
                    listarPocoStock();
                    break;
            }
            System.out.println("\n---------------------------- ");
            System.out.print("Pulse enter para continuar");
            sc.nextLine();
        } while (opcion != 9);
        sc.close();

    }

    private static void mostrarMenu() {
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al mínimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opción (1-9)");
    }

    // Lee un entero del System.in que este comprendido entre primero y ultimo
    private static int leerOpcion(int primero, int ultimo) {
        int valor = leerEntero();
        while (valor < primero || valor > ultimo) {
            valor = leerEntero();
        }
        return valor;
    }

    // Metodos Auxiliares leerFloat y LeerEntero,
    // Lee de la System.in con el scanner sc y controlan la excepcion de
    // NumberFormatException

    static private int leerEntero() {
        boolean error = false;
        int valor = 0;
        String cadena;
        do {
            error = false;
            try {
                // Intento leer directamente un entero
                cadena = sc.nextLine();
                valor = Integer.parseInt(cadena);

            } catch (NumberFormatException e) {
                System.out.print("Error en formato. Vuelva a intentarlo: ");
                error = true;
            }
        } while (error);
        return valor;
    }

    static private float leerFloat() {
        // Implementar
        float valor = 0.0f;
        boolean error = false;
        String cadena;

        do {
            error = false;
            try {
                // Intento leer directamente un float
                cadena = sc.nextLine();
                valor = Float.parseFloat(cadena);
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato");
                error = true;
            }
        } while (error);

        return valor;
    }

    // Muestra los datos de un producto a partir de su codigo

    private static void consultar() {
        System.out.println("<CONSULTA>");
        System.out.print("Introduzca codigo:");
        int codigo = leerEntero();
        Producto p = almacen.buscarProducto(codigo);
        if (p != null) {
            System.out.println("PRODUCTO\n" + p);
        }

    }

    // Borrar un producto a partir de su codigo

    private static void borrar() {
        System.out.println("<ELIMINAR>");
        // IMPLEMENTAR
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        boolean borrar = almacen.borrarProducto(codigo);
        if (borrar) {
            System.out.println("Se ha borrado el producto con codigo " + codigo + " correctamente");
        } else {
            System.out.println("El producto no se encuentra en el almacen");
        }

    }

    // Cambia el precio de un producto a partir de su codigo
    private static void modificarPrecio() {
        System.out.println("<MODIFICAR PRECIO>");
        // IMPLEMENTAR
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        Producto p = almacen.buscarProducto(codigo);

        if (p != null) {

            System.out.print("Introduzca precio nuevo: ");
            float nuevoPrecio = leerFloat();
            while (nuevoPrecio < 0) {
                System.out.println("El precio debe ser mayor que 0");
                System.out.print("Introduzca precio nuevo: ");
                nuevoPrecio = leerFloat();
            }
            // Modificar el precio sobre el objeto
            p.setPrecio(nuevoPrecio);
            // Aplicar cambios
            almacen.modificarProducto(p);
            System.out.println("PRECIO MODIFICADO\n" + p);
        }

    }

    // Incrementa el stock
    private static void comprar() {
        System.out.println("<COMPRAR>");
        // IMPLEMENTAR
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        Producto p = almacen.buscarProducto(codigo);

        if (p != null) {

            System.out.print("Introduzca la cantidad que desea comprar: ");
            int compra = leerEntero();
            while (compra < 0) {
                System.out.println("La cantidad debe ser mayor que 0");
                System.out.print("Introduzca la cantidad que desea comprar: ");
                compra = leerEntero();
            }
            // Modificar el stock sobre el objeto
            p.setStock(p.getStock() + compra);
            // Aplicar cambios
            almacen.modificarProducto(p);
            System.out.println("STOCK MODIFICADO\n" + p);
        }
    }

    // Decrementa el stock
    private static void vender() {
        System.out.println("<VENDER>");
        // IMPLEMENTAR
        System.out.print("Introduzca codigo: ");
        int codigo = leerEntero();
        Producto p = almacen.buscarProducto(codigo);

        if (p != null) {

            System.out.print("Introduzca la cantidad que desea vender: ");
            int venta = leerEntero();
            while (venta < 0) {
                System.out.println("La cantidad debe ser mayor que 0");
                System.out.print("Introduzca la cantidad que desea vender: ");
                venta = leerEntero();
            }
            // Modificar el stock sobre el objeto

            p.setStock(p.getStock() - venta);
            // Compruebo que el stock no quede en negativo, si queda no se vende el
            // producto
            if (p.getStock() < 0) {
                System.out.println("Lo siento, no disponemos de tanto stock");
                p.setStock(p.getStock() + venta);
            } else {
                // Aplicar cambios
                almacen.modificarProducto(p);
                System.out.println("STOCK MODIFICADO\n" + p);
            }
        }

    }

    // Listado de todos los productos
    private static void listar() {
        System.out.println("<LISTAR>");
        almacen.listarProductosTodos();
    }

    // Listado de todos los productos con stock inferior a stock minimo
    private static void listarPocoStock() {
        System.out.println("<LISTAR STOCK BAJO MINIMOS>");
        almacen.listarProductosStockMin();
    }

    // Solicita datos al usuario para dar de alta un nuevo producto
    // El codigo no se puede repetir
    private static void crear() {
        System.out.println("<NUEVO PRODUCTO>");
        // IMPLEMENTAR
        System.out.print("Introduzca nombre del producto: ");
        String nombre = sc.nextLine();

        System.out.print("Introduzca stock del producto: ");
        int stock = leerEntero();

        while (stock < 0) {
            System.out.println("El stock debe ser mayor que 0");
            System.out.print("Introduzca stock del producto: ");
            stock = leerEntero();
        }
        System.out.print("Introduzca stock minimo recomendado del producto: ");
        int stock_min = leerEntero();
        while (stock_min < 0) {
            System.out.println("El stock minimo debe ser mayor que 0");
            System.out.print("Introduzca stock minimo recomendado del producto: ");
            stock_min = leerEntero();
        }

        System.out.print("Introduzca precio del producto: ");
        float precio = leerFloat();
        while (precio < 0) {
            System.out.println("El precio debe ser mayor que 0");
            System.out.print("Introduzca precio del producto: ");
            precio = leerFloat();
        }

        // Al utilizar un codigo auto incrementado evito que se puedan repetir los
        // codigos
        Producto p = new Producto(nombre, stock, stock_min, precio);

        almacen.insertarProducto(p);

    }

}
