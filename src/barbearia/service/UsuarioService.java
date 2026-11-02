package barbearia.service;

import barbearia.dao.UsuarioDAO;

public class UsuarioService {
    
    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public boolean cadastrarNovoCliente(String nome, String cpf, String senha, String telefone, String email) {
        if (cpf == null || cpf.trim().length() != 11) {
            System.out.println("[ERRO] O CPF deve conter exatamente 11 dígitos.");
            return false;
        }
        if (!email.contains("@")) {
            System.out.println("[ERRO] E-mail inválido.");
            return false;
        }
        
        return usuarioDAO.cadastrarCliente(nome, cpf, senha, telefone, email);
    }
}