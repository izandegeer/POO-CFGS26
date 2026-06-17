package Examenes.ExamenesUltimos.appPiscinaMutxamel;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class AppPiscina {
    private static Set<Banyista> listaBanyistas = new HashSet<>();
    private static int numero;
    private static Scanner teclado = new Scanner(System.in);
    private static int contadorId = 1;

    public static void main(String[] args) {
        Banyista izan = new Adulto(contadorId, "Izan", 21);
        contadorId++;
        Banyista ivan = new Ninyo(contadorId, "Iván", 10, "722579659");
        contadorId++;
        Banyista kevin = new Invitado(contadorId, "Kevin", 19, LocalDate.now());
        contadorId++;

        listaBanyistas.addAll(List.of(izan, ivan, kevin));

        System.out.println("> Lista banyistas");
        for (Banyista banyista : listaBanyistas) {
            System.out.println(banyista.getNumero() + ". " + banyista.getNombre());
        }

        System.out.println("\n*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
        altaUsuario();
        mostrarInvitados();
    }

    public static void altaUsuario() {
        System.out.println("Alta de usuarios...");
        System.out.println("1. Adulto");
        System.out.println("2. Niños (<= 16 años)");
        System.out.println("3. Invitados (pase diario)");
        System.out.println("--------------------------");
        System.out.println("Elige un tipo:");
        System.out.print("> ");
        int opcionUsuario = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Introduce el nombre del nuevo bañista: ");
        System.out.print("> ");
        String nombre = teclado.nextLine();

        System.out.println("Introduce la edad: ");
        System.out.print("> ");
        int edad = teclado.nextInt();

        switch (opcionUsuario) {
            case 1: // Adulto
                Banyista adulto = new Adulto(contadorId, nombre, edad);
                listaBanyistas.add(adulto);
                contadorId++;
                cobrar(adulto);
                break;
            case 2: // Niño (<= 16a.)
                System.out.println("Introduce el teléfono de contacto del adulto responsable:");
                System.out.print("> ");
                String telefono = Integer.toString(teclado.nextInt());
                Banyista ninyo = new Ninyo(contadorId, nombre, edad, telefono);
                listaBanyistas.add(ninyo);
                contadorId++;
                cobrar(ninyo);
                break;
            case 3: // Invitados (pase diario)
                LocalDate fecha = LocalDate.now();
                System.out.println("Fecha de visita: " + fecha);
                Banyista invitado = new Invitado(contadorId, nombre, edad, LocalDate.now());
                listaBanyistas.add(invitado);
                contadorId++;
                cobrar(invitado);
                break;
        }
        System.out.println("[+] Bañista " + nombre + " añadido a la lista.");
    }

    public static void cobrar(Banyista banyista) {

    }

    public static void mostrarInvitados() {
        System.out.println("\n*** LISTA DE INVITADOS ***");
        for (Banyista banyista : listaBanyistas) {
            if (banyista instanceof Invitado) {
                System.out.println("[" +((Invitado) banyista).getFechaVisita() + "] " + banyista.getNombre() + " fue invitado.");
            }
        }
    }

    public static void eliminarInvitados() {

    }

    public static Set<Banyista> getListaBanyistas() {
        return listaBanyistas;
    }

    public static void setListaBanyistas(Set<Banyista> listaBanyistas) {
        AppPiscina.listaBanyistas = listaBanyistas;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        AppPiscina.contadorId = contadorId;
    }
}
