package ActividadesSerializacion;

public class Jefe extends Empleado{
    private String departamente;

    public Jefe(String nombre, double salario, String departamente) {
        super(nombre, salario);
        this.departamente = departamente;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "departamente='" + departamente + '\'' +
                '}';
    }
}
