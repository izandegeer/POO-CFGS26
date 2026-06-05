package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.TreeMap;

public class DeserializacionMapa {
    public static void main(String[] args) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/mapaCoches.ser"));

            HashMap<String, Coche> mapaCoches = (HashMap<String, Coche>) inputStream.readObject();
            inputStream.close();

            TreeMap<String, Coche> mapaCoches2 = new TreeMap<>(mapaCoches);
            for (String claveCoche : mapaCoches2.keySet()){
                System.out.println("[" + claveCoche + "]  " + mapaCoches2.get(claveCoche));
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("[x] Algo ha ido mal");
            exception.printStackTrace();
        }

    }
}
