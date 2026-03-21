package Examenes;

import java.util.HashMap;
import java.util.Scanner;

public class Practico24 {
    static HashMap<String, String> respuestas = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String rolChatbot = "Chatbot: ";
        String rolusuario = "Tu: ";

        String opcion = "";
        crearRespuestas();

        System.out.println(rolChatbot + "Bienvenido! Escribe <salir> cuando quieras acabar la conversación.");

        while (!opcion.equalsIgnoreCase("salir")){
            System.out.print(rolusuario);
            opcion = teclado.nextLine().toLowerCase();

            if (respuestas.containsKey(opcion)){
                System.out.println(rolChatbot + respuestas.get(opcion));
            } else {
                System.out.println(rolChatbot + "No te entiendo :(");
            }
        }
    }

    public static void crearRespuestas(){
        respuestas.put("cómo estás", "¡Estoy listo para ayudarte!");
        respuestas.put("hola", "Hola, ¿En qué te puedo ayudar?");
        respuestas.put("adiós", "¡Hasta luego!");
        respuestas.put("gracias", "¡De nada!");
        respuestas.put("salir", "¡Adiós!");
    }
}
