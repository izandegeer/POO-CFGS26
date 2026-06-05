package Practica4b;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Clima {
    public static void main(String[] args) {
        try {

            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=38.41921088667074&longitude=-0.4464988854601825&current_weather=true"; // url de la api

            URL url = new URL(apiUrl); // url
            HttpURLConnection con = (HttpURLConnection) url.openConnection(); // conexión
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); // lector de entrada
            StringBuilder response = new StringBuilder(); // respuesta
            String linea;
            while ((linea = in.readLine()) != null) {
                response.append(linea);
            }
            in.close();

            Gson gson = new Gson(); // gson
            ElTiempo weather = gson.fromJson(response.toString(), ElTiempo.class); // tiempo

            System.out.println("Clima actual en Mutxamel:");
            System.out.println("Temperatura: " + weather.current_weather.temperature + "°C");
            System.out.println("Viento: " + weather.current_weather.windspeed + " km/h");
            System.out.println("Hora del dato: " + weather.current_weather.time);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
