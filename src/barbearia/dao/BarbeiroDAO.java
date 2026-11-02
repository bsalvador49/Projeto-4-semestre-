package barbearia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BarbeiroDAO {
    
    public boolean cadastrarBarbeiro(String nome, String cpf, String senha, String especialidade) {
        String sql = "INSERT INTO barbeiro (nome, cpf, senha, especialidade) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, senha);
            stmt.setString(4, especialidade);
            
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.out.println("[ERRO DAO] Erro ao salvar barbeiro: " + e.getMessage());
            return false;
        }
    }
}