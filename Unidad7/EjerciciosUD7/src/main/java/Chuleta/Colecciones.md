# Chuleta: ¿Cuándo usar cada colección?

Guía rápida para decidir qué estructura usar según lo que necesites.

---

## 1. Primero decide la FAMILIA

| Necesitas... | Familia | Interfaz |
|---|---|---|
| Guardar elementos **sin duplicados** | Conjunto | `Set` |
| Una **lista ordenada por posición** (con índice, permite duplicados) | Lista | `List` |
| Una **cola** para procesar por turnos | Cola | `Queue` / `Deque` |
| Asociar una **clave a un valor** | Diccionario | `Map` |

Una vez elegida la familia, eliges la implementación según si necesitas **orden** y según el **rendimiento**.

---

## 2. Conjuntos (Set) — sin duplicados

| Clase | Cuándo usarla | Orden |
|---|---|---|
| **HashSet** | Por defecto. Solo te importa que no haya duplicados y buscar rápido. El más rápido. | Ninguno |
| **LinkedHashSet** | Igual que HashSet pero necesitas conservar el **orden en que insertaste** los elementos. | Inserción |
| **TreeSet** | Necesitas los elementos **siempre ordenados** (alfabético/numérico) o métodos como `first()`, `last()`, rangos. | Natural / Comparator |

**Regla rápida:** `HashSet` salvo que necesites orden → entonces `LinkedHashSet` (orden de inserción) o `TreeSet` (orden ordenado).

---

## 3. Listas (List) — con índice y duplicados

| Clase | Cuándo usarla |
|---|---|
| **ArrayList** | Por defecto. Accedes mucho **por índice** (`get(i)`) y añades sobre todo al final. Lecturas rápidas. |
| **LinkedList** | Insertas/eliminas mucho **al principio o en el medio**, o la usas como cola/pila (`addFirst`, `addLast`). El acceso por índice es lento. |

**Regla rápida:** casi siempre `ArrayList`. Solo `LinkedList` si haces muchas inserciones/borrados en los extremos.

---

## 4. Colas (Queue / Deque)

| Clase / Interfaz | Cuándo usarla |
|---|---|
| **Queue** (FIFO) | Procesar elementos en el **orden en que llegan** (turnos, tareas pendientes, buffers). `offer` / `poll` / `peek`. |
| **Deque** (`ArrayDeque`) | Necesitas meter/sacar por **ambos extremos**. Sirve como **cola** (FIFO) o como **pila** (LIFO). Es la opción recomendada para pilas en vez de la antigua `Stack`. |

**Regla rápida:** turnos → `Queue`; pila o doble extremo → `Deque` (`ArrayDeque`).

---

## 5. Diccionarios (Map) — clave → valor

| Clase | Cuándo usarla | Orden de claves |
|---|---|---|
| **HashMap** | Por defecto. Asociar clave-valor y buscar por clave rápido. El más rápido. | Ninguno |
| **LinkedHashMap** | Igual que HashMap pero necesitas conservar el **orden de inserción** de las claves. | Inserción |
| **TreeMap** | Necesitas las claves **siempre ordenadas** o métodos como `firstKey()`, `lastKey()`, rangos. | Natural / Comparator |

**Regla rápida:** `HashMap` salvo que necesites orden → `LinkedHashMap` (inserción) o `TreeMap` (ordenado).

---

## 6. Resumen mental (decisión en 3 pasos)

1. **¿Pares clave-valor?** → `Map` (Hash / Linked / Tree).
2. **¿Sin duplicados?** → `Set` (Hash / Linked / Tree).
3. **¿Por turnos / extremos?** → `Queue` / `Deque`. **Si no**, lista normal → `ArrayList`.

Y dentro de cada familia, la elección entre Hash / Linked / Tree es siempre la misma idea:

| Sufijo | Significa |
|---|---|
| **Hash...** | El más rápido, **sin orden**. (opción por defecto) |
| **Linked...** | Mantiene el **orden de inserción**. |
| **Tree...** | Mantiene los elementos/claves **ordenados**. |

---

## 7. Tabla final de un vistazo

| Quiero... | Uso |
|---|---|
| Lista normal, acceso por índice | `ArrayList` |
| Muchas inserciones/borrados en extremos | `LinkedList` |
| Sin duplicados, rápido | `HashSet` |
| Sin duplicados, en orden de inserción | `LinkedHashSet` |
| Sin duplicados, ordenado | `TreeSet` |
| Cola por turnos (FIFO) | `Queue` (`LinkedList`) |
| Pila (LIFO) o doble extremo | `Deque` (`ArrayDeque`) |
| Clave-valor, rápido | `HashMap` |
| Clave-valor, orden de inserción | `LinkedHashMap` |
| Clave-valor, ordenado por clave | `TreeMap` |
