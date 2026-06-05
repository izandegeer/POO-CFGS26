package ActividadesSerializacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializacionEmpresa {
    public static void main(String[] args) {

        int contador = 1;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/listaEmpresa.ser"));
            ArrayList<Empleado> listaEmpresa = (ArrayList<Empleado>) inputStream.readObject();
            inputStream.close();
            for (Empleado empleado : listaEmpresa) {
                System.out.println(contador + ". Empleado leído: " + empleado);
                contador++;
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("[x] Algo ha ido mal");
            exception.printStackTrace();
        }
    }
}
