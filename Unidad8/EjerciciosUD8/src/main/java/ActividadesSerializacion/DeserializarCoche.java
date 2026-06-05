package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializarCoche {
    public static void main(String[] args) {

        int contador = 1;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/coche.ser"));
            ArrayList<Coche> listaCoches = (ArrayList<Coche>) inputStream.readObject();
            inputStream.close();
            for (Coche coche : listaCoches) {
                System.out.println(contador + ". Coche leído: " + coche + "...");
                contador++;
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("[x] Algo ha ido mal");
            exception.printStackTrace();
        }
    }
}
