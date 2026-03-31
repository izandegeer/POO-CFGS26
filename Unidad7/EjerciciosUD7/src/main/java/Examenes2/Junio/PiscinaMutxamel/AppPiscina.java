package Examenes2.Junio.PiscinaMutxamel;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

@Getter
@Setter
public class AppPiscina {
    private static ArrayList<Banyista> listaBanyistas = new ArrayList<>();
    private static int numero;
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
//        altaUsuario();
        listaBanyistas.add(new Adulto(1, "Patricia", 20, TipoUsuario.ADULTO));
        listaBanyistas.add(new Adulto(2, "Pablo", 30, TipoUsuario.ADULTO));
        listaBanyistas.add(new Nino(3, "Pepe", 12, TipoUsuario.NINO, "34565432"));
        listaBanyistas.add(new Nino(4, "Carla", 8, TipoUsuario.NINO, "8569512"));
        listaBanyistas.add(new Invitado(5, "Fran", 40, TipoUsuario.INVITADO));
        listaBanyistas.add(new Invitado(6, "Marta", 12, TipoUsuario.INVITADO));

        mostrarInvitados();
    }

    public static void cobrar(Banyista banyista) {
        System.out.println("Nuevo bañista creado.");
        banyista.pagar();
    }

    public static void altaUsuario() {
        System.out.println("Alta de usuarios...");
        System.out.println("    1. Adulto");
        System.out.println("    2. Niños (<=16 años)");
        System.out.println("    3. Invitados (pase diario)");
        System.out.println("------------------------------");
        System.out.print("Elige un tipo: ");
        int opcion = teclado.nextInt();
        teclado.nextLine();


        switch (opcion) {
            case 1:
                System.out.print("Introduce el nombre del nuevo bañista: ");
                String nombre = teclado.nextLine();

                System.out.print("Introduce la edad: ");
                int edad = teclado.nextInt();
                teclado.nextLine();

                Adulto adulto = new Adulto(numero, nombre, edad, TipoUsuario.ADULTO);
                cobrar(adulto);
                break;
            case 2:
                System.out.print("Introduce el nombre del nuevo bañista: ");
                nombre = teclado.nextLine();

                System.out.print("Introduce la edad: ");
                edad = teclado.nextInt();
                teclado.nextLine();
                if (edad > 16) {
                    throw new EdadException();
                }

                Nino nino = new Nino(numero, nombre, edad, TipoUsuario.NINO);
                cobrar(nino);
                break;
            case 3:
                System.out.print("Introduce el nombre del nuevo bañista: ");
                nombre = teclado.nextLine();

                System.out.print("Introduce la edad: ");
                edad = teclado.nextInt();
                teclado.nextLine();

                Invitado invitado = new Invitado(numero, nombre, edad, TipoUsuario.INVITADO);
                cobrar(invitado);
                break;
            default:
                System.out.println("Tipo no permitido.");
                break;
        }
    }

    public static void mostrarInvitados() {
        System.out.println("Lista de invitados el día de hoy: ");


        for (Banyista banyista : listaBanyistas) {
            System.out.println(banyista.getNumero() + ". " + banyista.getNombre() + " (" + banyista.getEdad() + ") - " + banyista.getTipo());
        }

        Iterator<Banyista> it = listaBanyistas.iterator();

        while (it.hasNext()) {
            Banyista banyista1 = it.next();

            if (banyista1 instanceof Invitado) {
                it.remove();
            }
        }
    }

    public static void eliminarInvitados() {

    }
}
