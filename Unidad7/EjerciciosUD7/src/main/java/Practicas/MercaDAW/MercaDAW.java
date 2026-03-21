package Practicas.MercaDAW;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

@Getter
public class MercaDAW {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static Random random = new Random();

    static int cantidadUsuarios = random.nextInt(15);

    public static void generarClientes() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < cantidadUsuarios; i++) {
            String usuario = "";
            String contrasenya = "";

            for (int j = 0; j < 8; j++) {
                usuario += caracteres.charAt(random.nextInt(caracteres.length()));
            }
            for (int j = 0; j < 8; j++) {
                contrasenya += caracteres.charAt(random.nextInt(caracteres.length()));
            }

            listaClientes.add(new Cliente(usuario, contrasenya, "Calle falsa, 123", null, false));
        }
    }



}
