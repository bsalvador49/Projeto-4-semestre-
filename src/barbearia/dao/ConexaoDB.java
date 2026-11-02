package barbearia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/barbearia_db";
    private static final String USER = "postgres";
    private static final String PASS = "1234";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("[ERRO] Falha na conexão com o banco: " + e.getMessage());
            return null;
        }
    }
}
