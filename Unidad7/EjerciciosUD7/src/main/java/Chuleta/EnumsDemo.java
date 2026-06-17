package Chuleta;

public class EnumsDemo {

    enum EstadoDocente {
        ACTIVO,
        EN_HUELGA,
        SERVICIOS_MINIMOS
    }

    static class Docente {
        String dni;
        EstadoDocente estado;

        Docente(String dni, EstadoDocente estado) {
            this.dni = dni;
            this.estado = estado;
        }

        @Override
        public String toString() {
            return "DNI " + dni + " -> " + estado;
        }
    }

    public static void main(String[] args) {
        usarComoAtributo();
        recorrerValues();
        compararYSwitch();
        nombreYPosicion();
    }

    static void usarComoAtributo() {
        System.out.println("===== Enum como atributo de una clase =====");
        Docente d1 = new Docente("12345678X", EstadoDocente.EN_HUELGA);
        Docente d2 = new Docente("87654321B", EstadoDocente.ACTIVO);
        System.out.println(d1);
        System.out.println(d2);
        d2.estado = EstadoDocente.SERVICIOS_MINIMOS;
        System.out.println("Tras cambiar estado: " + d2);
        System.out.println();
    }

    static void recorrerValues() {
        System.out.println("===== Recorrer todos los valores con values() =====");
        for (EstadoDocente estado : EstadoDocente.values()) {
            System.out.println("   - " + estado);
        }
        System.out.println("Total de estados posibles: " + EstadoDocente.values().length);
        System.out.println();
    }

    static void compararYSwitch() {
        System.out.println("===== Comparar con == y usar switch =====");
        EstadoDocente estado = EstadoDocente.EN_HUELGA;

        if (estado == EstadoDocente.EN_HUELGA) {
            System.out.println("Comparación con == : está en huelga");
        }

        switch (estado) {
            case ACTIVO:
                System.out.println("switch: trabajando con normalidad");
                break;
            case EN_HUELGA:
                System.out.println("switch: secundando la huelga");
                break;
            case SERVICIOS_MINIMOS:
                System.out.println("switch: cubriendo servicios mínimos");
                break;
        }
        System.out.println();
    }

    static void nombreYPosicion() {
        System.out.println("===== name(), ordinal() y valueOf() =====");
        EstadoDocente estado = EstadoDocente.SERVICIOS_MINIMOS;
        System.out.println("name() (texto): " + estado.name());
        System.out.println("ordinal() (posición): " + estado.ordinal());
        EstadoDocente desdeTexto = EstadoDocente.valueOf("ACTIVO");
        System.out.println("valueOf(\"ACTIVO\"): " + desdeTexto);
        System.out.println();
    }
}
