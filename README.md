# 💈 Sistema de Barbearia - Projeto 4º Semestre

## 📖 Sobre o Projeto

O Sistema de Barbearia é uma aplicação Java baseada em Programação Orientada a Objetos (POO), construída para o projeto acadêmico do 4º semestre. O software gerencia o fluxo operacional de uma barbearia com uma arquitetura dividida em camadas lógicas rigorosas, separando as regras de negócio, a interface de usuário via console e a comunicação com o banco de dados.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Banco de Dados:** PostgreSQL
* **Ferramenta de Desenvolvimento (IDE):** NetBeans 8.2
* **Gerenciamento de Build:** Ant (configurado via `build.xml`)


* **Versionamento:** Git e GitHub

## ✨ Funcionalidades Desenvolvidas

O sistema funciona através de um menu interativo no console (`MenuConsole.java`) e oferece as seguintes operações:

* **Gestão de Usuários:** Cadastro, autenticação e validação de usuários do sistema através da `UsuarioService.java` e persistência via `UsuarioDAO.java`.


* **Gestão de Barbeiros:** Controle de profissionais registrados na barbearia utilizando a classe `BarbeiroService.java` e `BarbeiroDAO.java`.


* **Controle de Agendamentos:** Marcação e organização dos horários dos clientes operados pela `AgendamentoService.java` e armazenados através do `AgendamentoDAO.java`.


* **Modelagem de Dados:** Entidades do domínio de negócio fortemente tipadas, como `Cliente.java` e `Usuario.java`.



## 📦 Pré-requisitos e Dependências

Para compilar e executar o projeto corretamente, o ambiente precisa contar com:

* **Java Development Kit (JDK):** Versão 8 (compatível com a estrutura de compilação da IDE NetBeans 8.2).
* **Servidor PostgreSQL:** Rodando localmente (porta padrão `5432`).
* **Driver JDBC do PostgreSQL:** Arquivo `.jar` adicionado às bibliotecas do projeto para permitir que o `ConexaoDB.java` se comunique com o banco.



## ⚙️ Variáveis de Ambiente e Configuração

As configurações de comunicação com o banco de dados são estabelecidas internamente. Antes de executar a aplicação, é necessário configurar a classe responsável pela conexão:

* **Arquivo alvo:** `src/barbearia/dao/ConexaoDB.java`.


* É necessário ajustar a *URL de Conexão* (ex: `jdbc:postgresql://localhost:5432/nome_do_banco`), o *Usuário* (ex: `postgres`) e a *Senha* de acordo com a sua instalação local do pgAdmin.

## 📂 Estrutura de Pastas

A organização do repositório segue o padrão do NetBeans com a aplicação do padrão de projeto MVC/Camadas:

* `nbproject/`: Contém os arquivos de configuração específicos da IDE, como `project.properties`, `project.xml` e `build-impl.xml`.


* `src/barbearia/`: Pacote raiz do código-fonte.


* `Barbearia.java`: Classe principal com o método de inicialização (`main`).


* `dao/`: Classes de acesso a dados e configuração de banco (`AgendamentoDAO.java`, `BarbeiroDAO.java`, `ConexaoDB.java`, `UsuarioDAO.java`).


* `model/`: Classes de entidade (`Cliente.java`, `Usuario.java`).


* `service/`: Classes com a lógica e regras de negócio (`AgendamentoService.java`, `BarbeiroService.java`, `UsuarioService.java`).


* `view/`: Classes de interação com o usuário via terminal (`MenuConsole.java`, `OpcaoMenuPrincipal.java`).





## 🚀 Atualizações Futuras

* **Interface Gráfica (GUI):** Migração do sistema de menu via console (`MenuConsole.java` e `OpcaoMenuPrincipal.java`) para interfaces gráficas interativas (Java Swing ou JavaFX).


* **Geração de Relatórios:** Implementação de exportação de dados de agendamentos e faturamento para arquivos CSV ou PDF.
* **Sistema de Notificações:** Envio de alertas de agendamento para os clientes.
* **Refinamento do Banco de Dados:** Expansão dos scripts e triggers no PostgreSQL para automatizar verificações de disponibilidade de horários na camada de persistência.

---

**Equipe de Desenvolvimento:** Paulo Lucas Garçoni Araujo, Bruno Salvador Dias, Filippe Barcelos da Silva .
**Orientação:** Henrique Domingues Garcia.
