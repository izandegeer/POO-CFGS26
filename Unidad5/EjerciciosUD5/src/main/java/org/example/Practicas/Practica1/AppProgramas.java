package org.example.Practicas.Practica1;

public class AppProgramas {
    /**
     * Este es el metodo principal
     * Se utiliza para crear una cadena y un programa con director
     * añade empleados e invitados, y muestra el estado del programa
     */
    public static void main(String[] args) {
        //creamos una cadena de tv
        Cadena antena3 = new Cadena("Antena 3");
        System.out.println(antena3);
        //creamos un programa
        Programa el_hormiguero = new Programa("El Hormiguero", antena3, "Director1");
        System.out.println(el_hormiguero);
        System.out.println(antena3);
        //insertamos empleados en el programa
        el_hormiguero.crearEmpleado("Pablo Motos", "presentador", null);
        System.out.println(el_hormiguero);
        //ver empleados del programa
        System.out.println(el_hormiguero.getListaEmpleados());
        //insertamos invitados en el programa
        el_hormiguero.crearInvitado("Aitana", "cantante", 1);
        //ver invitados del programa
        System.out.println(el_hormiguero.getListaInvitados());
    }
}
