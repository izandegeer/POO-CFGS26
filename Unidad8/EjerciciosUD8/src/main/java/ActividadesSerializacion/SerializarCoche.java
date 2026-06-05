package ActividadesSerializacion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializarCoche {
    public static void main(String[] args) {

        ArrayList<Coche> listaCoches = new ArrayList<>();
        listaCoches.add(new Coche("1234CZV", 120));
        listaCoches.add(new Coche("1234ABC", 135));

            try {
                ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/coche.ser"));

                outputStream.writeObject(listaCoches);


                outputStream.close();
            } catch (IOException exception) {
                System.out.println("[x] Algo ha ido mal");
                exception.printStackTrace();
            }

        System.out.println("El objeto ha sido serializado en coche.ser");
    }
}
