package Examenes.abril25;

import java.util.Set;

public interface Acciones {
    void pagar();
    boolean autenticarse(Set<Usuario> usuariosRegistrados);
}
