package Practica4b;

public class ElTiempo {
    public double latitud; // latitud
    public double longitud; // longitud
    public double generationtime_ms; // tiempo de generación (ms)
    public int utc_offset_seconds; // desfase UTC (segundos)
    public String timezone; // zona horaria
    public String timezone_abbreviation; // abreviatura de zona horaria
    public double elevation; // elevación
    CurrentWeather current_weather; // tiempo actual

    static class CurrentWeather{
        public String time; // hora
        public int interval; // intervalo
        public double temperature; // temperatura
        public double windspeed; // velocidad del viento
        public int winddirection; // dirección del viento
        public int is_day; // es de día
        public int weathercode; // código del tiempo

    }
}
