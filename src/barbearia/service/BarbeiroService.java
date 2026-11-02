package barbearia.service;

import barbearia.dao.BarbeiroDAO;

public class BarbeiroService {
    
    private final BarbeiroDAO barbeiroDAO;

    public BarbeiroService() {
        this.barbeiroDAO = new BarbeiroDAO();
    }

    public boolean cadastrarNovoBarbeiro(String nome, String cpf, String senha, String especialidade) {
        if (cpf == null || cpf.trim().length() != 11) {
            System.out.println("[ERRO] O CPF deve conter exatamente 11 dígitos.");
            return false;
        }
        if (especialidade == null || especialidade.trim().isEmpty()) {
            System.out.println("[ERRO] A especialidade é obrigatória (ex: Degradê, Barboterapia).");
            return false;
        }
        
        return barbeiroDAO.cadastrarBarbeiro(nome, cpf, senha, especialidade);
    }
}