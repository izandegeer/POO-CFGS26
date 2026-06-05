package ActividadesSerializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SerializacionMapa {
    public static void main(String[] args) {
        HashMap<String, Coche> mapaCoches = new HashMap<>();

        mapaCoches.put("Ford Focus", new Coche("0372CZB", 96));
        mapaCoches.put("Lamborghini Gallardo", new Coche("9231AKD", 350));
        mapaCoches.put("Wolkswagen Golf", new Coche("1234ABC", 123));
        mapaCoches.put("Mazda CX3", new Coche("9485OPC", 29));

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/main/resources/mapaCoches.ser"));
            output.writeObject(mapaCoches);
            output.close();
        } catch (IOException exception) {
            System.out.println("[x] Algo ha ido mal al serializar.");
            exception.printStackTrace();
        }

        System.out.println("El mapa ha sido serializado en mapaCoches.ser");
    }
}
