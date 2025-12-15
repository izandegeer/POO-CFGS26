package org.example.Proyecto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class A266_GPT_CopistasDaltonicos_Final {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // Usamos StringBuilder para la salida rápida.
        StringBuilder resultado = new StringBuilder();
        while (true) {
            String lineaDimensiones = br.readLine();
            if (lineaDimensiones == null || lineaDimensiones.isEmpty()) break;

            StringTokenizer st = new StringTokenizer(lineaDimensiones);
            if (!st.hasMoreTokens()) break;
            int filas = Integer.parseInt(st.nextToken());
            if (!st.hasMoreTokens()) break;
            int columnas = Integer.parseInt(st.nextToken());

            if (filas == 0 && columnas == 0) break;

            casoDePrueba(filas, columnas, resultado);
        }
        System.out.print(resultado.toString());
    }

    public static void casoDePrueba(int filas, int columnas, StringBuilder resultado) throws IOException {

        // 1. Lectura del cuadro
        String[] cuadro = new String[filas];
        for (int i = 0; i < filas; i++) {
            cuadro[i] = br.readLine().toUpperCase();
        }

        // 2. Leer número de copistas
        int numCopistas = Integer.parseInt(br.readLine());

        // 3. ESTRUCTURA DE MAPEO FINAL:
        // Inicializamos un array para mapear todos los posibles caracteres (0-255) a sí mismos.
        char[] mapaFinal = new char[256];
        for (int i = 0; i < 256; i++) {
            mapaFinal[i] = (char) i;
        }

        // 4. Procesar copistas y actualizar el mapeo acumulativo
        for (int i = 0; i < numCopistas; i++) {
            String lineaCopia = br.readLine().toUpperCase();
            char colorOriginalCopista = lineaCopia.charAt(0);
            char colorNuevoCopista = lineaCopia.charAt(2);

            // Recorremos SOLO el mapa (256 posiciones) y no el cuadro completo (F*C).
            // Si el mapeo final de un color 'X' (mapaFinal[X])
            // coincide con el color que el copista NO distingue (colorOriginalCopista),
            // entonces el nuevo mapeo final para 'X' será el color que el copista DIBUJA (colorNuevoCopista).

            for (char c = 'A'; c <= 'Z'; c++) { // Solo necesitamos comprobar las letras mayúsculas
                if (mapaFinal[c] == colorOriginalCopista) {
                    mapaFinal[c] = colorNuevoCopista;
                }
            }

            // NOTA: Es posible que colores fuera del rango 'A'-'Z' (como ' ', números, o minúsculas
            // si no se hubiera hecho un .toUpperCase() en la lectura) necesiten ser incluidos
            // si el problema permite otros códigos de color. Para este problema, asumimos solo mayúsculas.
        }

        // 5. Impresión del resultado (aplicando el mapa final)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                char colorEntrada = cuadro[i].charAt(j);

                // Aplicamos la transformación final precalculada.
                resultado.append(mapaFinal[colorEntrada]);
            }
            resultado.append('\n');
        }
    }
}