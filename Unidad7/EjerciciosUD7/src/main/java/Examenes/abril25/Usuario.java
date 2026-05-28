package Examenes.abril25;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Usuario implements Acciones {

    private String nombre_usuario;
    private String contrasena;
    private Map<Evento, Integer> carritoCompra;

    public Usuario(String nombre_usuario, String contrasena) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.carritoCompra = new HashMap<>();
    }

    public String getNombreUsuario() {
        return nombre_usuario;
    }

    public void setNombreUsuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Map<Evento, Integer> getCarritoCompra() {
        return carritoCompra;
    }

    public void anyadirAlCarrito(Evento evento, int cantidad) {
        int actual = carritoCompra.getOrDefault(evento, 0);
        if (actual + cantidad > 7) {
            System.out.println("No puedes añadir más de 7 entradas...");
            return;
        }
        carritoCompra.put(evento, actual + cantidad);
    }

    public void setCarrito(Evento evento, int delta) {
        int actual = carritoCompra.getOrDefault(evento, 0);
        int nuevo = actual + delta;
        if (nuevo < 0 || nuevo > 7) {
            System.out.println("No puedes realizar la operación (cantidad entradas=min 0 y máx 7).");
            return;
        }
        carritoCompra.put(evento, nuevo);
    }

    public void verCarrito() {
        for (Map.Entry<Evento, Integer> entrada : carritoCompra.entrySet()) {
            Evento evento = entrada.getKey();
            int cantidad = entrada.getValue();
            double total = cantidad * evento.getPrecio();
            System.out.println("Carrito: " + cantidad + " entradas para " + evento.getNombre()
                    + ". Importe total: " + total + "€. Gastos de gestión: por calcular.");
        }
    }

    @Override
    public boolean autenticarse(Set<Usuario> usuariosRegistrados) {
        System.out.println("Inicia sesión");
        System.out.println("    Usuario:");
        String user = AppCompraEntradas.sc.nextLine().trim();
        System.out.println("    Contraseña:");
        String pass = AppCompraEntradas.sc.nextLine().trim();

        for (Usuario u : usuariosRegistrados) {
            if (u.getNombreUsuario().equals(user) && u.getContrasena().equals(pass)) {
                this.nombre_usuario = user;
                this.contrasena = pass;
                return true;
            }
        }
        return false;
    }

    @Override
    public void pagar() {
        while (true) {
            System.out.println("Elige un método de pago:");
            for (MetodoPago m : MetodoPago.values()) {
                System.out.println(m.name() + " (gastos de gestión asociados: " + m.getPrecio() + "€).");
            }
            System.out.println("Opción:");
            String opcion = AppCompraEntradas.sc.nextLine().trim().toUpperCase();
            try {
                MetodoPago metodo = MetodoPago.valueOf(opcion);
                System.out.println("Realizando pago con " + metodo.name()
                        + " (+ " + metodo.getPrecio() + " € de gastos de gestión)");
                System.out.println("MUCHAS GRACIAS. DISFRUTA DEL EVENTO!");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println("Método de pago no válido. Vuelve a intentarlo.");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario u = (Usuario) o;
        return Objects.equals(nombre_usuario, u.nombre_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre_usuario);
    }
}
