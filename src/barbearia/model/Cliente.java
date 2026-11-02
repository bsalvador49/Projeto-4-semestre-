package barbearia.model;

public class Cliente extends Usuario {
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String cpf, String senha, String telefone, String email) {
        super(id, nome, cpf, senha);
        this.telefone = telefone;
        this.email = email;
    }

    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
}