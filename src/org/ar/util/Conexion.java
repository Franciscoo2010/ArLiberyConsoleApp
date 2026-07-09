package org.ar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Conexion instancia;

    // Configuración de la conexión
    private static final String URL =
            "jdbc:mysql://localhost:3306/libreriadb_in4cm?serverTimezone=UTC";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    // Constructor privado
    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el Driver: " + e.getMessage());
        }
    }

    // Obtener la única instancia
    public static synchronized Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    // Crear una conexión nueva
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}