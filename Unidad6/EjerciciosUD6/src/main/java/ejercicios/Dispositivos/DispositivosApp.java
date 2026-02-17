package ejercicios.Dispositivos;

import java.util.ArrayList;

public class DispositivosApp {
    public static void main(String[] args) {
        ArrayList <Dispositivo> listaDispositivos = new ArrayList<>();

        AireAcondicionado aire = new AireAcondicionado();
        ParlanteInteligente alexa = new ParlanteInteligente();
        Televisor tv = new Televisor();

        listaDispositivos.add(aire);
        listaDispositivos.add(alexa);
        listaDispositivos.add(tv);

        System.out.println("APP DISPOSITIVOS");
        System.out.println("----------------");

        System.out.println("{App} Encendiendo dispositivos...");
        for (Dispositivo dispositivo : listaDispositivos) {
            System.out.print("- ");
            dispositivo.encender();
        }

        System.out.println("{App} Sincronizando dispositivos...");
        for (Dispositivo dispositivo : listaDispositivos) {
            if (dispositivo instanceof ControlRemoto) {
                System.out.print("- ");
                ((ControlRemoto) dispositivo).sincronizar();
            }
        }

        System.out.println("{App} Mostrando el estado de los dispositivos...");
        for (Dispositivo dispositivo : listaDispositivos) {
            System.out.print("- ");
            dispositivo.mostrarEstado();
        }

        System.out.println("{App} Apagando dispositivos...");
        for (Dispositivo dispositivo : listaDispositivos) {
            dispositivo.apagar();
        }
    }

    Dispositivo nevera = new Dispositivo("Nevera Hisense") {
        @Override
        public void encender() {

        }
    };

    Dispositivo proyector = new Dispositivo("Optoma") {
        @Override
        public void encender() {
            System.out.println("Encendiendo proyector con ajuste de brillo");
            if (isEstado()){
                System.out.println("El proyector ya esta encendido ");
            }else {
                System.out.println("Encendiendo proyector");

            }
        }
    };

    ControlRemoto proyector_sinc = new ControlRemoto() {
        @Override
        public void sincronizar() {
            System.out.println("Sincronizando proyector con control remoto de presentación... ");
        }
    };

    Dispositivo horno_ia = new Dispositivo("Horno chat gpt") {
        @Override
        public void encender() {
            System.out.println("Calentando horno con ajuste automático de temperatura...");
            if (isEstado()){
                System.out.println("El horno ya esta encendido");
            }else {
                System.out.println("Apagando horno");
            }
        }
    };
}
