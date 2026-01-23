package org.example.Baterias.Estudiante;

public class Libro {
    private static int cantidadLibros = 0;
    private static int librosDisponibles = 0;
    private static String ID_NOMBRE = "LIB";

    private String titulo;
    private String autor;
    private String id;
    private boolean disponible;

    public Libro(String titulo, String autor, String id, boolean disponible) {
        this.titulo = titulo;

        disponible = true;
        cantidadLibros++;
        librosDisponibles++;
        id = calcularId();
    }

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        disponible = true;
        cantidadLibros++;
        librosDisponibles++;
        id = calcularId();
    }

    private String calcularId() { // Como es una herramienta que uso yo para crear mi objeto = privado
        return ID_NOMBRE + cantidadLibros;
    }

    public void prestar() {
        if (!disponible) {
            System.out.println("> El libro " + titulo + " ya ha sido prestado.");
        } else {
            disponible = false;
            System.out.println("> El libro " + titulo + " ha sido prestado con éxito.");
            librosDisponibles--;
        }
    }

    public void devolver() {
        if (!disponible) {
            disponible = true;
            System.out.println("> El libro ha sido devuelto con éxito.");
            librosDisponibles++;
        } else {
            System.out.println("> El libro no estaba prestado, así que no se puede devolver.");
        }
    }

    public String estaDisponible(){
        if (disponible) {
            return "[✓] El libro está disponible";
        } else {
            return "[x] El libro no está disponible";
        }
    }

    public static int getCantidadLibros() {
        return cantidadLibros;
    }

    public static void setCantidadLibros(int cantidadLibros) {
        Libro.cantidadLibros = cantidadLibros;
    }

    public static int getLibrosDisponibles() {
        return librosDisponibles;
    }

    public static void setLibrosDisponibles(int librosDisponibles) {
        Libro.librosDisponibles = librosDisponibles;
    }

    public static int getContadorLibrosDisponibles() {
        return librosDisponibles;
    }

    public static void setContadorLibrosDisponibles(int contadorLibrosDisponibles) {
        Libro.librosDisponibles = contadorLibrosDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "[Libro] [" + "Titulo= '" + titulo + '\'' + ", Autor= '" + autor + '\'' + ", id= '" + id + '\'' + ", Disponible= " + disponible + ']';
    }
}
