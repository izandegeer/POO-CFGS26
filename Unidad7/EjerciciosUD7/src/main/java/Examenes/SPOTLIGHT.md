# Spotlight de Exámenes — Programación POO (UD7)

Resumen, patrones recurrentes y apuntes prácticos de los exámenes hechos. Sirve como cheatsheet para futuros exámenes del mismo estilo.

---

## Vista rápida

| Examen | Carpeta | Tema | Clases | Restricciones / particularidades |
|---|---|---|---|---|
| **Mayo 2025** | `mayo25` | Parking Mutxamel | 5 | POO básica + interface + enum |
| **Abril 2025** | `abril25` | TicketMutxa (eventos) | 8 | **Sin lambdas/streams**; cola virtual con `Thread.sleep` |
| **Junio 2025** | `junio25` | 3 problemas (Squash + Recomendador + Piscina) | 9 | Excepciones personalizadas; encapsulación |
| **Clase 2026** | `clase26` | Lista Epstein | 5 | Lombok intensivo; `Map<Clase, Integer>` |
| **Abril 2026** | `abril26` | Elecciones App | 7 | **Sin lambdas/streams**; Lombok; regex `.matches()`; matriz 2x4 |

---

## Por examen

### mayo25 — Parking Mutxamel
- `Ticket implements Acciones` con `generar/recoger/pagar`
- `Estado` enum (PENDIENTE → GENERADO → RECOGIDO → PAGADO)
- `Parking` con `List<Ticket>` y validación de duplicados de matrícula
- `app1/app2/app3` como métodos `static` en `AppParking`
- **Truco**: `app3` implementa `Acciones` con **clase anónima** porque tiene 3 métodos (no se puede lambda)
- Generación aleatoria de matrícula: `4 dígitos + 3 letras de "BCDFGHJKLMNPQRSTVWXYZ"`

### abril25 — TicketMutxa
- Herencia `Festival/Concierto extends Evento` (abstract)
- `equals/hashCode` por **nombre + fecha** (requisito explícito)
- Cola virtual con `Thread.sleep(3000)` por posición decreciente
- `Collections.unmodifiableSet(set)` para devolver lista de solo lectura
- Carrito = `Map<Evento, Integer>` con tope 7
- `MetodoPago` enum con precio asociado
- **Truco crítico**: `comprador` empieza como `new Usuario("","")` placeholder; `autenticarse()` rellena sus campos al validar contra el Set

### junio25 — 3 problemas
**Problema 1 — Squash**: validación de string + parseo por sets
- `s.endsWith("F") && s.indexOf('F') == s.length()-1`
- `split("S", -1)` con **-1 para mantener segmentos vacíos**

**Problema 2 — Recomendador**: filtro + ordenación
- Filtro: minutos ≥ 30
- Ordenación ascendente por minutos con `Comparator` anónimo

**Problema 3 — App Piscina** (6 puntos):
- Excepción personalizada `EdadInvalidaException extends RuntimeException`
- **Doble validación diferente**:
  - edad < 0 → **mensaje sin crash** (validar antes de construir)
  - NIÑO con edad > 16 → **throw, con stack trace** (uncaught)
- Encapsulación con private fields + getters/setters
- `instanceof Invitado` + cast para filtrar por subclase
- `Iterator.remove()` para eliminar mientras iteras

### clase26 — Lista Epstein
- **Lombok intensivo**: `@Getter @Setter @ToString @EqualsAndHashCode @AllArgsConstructor`
- `Queue<Famoso>` (`LinkedList`) → `.poll()` desencola en orden
- `Map<Famoso, Integer>` requiere `@EqualsAndHashCode` para que Elon Musk × 3 cuente como 1 entry con valor 3
- `Estadistica implements Informes` con `verPoliticos / informeJuzgado / verRanking`
- Ordenaciones múltiples (país + nombre) con `Comparator` anónimo encadenado
- `EntradaDatos.java` proporcionado por el enunciado (recuperable de git con `git show <hash>:./path`)

### abril26 — Elecciones App
- Herencia `Nacional / Extranjero extends Votante`
- `validarDocumento` con regex: `"(\\d{8}|[XYZ]\\d{7})[A-Za-z]"` (acepta DNI **y** NIE reales)
- `FraudeException` que el caller captura (no crash)
- **Matriz `double[2][4]`**: fila 0 conteos, fila 1 porcentajes (rellena al final en `recuento()`)
- **Truco**: `verificarEmpadronamiento(votante)` **muta** el votante copiándole `nombre/poblacion/pais` del censo, para que los mensajes muestren el nombre real
- Helper compartido `Censo.mismaIdentidad(a, b)` evita duplicar el `instanceof` + cast en 3 sitios
- Test data pre-cargado en `yaHanVotado` para realismo del recuento por pueblos

---

## Patrones recurrentes (copy-paste rápido)

### 1. Scanner compartido (CRÍTICO)

