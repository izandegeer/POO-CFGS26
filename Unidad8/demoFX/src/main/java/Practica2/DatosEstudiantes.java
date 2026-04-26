package Practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DatosEstudiantes {


    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3307/";
        String user = "root";
        String psw = "";
        String bd = "instituto";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd,user,psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion){

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static ObservableList<Estudiante> consulta (Connection conexion){
        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

        String query = "SELECT * FROM estudiante";

        Statement stmt;
        ResultSet respuesta;

        try {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                LocalDate fecha_nacimiento = respuesta.getDate("fecha_nacimiento").toLocalDate();
                listaEstudiantes.add(new Estudiante(nia, nombre,fecha_nacimiento));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return listaEstudiantes;
    }
    public static void guardar(Connection conexion, Estudiante estudiante){

        String query = "UPDATE estudiante SET nia = '"+estudiante.getNia()+"' , " +
                                            "nombre = '"+estudiante.getNombre()+"', " +
                                            "fecha_nacimiento = '"+estudiante.getFecha_nacimiento()+"' " +
                                        "WHERE nia = '"+estudiante.getNia()+"'";
        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    public static void insertar(Connection conexion, Estudiante estudiante){

        String query = "INSERT INTO estudiante (nia, nombre, fecha_nacimiento) " +
                       "VALUES ('"+estudiante.getNia()+"', " +
                                "'"+estudiante.getNombre()+"', " +
                                "'"+estudiante.getFecha_nacimiento()+"')";
        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void borrar(Connection conexion, Estudiante estudiante){

        String query = "DELETE FROM estudiante WHERE nia = '"+estudiante.getNia()+"'";
        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
