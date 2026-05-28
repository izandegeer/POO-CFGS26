package Examenes.junio25;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AppPiscina {

    static List<Bañista> listaBañistas = new ArrayList<>();
    static int numero = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatosEjemplo();

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
            System.out.println("1. Alta de usuario");
            System.out.println("2. Mostrar invitados de hoy");
            System.out.println("3. Eliminar invitados de hoy");
            System.out.println("4. Imprimir lista de bañistas");
            System.out.println("0. Salir");
            System.out.println("Opción:");
            int op = leerEntero();
            switch (op) {
                case 1:
                    altaUsuario();
                    break;
                case 2:
                    mostrarInvitados();
                    break;
                case 3:
                    imprimirLista();
                    eliminarInvitados();
                    imprimirLista();
                    break;
                case 4:
                    imprimirLista();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void cargarDatosEjemplo() {
        listaBañistas.add(new Adulto(1, "patricia", 20, TipoUsuario.ADULTO));
        listaBañistas.add(new Adulto(2, "pablo", 30, TipoUsuario.ADULTO));
        listaBañistas.add(new Niño(3, "pepe", 12, TipoUsuario.NIÑO, "34565432"));
        listaBañistas.add(new Niño(4, "carla", 8, TipoUsuario.NIÑO, "8569512"));
        listaBañistas.add(new Invitado(5, "Fran", 40, TipoUsuario.INVITADO));
        listaBañistas.add(new Invitado(6, "Marta", 12, TipoUsuario.INVITADO));
        numero = 6;
    }

    public static void altaUsuario() {
        System.out.println("*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
        System.out.println("Alta de usuarios...");
        System.out.println("   1. Adulto");
        System.out.println("   2. Niños (<=16 años)");
        System.out.println("   3. Invitados (pase diario)");
        System.out.println("----------------------------------");
        System.out.println("Elige un tipo:");
        int tipoOpcion = leerEntero();

        TipoUsuario tipo;
        switch (tipoOpcion) {
            case 1:
                tipo = TipoUsuario.ADULTO;
                break;
            case 2:
                tipo = TipoUsuario.NIÑO;
                break;
            case 3:
                tipo = TipoUsuario.INVITADO;
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Introduce el nombre del nuevo bañista:");
        String nombre = sc.nextLine().trim();

        System.out.println("Introduce la edad:");
        int edad = leerEntero();

        if (edad < 0) {
            System.out.println("ERROR. No puede insertar bañistas que no han nacido.");
            return;
        }

        if (tipo == TipoUsuario.NIÑO && edad > 16) {
            throw new EdadInvalidaException("ERROR al crear un NIÑO. Edad " + edad + " no permitida");
        }

        numero++;
        Bañista nuevo;
        switch (tipo) {
            case ADULTO:
                nuevo = new Adulto(numero, nombre, edad, tipo);
                break;
            case NIÑO:
                System.out.println("Introduce el teléfono de contacto del adulto responsable:");
                String tel = sc.nextLine().trim();
                nuevo = new Niño(numero, nombre, edad, tipo, tel);
                break;
            case INVITADO:
                nuevo = new Invitado(numero, nombre, edad, tipo);
                break;
            default:
                return;
        }

        listaBañistas.add(nuevo);
        System.out.println("Nuevo bañista creado.");
        cobrar(nuevo);
    }

    public static void cobrar(Bañista bañista) {
        bañista.pagar();
    }

    public static void mostrarInvitados() {
        System.out.println("*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
        System.out.println("Lista de invitados en el día de hoy:");
        for (Bañista b : listaBañistas) {
            if (b instanceof Invitado) {
                Invitado inv = (Invitado) b;
                if (inv.getFechaVisita().equals(LocalDate.now())) {
                    System.out.println("Número: " + inv.getNumero()
                            + " - Nombre: " + inv.getNombre()
                            + " - Edad: " + inv.getEdad());
                }
            }
        }
    }

    public static void eliminarInvitados() {
        System.out.println("Eliminando invitados de hoy...");
        Iterator<Bañista> it = listaBañistas.iterator();
        while (it.hasNext()) {
            Bañista b = it.next();
            if (b instanceof Invitado) {
                Invitado inv = (Invitado) b;
                if (inv.getFechaVisita().equals(LocalDate.now())) {
                    it.remove();
                }
            }
        }
    }

    public static void imprimirLista() {
        for (Bañista b : listaBañistas) {
            System.out.println(b);
        }
    }

    private static int leerEntero() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -999999;
        }
    }
}
