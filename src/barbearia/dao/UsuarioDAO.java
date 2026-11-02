package barbearia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public boolean cadastrarCliente(String nome, String cpf, String senha, String telefone, String email) {
        String sql = "INSERT INTO cliente (nome, cpf, senha, telefone, email) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, senha);
            stmt.setString(4, telefone);
            stmt.setString(5, email);
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.out.println("[ERRO DAO] Erro ao salvar cliente: " + e.getMessage());
            return false;
        }
    }
}