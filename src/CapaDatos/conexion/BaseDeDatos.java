package CapaDatos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {

    private String servidor;
    private String bd;
    private String usuario;
    private String contrasena;

    public BaseDeDatos() {
        this.servidor = "localhost";
        this.bd = "Escuela";
        this.usuario = "sa";
        this.contrasena = "Carp1997";
    }

    public Connection getConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = String.format("jdbc:sqlserver://%s\\SQLEXPRESS;databaseName=%s", servidor, bd);
            return DriverManager.getConnection(url, usuario, contrasena);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
