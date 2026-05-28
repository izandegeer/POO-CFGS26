package Practica4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.TreeMap;

public class Practica2 {
    public static void main(String[] args) {
        String url = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";
        String ruta = "src/main/resources/criptomonedas.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String respuesta = consumirApi(url);
        if (respuesta == null) {
            System.out.println("No se ha podido consumir la API.");
            return;
        }
        System.out.println("a) Respuesta de la API:");
        System.out.println(respuesta);

        Type tipo = new TypeToken<Map<String, Map<String, Double>>>() {}.getType();
        Map<String, Map<String, Double>> precios = gson.fromJson(respuesta, tipo);

        guardar(gson, ruta, precios);
        System.out.println("\nb) Datos guardados en " + ruta);

        Map<String, Map<String, Double>> recuperado = cargar(gson, ruta);
        TreeMap<String, Map<String, Double>> ordenado = new TreeMap<>(recuperado);
        System.out.println("\nc) Precios recuperados (ordenados por moneda):");
        for (String moneda : ordenado.keySet()) {
            System.out.println(moneda + " -> " + ordenado.get(moneda));
        }
    }

    static String consumirApi(String url) {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> respuesta = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
            return respuesta.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void guardar(Gson gson, String ruta, Map<String, Map<String, Double>> datos) {
        try (FileWriter escritor = new FileWriter(ruta)) {
            gson.toJson(datos, escritor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Map<String, Double>> cargar(Gson gson, String ruta) {
        Type tipo = new TypeToken<Map<String, Map<String, Double>>>() {}.getType();
        try (FileReader lector = new FileReader(ruta)) {
            return gson.fromJson(lector, tipo);
        } catch (IOException e) {
            e.printStackTrace();
            return new TreeMap<>();
        }
    }
}
