package barbearia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AgendamentoDAO {
    
    // Regra de Concorrência: Verifica se o barbeiro já tem cliente nesse horário
    public boolean isHorarioOcupado(int idBarbeiro, LocalDateTime dataHora) {
        String sql = "SELECT COUNT(*) FROM agendamento WHERE id_barbeiro = ? AND data_hora = ?";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idBarbeiro);
            stmt.setTimestamp(2, Timestamp.valueOf(dataHora)); // Converte data do Java pro SQL
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true se a contagem for maior que zero
            }
        } catch (SQLException e) {
            System.out.println("[ERRO DAO] Erro ao verificar horário: " + e.getMessage());
        }
        return true; // Em caso de falha no banco, bloqueia por segurança
    }

    // Salva o agendamento
    public boolean agendar(int idCliente, int idBarbeiro, int idServico, LocalDateTime dataHora) {
        String sql = "INSERT INTO agendamento (id_cliente, id_barbeiro, id_servico, data_hora) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idBarbeiro);
            stmt.setInt(3, idServico);
            stmt.setTimestamp(4, Timestamp.valueOf(dataHora));
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            System.out.println("[ERRO DAO] Erro ao salvar agendamento: " + e.getMessage());
            return false;
        }
    }
}