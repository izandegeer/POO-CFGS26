# Práctica 1. El Formiguero y la Rebelión

![](img/programacion-orientada-objetos.png)

## ÍNDICE
1. [Intro](https://github.com/pbendom3/POO_DAW/new/main/POO_daw/src/main/java/Biblio#1-intro)
2. [Estructura de clases](#2-estructura-de-clases)
    - Diagrama de clases (UML)
    - Código PlantUML
    - Contenido de las clases (.java)
3. [Programa principal (BiblioApp)](#3-programa-principal-biblioapp)
4. [Pruebas](#4-pruebas)
5. [Entrega](#5-entrega)

## 1. Intro
> Este proyecto consiste en una app ...

## 2. Estructura de clases
El programa utiliza la **POO** y se basa en la siguiente estructura:

### Diagrama de clases (UML)

![](img/programacion-orientada-objetos.png)

### Código PlantUML

### Contenido de las clases (.java)

**Editorial.java**
````
public class Editorial {

    private String nombre;
    private String pais;

    public Editorial (String nombre, String pais){
        this.nombre=nombre;
        this.pais=pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}

````


## 3. Programa principal (BiblioApp)

## 4. Pruebas

## 5. Entrega 