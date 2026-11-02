package barbearia.model;

public abstract class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private String senha;

    public Usuario(int id, String nome, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getSenha() { return senha; }
}