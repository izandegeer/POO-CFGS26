# Chuleta: Cómo crear excepciones personalizadas

Una excepción personalizada es simplemente **una clase tuya que hereda de una clase de excepción** de Java. Sirve para dar errores con nombre y significado propios de tu programa (ej. `SaldoInsuficienteException`).

---

## 1. ¿De qué clase heredar? (checked vs unchecked)

| Heredas de... | Tipo | El compilador te obliga a... |
|---|---|---|
| **`Exception`** | Checked (comprobada) | Capturarla (`try/catch`) **o** declararla con `throws` |
| **`RuntimeException`** | Unchecked (no comprobada) | Nada, es opcional |

**Regla rápida:**
- Error que el programa **puede prever y recuperar** (saldo insuficiente, fichero no encontrado) → hereda de `Exception`.
- Error de **programación / dato inválido** que no se espera recuperar → hereda de `RuntimeException`.

---

## 2. Estructura mínima

Lo habitual es escribir **dos constructores**: uno con mensaje y otro con mensaje + causa.

```java
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }

    public SaldoInsuficienteException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
```

- `super(mensaje)` guarda el texto que luego ves con `getMessage()`.
- `super(mensaje, causa)` además guarda la excepción **original** que provocó esta (encadenamiento).

---

## 3. Añadir datos propios (opcional pero útil)

Puedes guardar información extra del error mediante atributos:

```java
public class SaldoInsuficienteException extends Exception {

    private final double saldoActual;
    private final double cantidadPedida;

    public SaldoInsuficienteException(double saldoActual, double cantidadPedida) {
        super("Saldo insuficiente: tienes " + saldoActual + " y pides " + cantidadPedida);
        this.saldoActual = saldoActual;
        this.cantidadPedida = cantidadPedida;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public double getCantidadPedida() {
        return cantidadPedida;
    }
}
```

---

## 4. Lanzarla con `throw`

Se lanza con la palabra `throw` (singular) y, si es checked, el método debe declararla con `throws` (plural):

```java
public void retirar(double cantidad) throws SaldoInsuficienteException {
    if (cantidad > saldo) {
        throw new SaldoInsuficienteException(saldo, cantidad);
    }
    saldo -= cantidad;
}
```

| Palabra | Para qué sirve |
|---|---|
| **`throw`** | Lanza una excepción concreta (un objeto) |
| **`throws`** | Declara en la firma del método que PUEDE lanzar esa excepción |

---

## 5. Capturarla con `try/catch`

```java
try {
    cuenta.retirar(500);
} catch (SaldoInsuficienteException e) {
    System.out.println("Error: " + e.getMessage());
    System.out.println("Te faltan: " + (e.getCantidadPedida() - e.getSaldoActual()));
}
```

---

## 6. Encadenar excepciones (envolver la causa)

Sirve para convertir una excepción técnica en una de tu dominio sin perder la original:

```java
try {
    // ... operación que falla con una excepción de bajo nivel
} catch (IOException e) {
    throw new DatosCorruptosException("No se pudo leer la configuración", e);
}
```

Así, en `getCause()` sigues teniendo la `IOException` original para depurar.

---

## 7. Errores típicos a evitar

- **No confundir `throw` (lanzar) con `throws` (declarar).**
- Si heredas de `Exception` (checked), **no olvides** el `throws` en el método o un `try/catch`.
- El nombre de la clase **debe acabar en `Exception`** por convención (`SaldoInsuficienteException`).
- No te "comas" la excepción con un `catch` vacío: como mínimo registra el mensaje.

---

## 8. Resumen en 4 pasos

1. **Crear la clase** `extends Exception` (checked) o `extends RuntimeException` (unchecked).
2. **Constructor(es)** que llamen a `super(mensaje)`.
3. **Lanzar** con `throw new MiException(...)` (y `throws` si es checked).
4. **Capturar** con `try/catch` y usar `getMessage()` / `getCause()`.