```java
public class App {
    public static Scanner sc = new Scanner(System.in);
}
// otras clases: App.sc.nextLine()
```
> **NUNCA** crees Scanners auxiliares y los cierres — cerrar uno cierra `System.in` para todos.

### 2. Conteo en Map (sin lambdas)

```java
Map<X, Integer> contador = new HashMap<>();
for (X x : lista) {
    Integer c = contador.get(x);
    contador.put(x, (c == null ? 0 : c) + 1);
}
// Con lambdas (si están permitidas): contador.merge(x, 1, Integer::sum);
```

### 3. Ordenación con Comparator anónimo (sin lambdas)

```java
List<X> list = new ArrayList<>(coleccion);
list.sort(new Comparator<X>() {
    @Override
    public int compare(X a, X b) {
        int c = a.getCampo1().compareTo(b.getCampo1());
        if (c != 0) return c;
        return a.getCampo2().compareTo(b.getCampo2());
    }
});
```

### 4. Eliminar mientras iteras

```java
Iterator<X> it = lista.iterator();
while (it.hasNext()) {
    X x = it.next();
    if (condicion) {
        it.remove();   // ✓ seguro
    }
}
// NUNCA: for (X x : lista) lista.remove(x);  → ConcurrentModificationException
```

### 5. Excepción personalizada

```java
public class MiException extends RuntimeException {
    public MiException(String msg) { super(msg); }
}

// uso:
throw new MiException("mensaje");

// caller con captura:
try { ... }
catch (MiException e) { System.out.println(e.getMessage()); }
```

### 6. Enum con valor asociado

```java
public enum TipoUsuario {
    ADULTO(30), NIÑO(15), INVITADO(3.5);

    private final double precio;
    TipoUsuario(double precio) { this.precio = precio; }
    public double getPrecio() { return precio; }
}
```

### 7. Validación con `.matches()`

```java
// DNI: 8 dígitos + 1 letra
"12345678X".matches("\\d{8}[A-Za-z]")          // true

// NIE: X/Y/Z + 7 dígitos + 1 letra
"X1234567A".matches("[XYZ]\\d{7}[A-Za-z]")     // true

// Ambos en una sola regex
doc.matches("(\\d{8}|[XYZ]\\d{7})[A-Za-z]")
```

### 8. Generación aleatoria de strings

```java
private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ...";

StringBuilder sb = new StringBuilder();
Random r = new Random();
for (int i = 0; i < longitud; i++) {
    sb.append(CARACTERES.charAt(r.nextInt(CARACTERES.length())));
}
return sb.toString();
```

### 9. Polimorfismo con `instanceof` + cast

```java
for (Bañista b : lista) {
    if (b instanceof Invitado) {
        Invitado inv = (Invitado) b;
        if (inv.getFechaVisita().equals(LocalDate.now())) {
            // ...
        }
    }
}
```

### 10. Cola simulada con sleep

```java
for (int pos = cola.size(); pos >= 1; pos--) {
    System.out.println(" -- Estás en la posición " + pos + " de la cola virtual.");
    if (pos > 1) Thread.sleep(3000);   // no dormir tras la última
}
System.out.println("¡Es tu turno!");
```

### 11. Bucle de input válido

```java
while (true) {
    System.out.println("¿SÍ o NO?");
    String resp = sc.nextLine().trim().toUpperCase();
    if (resp.equals("SI") || resp.equals("NO")) {
        return resp;
    }
    // si no, vuelve a pedir
}
```

### 12. Validar y construir POJO

```java
int edad;
try {
    edad = Integer.parseInt(sc.nextLine().trim());
} catch (NumberFormatException e) {
    edad = -1;
}
if (edad < 0) {
    System.out.println("ERROR. ...");
    return;
}
```

---

## Trampas comunes ("gotchas")

| Problema | Solución |
|---|---|
| `Integer == Integer` falla > 127 | `.equals()` o `.intValue() ==` |
| `HashMap` no preserva orden | `LinkedHashMap` (inserción) o `TreeMap` (natural) |
| `Set` con duplicados aparentes | Falta `equals/hashCode` en la clase |
| Cerrar `Scanner` cierra `System.in` | **UN Scanner compartido `static`** |
| `nextInt()` deja `\n` colgando | Usar siempre `Integer.parseInt(sc.nextLine())` |
| Lombok no procesa con `javac` | Compilar con `mvn compile` |
| `split("X")` descarta vacíos al final | `split("X", -1)` los mantiene |
| `.equals()` rechaza mayúsculas/minúsculas | `.equalsIgnoreCase()` para input de teclado |
| Modificar List dentro de `for-each` | `Iterator.remove()` |
| `BigDecimal` no se compara con `==` | `.compareTo()` |

---

## Lombok básico

