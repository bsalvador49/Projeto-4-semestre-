package barbearia.service;

import barbearia.dao.AgendamentoDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AgendamentoService {
    
    private final AgendamentoDAO agendamentoDAO;

    public AgendamentoService() {
        this.agendamentoDAO = new AgendamentoDAO();
    }

    public boolean criarAgendamento(int idCliente, int idBarbeiro, int idServico, String dataHoraStr) {
        LocalDateTime dataHoraFormatada;
        
        // 1. Valida o formato da Data e Hora
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            dataHoraFormatada = LocalDateTime.parse(dataHoraStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("[ERRO] Formato inválido! Use exatamente DD/MM/YYYY HH:MM");
            return false;
        }

        // 2. Regra de Negócio: Impede agendamento no passado
        if (dataHoraFormatada.isBefore(LocalDateTime.now())) {
            System.out.println("[ERRO] A máquina do tempo quebrou! Não agendamos horários no passado.");
            return false;
        }

        // 3. Regra de Negócio: Verifica choque de horários na agenda do barbeiro
        if (agendamentoDAO.isHorarioOcupado(idBarbeiro, dataHoraFormatada)) {
            System.out.println("[ERRO CONFLITO] Este barbeiro já possui um cliente marcado para esse horário!");
            return false;
        }

        // 4. Tudo certo, envia para persistência!
        return agendamentoDAO.agendar(idCliente, idBarbeiro, idServico, dataHoraFormatada);
    }
}