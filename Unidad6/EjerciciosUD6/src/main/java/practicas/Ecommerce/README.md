# Ejercicios Unidad 6 — Herencia y Polimorfismo

Proyecto Java con ejercicios de la **Unidad 6** del módulo de Programación Orientada a Objetos (CFGS DAW 2025-26).

## Estructura del proyecto

```
src/
├── main/java/
│   ├── teoria/Restaurante/       # Ejemplo de teoría
│   ├── ejercicios/
│   │   ├── Empleados/            # Ejercicio 1 — Empleados
│   │   └── Streaming/            # Ejercicio 2 — Plataforma de streaming
│   ├── baterias/                 # Batería — Red social
│   └── practicas/Ecommerce/     # Práctica — Tienda online
└── test/java/
    └── practicas/Ecommerce/     # Tests de la práctica
```

## Contenido

### Práctica: E-commerce

Simulación de una tienda online con distintos métodos de pago. Incluye diagrama UML y tests unitarios.

- **`MetodoPago`** — Clase abstracta con el método `procesarPago(double importe)`
- **`Tarjeta`** — Pago con tarjeta de crédito (VISA, MASTERCARD, MAESTRO). Valida número de 16 dígitos y tipo.
- **`PayPal`** — Pago con cuenta PayPal. Valida email y saldo disponible.
- **`Bizum`** — Pago con Bizum. Valida teléfono de 9 dígitos y PIN aleatorio.
- **`Tienda`** — Clase principal con menú interactivo para elegir método de pago.
