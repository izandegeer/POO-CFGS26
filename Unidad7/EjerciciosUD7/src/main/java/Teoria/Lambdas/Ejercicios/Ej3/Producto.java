package Teoria.Lambdas.Ejercicios.Ej3;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    //ArrayList<Producto> listaProductos = new ArrayList<>();

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        //listaProductos.add(new Producto(nombre, precio, categoria));
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