```java
@Getter @Setter        // genera get*/set* de todos los campos
@ToString              // toString() formato Clase(campo=valor, ...)
@EqualsAndHashCode     // equals + hashCode basados en todos los campos
@AllArgsConstructor    // constructor con todos los args
@NoArgsConstructor     // constructor vacío
@Data                  // todo lo anterior junto (excepto NoArgsConstructor)
```

**¿Cuándo `@EqualsAndHashCode` es CRÍTICO?**
- Cuando usas la clase como **clave de `Map`** o en un **`Set`**.
- Ejemplo: en `clase26`, `Map<Famoso, Integer>` cuenta visitas. Sin `@EqualsAndHashCode`, cada `new Famoso(...)` es un objeto distinto aunque tenga datos iguales → no se agrupan las 3 visitas de Elon Musk.

**Cómo compilar con Lombok:**
```bash
mvn compile -q
# NO funciona con javac directo sin annotation processing
```

---

## Caracteres especiales en Java

Java soporta Unicode en identificadores. Probado y funciona en macOS/UTF-8:

```java
public abstract class Bañista { ... }     // ✓ funciona
public class Niño extends Bañista { ... } // ✓ funciona
public enum TipoUsuario { NIÑO(15), ... } // ✓ funciona
```

**Pero compila con `-encoding UTF-8`** si usas `javac`:
```bash
javac -encoding UTF-8 -d /tmp/build src/main/java/.../*.java
```

> Para campos como `contraseña`, hemos preferido `contrasena` por seguridad de encoding al hacer commits/portabilidad, aunque la versión con ñ también funciona.

---

## Anatomía típica de un `main`

```java
public static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    // 1. Carga inicial de datos
    Censo.generarCenso();
    cargarDatosPrueba();

    // 2. Banner
    System.out.println("**** APP NOMBRE ****");

    // 3. Setup (preguntar X)
    System.out.println("Introduce la X:");
    String x = sc.nextLine().trim();

    // 4. Bucle principal hasta "salir"
    while (true) {
        System.out.println("Opción [A, B, SALIR]:");
        String op = sc.nextLine().trim().toUpperCase();
        if (op.equals("SALIR")) break;

        try {
            procesarOpcion(op);
        } catch (MiException e) {
            System.out.println(e.getMessage());
            continue;
        }
    }

    // 5. Cierre (recuento, estadísticas)
    recuento();
}
```

---

## Comandos útiles

```bash
# Compilar con Lombok
mvn compile -q

# Compilar sin Lombok (ej. mayo25, junio25)
javac -encoding UTF-8 -d /tmp/build src/main/java/Examenes/PAQUETE/*.java

# Ejecutar
java -cp target/classes Examenes.PAQUETE.AppPrincipal
java -cp /tmp/build Examenes.PAQUETE.AppPrincipal

# Test con stdin piped (rápido para flujos lineales)
printf "input1\ninput2\n3\nsalir\n" | java -cp target/classes Examenes.PAQUETE.App

# Test con expect (para flujos con valores aleatorios capturables del output)
expect <<'EOF'
spawn java -cp target/classes Examenes.PAQUETE.App
expect -re {patron (\S+)}
set var $expect_out(1,string)
send "$var\r"
EOF

# Recuperar archivos eliminados de git
git log --all --oneline -- ruta/al/archivo.java
git show <hash>:./ruta/al/archivo.java
```

---

## Estilo de output esperado (mensajes típicos)

| Tipo | Formato |
|---|---|
| Banner | `**** APP NOMBRE ****` |
| Separador | `----------------------------` |
| Listado | ` --Nombre: valor` o ` -- Nombre fulminado.` |
| Numerado | `[1].Nombre fecha` o `1 patricia 20 ADULTO` |
| Ranking | ` #N Nombre (valor)` |
| Error suave | `ERROR. Mensaje...` |
| Excepción | mensaje + stack trace (sale al lanzar) |
| Diálogo | `¿Pregunta?` + input usuario |

---

## Flujo recomendado al hacer un examen

1. **Leer el PDF entero** antes de tocar código (identificar restricciones tipo "sin lambdas")
2. **Mirar el diagrama UML** y mapearlo a archivos
3. **Crear todos los archivos en paralelo** (no uno a uno)
4. **Compilar** (`mvn compile` si Lombok, `javac -encoding UTF-8` si no)
5. **Test end-to-end** con `printf | java ...` (o `expect` si hay valores aleatorios)
6. **Verificar cada apartado del PDF** contra el output capturado
7. **Subir al repo** (zip o GitHub según pidan)

---

## Apartados pendientes manuales (recordatorios)

Los exámenes suelen tener tareas que **no son código**:
- Crear el repo de GitHub `EXAMEN_X` desde SourceTree
- Sincronizar el proyecto Maven con el remoto
- Generar un PDF con capturas de pantalla de las pruebas
- Subir el `.zip` o la URL del repo a AULES

Estas tareas no las hace Claude — son manuales del IDE/GitHub.
