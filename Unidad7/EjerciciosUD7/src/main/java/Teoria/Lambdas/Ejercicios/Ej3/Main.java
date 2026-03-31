package Teoria.Lambdas.Ejercicios.Ej3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto("SmartPhone", 150.0, "Eléctronica"));
        listaProductos.add(new Producto("Laptop", 900.0, "Eléctronica"));
        listaProductos.add(new Producto("Tablet", 200.0, "Eléctronica"));
        listaProductos.add(new Producto("Mocho", 3.0, "Doméstica"));
        listaProductos.add(new Producto("Escoba", 23.0, "Doméstica"));
        listaProductos.add(new Producto("Trapo", 1.0, "Doméstica"));

        String categoriaBuscada = "Eléctronica";
        double precioBuscado = 100.0;

        FiltroProducto filtroProducto = producto -> producto.getCategoria().equals(categoriaBuscada) && producto.getPrecio() > precioBuscado;

        List<Producto> productosFiltrados = new ArrayList<>();

        for (Producto producto : listaProductos){
            if (filtroProducto.filtrar(producto)){
                productosFiltrados.add(new Producto(producto.getNombre(), producto.getPrecio()));
            }
        }

        System.out.println("Productos filtrados (" + categoriaBuscada + "): ");
        for (Producto producto : productosFiltrados){
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio() + "€");
        }
    }
}
