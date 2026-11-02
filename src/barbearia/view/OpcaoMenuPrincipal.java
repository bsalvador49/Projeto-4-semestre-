package barbearia.view;

public enum OpcaoMenuPrincipal {
    CADASTRAR(1),
    LOGIN(2),
    CADASTRAR_BARBEIRO(3), 
    AGENDAR(4),
    SAIR(0);


    private final int valor;

    OpcaoMenuPrincipal(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static OpcaoMenuPrincipal fromInt(int valor) {
        for (OpcaoMenuPrincipal opcao : values()) {
            if (opcao.getValor() == valor) {
                return opcao;
            }
        }
        return null;
    }
}