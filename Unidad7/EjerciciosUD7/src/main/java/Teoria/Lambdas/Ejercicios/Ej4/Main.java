package Teoria.Lambdas.Ejercicios.Ej4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new Empleado("Luis", 1500, "15-07-2004"));
        listaEmpleados.add(new Empleado("Joserra", 2000, "27-03-2027"));
        listaEmpleados.add(new Empleado("Alex", 5, "01-01-1994"));
        listaEmpleados.add(new Empleado("Izan", 100, "02-03-1997"));
        listaEmpleados.add(new Empleado("Juan", 1800, "15-06-2003"));

        // Ordenar por nombre alfabéticamente
        System.out.println("> Ordenado alfabeticamente: ");

        Collections.sort(listaEmpleados, (empleado1, empleado2) -> empleado1.getNombre().compareTo(empleado2.getNombre()));
        listaEmpleados.sort(Comparator.comparing(empleado -> empleado.getNombre()));

        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado.getNombre());
        }

        // Ordenar por nombre alfabéticamente
        System.out.println("> Ordenado por salario: ");

//        Collections.sort(listaEmpleados, (empleado1, empleado2) -> empleado1.getSalario().compareTo(empleado2.getSalario()));
        listaEmpleados.sort(Comparator.comparing(empleado -> empleado.getSalario()));

        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado.getNombre());
        }

        // Ordenar por nombre alfabéticamente
        System.out.println("> Ordenado por fecha de contratación, con los más antiguos primero: ");

        Collections.sort(listaEmpleados, (empleado1, empleado2) -> empleado1.getNombre().compareTo(empleado2.getNombre()));
        listaEmpleados.sort(Comparator.comparing(empleado -> empleado.getNombre()));

        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado.getNombre());
        }
    }
}
