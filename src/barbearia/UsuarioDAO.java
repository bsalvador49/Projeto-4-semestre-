package barbearia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean cadastrarCliente(String nome, String cpf, String senha, String telefone, String email) {
        String sql = "INSERT INTO usuarios (nome, cpf, senha, tipo_perfil, telefone, email) VALUES (?, ?, ?, 'CLIENTE', ?, ?)";
        
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
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
            return false;
        }
    } 

    public String fazerLogin(String cpf, String senha) {
        String sql = "SELECT nome, tipo_perfil FROM usuarios WHERE cpf = ? AND senha = ?";
        
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, cpf);
            stmt.setString(2, senha);
            
            java.sql.ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String nome = rs.getString("nome");
                String perfil = rs.getString("tipo_perfil");
                return perfil + ":" + nome; 
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
        return null; 
    } 

} 
