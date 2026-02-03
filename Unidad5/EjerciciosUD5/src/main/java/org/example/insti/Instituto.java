package org.example.insti;

import lombok.*;

import java.util.Objects;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//@Data
public class Instituto {

    @NonNull
    private String nombre;
    private String poblacion;

    public void setPoblacion(String poblacion) {
        this.poblacion = Objects.requireNonNullElse(poblacion, "La población no puede ser nulo");
    }
}
