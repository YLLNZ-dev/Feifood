#  FEIFood - Projeto de Delivery

Projeto final da disciplina CCM310 - Arquitetura de Software e Programação Orientada a Objetos.

O objetivo do projeto FEIFood é construir uma plataforma de pedidos de alimentos, inspirada em aplicativos de delivery como o iFood. Este documento serve como o relatório final do projeto, detalhando a arquitetura, as funcionalidades implementadas e o guia de instalação e execução.

##  Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e padrões:

* **Linguagem:** Java
* **Banco de Dados:** PostgreSQL
* **Conexão:** JDBC (Java Database Connectivity)
* **Interface Gráfica (GUI):** Java Swing
* **Arquitetura:** MVC (Model-View-Controller)
* **Padrão de Persistência:** DAO (Data Access Object)
* **IDE:** Apache NetBeans
* **Versionamento:** Git e GitHub

---

##  Funcionalidades Implementadas

O sistema atual implementa as seguintes funcionalidades principais:

* **Autenticação de Usuário:**
    * **Login de Usuário:** O sistema valida as credenciais (usuário e senha) com o banco de dados PostgreSQL.
    * **Cadastro de Novo Usuário:** Um novo usuário pode ser registrado e seus dados são persistidos no banco.

* **Plataforma de Pedidos:**
    * **Listagem de Produtos:** Ao logar, a tela principal busca e exibe todos os produtos cadastrados no banco de dados.
    * **Busca Dinâmica:** O usuário pode filtrar os produtos da vitrine em tempo real digitando na barra de busca (com filtro `ILIKE`).
    * **Carrinho Interativo:**
        * O usuário pode **adicionar** um item ao carrinho clicando nele na vitrine.
        * O usuário pode **remover** um item do carrinho clicando nele na lista do carrinho.

---

##  Arquitetura do Projeto

O código-fonte é organizado em pacotes seguindo o padrão MVC:

* **`Main`**: Contém a classe principal que inicia a aplicação (`Main.java`).
* **`model`**: Contém as classes "POJO" (Plain Old Java Objects) que representam os dados do sistema.
    * `Usuario.java`: Modela a tabela `tbusuario`.
    * `Alimento.java`: Modela a tabela `TB_alimentos`.
* **`view`**: Contém todos os Formulários JFrame (telas) construídos com Swing.
    * `Login.java`: Tela inicial de login.
    * `Cadastro.java`: Tela de registro de novo usuário.
    * `Logado.java`: Tela principal com a vitrine e o carrinho.
* **`controller`**: Classes que fazem a "ponte" (lógica de negócio) entre as `Views` e os `DAOs`.
    * `ControllerLogin.java`: Valida o login.
    * `ControllerCadastro.java`: Salva um novo usuário.
    * `ControllerLogado.java`: Gerencia a vitrine, a busca e o carrinho.
* **`dao`**: (Data Access Object) Classes responsáveis por toda a comunicação (comandos SQL) com o banco de dados.
    * `Conexao.java`: Gerencia a conexão JDBC com o PostgreSQL.
    * `Usuariodao.java`: Contém os métodos `consultar(Usuario u)` e `adicionar(Usuario u)`.
    * `Alimentodao.java`: Contém os métodos `buscarTodos()` e `buscarPorDescricao(String texto)`.

---

##  Como Executar o Projeto (Guia de Setup)

Para executar este projeto, siga os 3 passos abaixo:

### 1. Configurar o Banco de Dados (PostgreSQL)

1.  Certifique-se de que o PostgreSQL está instalado e rodando.
2.  No pgAdmin, crie um novo banco de dados vazio chamado `feifood`.
3.  Altere a senha do usuário `postgres` para `fei`. (Necessário para o `Conexao.java` funcionar).
    * Execute o comando: `ALTER USER postgres PASSWORD 'fei';`
4.  Abra a **Ferramenta de Consulta (Query Tool)** ⚡ para o banco `feifood` e execute o script SQL abaixo para criar e popular as tabelas:

```sql
-- --- CRIAÇÃO DAS TABELAS (COM IDS AUTOMÁTICOS) ---

-- 1. Tabela de Usuários
CREATE TABLE public.tbusuario (
    "ID_usuario" BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    "Nome_usuario" VARCHAR,
    "usuario" VARCHAR,
    "senha" VARCHAR,
    PRIMARY KEY ("ID_usuario")
);

-- 2. Tabela de Alimentos
CREATE TABLE public."TB_alimentos" (
    "ID_alimentos" BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    "Desc_alimentos" VARCHAR,
    "Tipo_alimento" VARCHAR,
    "Preco_alimento" NUMERIC(10, 2),
    PRIMARY KEY ("ID_alimentos")
);

-- 3. Tabela de Pedidos
CREATE TABLE public."TB_pedidos" (
    "ID_pedido" BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL,
    "data_pedido" DATE,
    "Hora_pedido" TIME,
    "ID_cliente" BIGINT,
    "Valor_pedido" NUMERIC(10, 2),
    "Avaliacao" INT,
    PRIMARY KEY ("ID_pedido"),
    CONSTRAINT "fk_pedidos_usuarios" FOREIGN KEY ("ID_cliente") REFERENCES public.tbusuario("ID_usuario")
);

-- 4. Tabela de Ligação (Itens do Pedido)
CREATE TABLE public."TB_pedidos_alimentos" (
    "ID_pedido_alimentos" BIGINT GENERATED ALWAYS AS IDENTITY,
    "ID_pedido" BIGINT,
    "ID_alimentos" BIGINT,
    "Quantidade_pedido_alimentos" BIGINT,
    CONSTRAINT "fk_pedidosalimentos_pedidos" FOREIGN KEY ("ID_pedido") REFERENCES public."TB_pedidos"("ID_pedido"),
    CONSTRAINT "fk_pedidosalimentos_alimentos" FOREIGN KEY ("ID_alimentos") REFERENCES public."TB_alimentos"("ID_alimentos")
);


-- --- DADOS DE EXEMPLO ---

-- Usuário de Teste (Login: admin / Senha: 1234)
INSERT INTO public.tbusuario ("Nome_usuario", "usuario", "senha")
VALUES ('Usuário de Teste', 'admin', '1234');

-- Alimentos (29 itens)
INSERT INTO public."TB_alimentos" ("Desc_alimentos", "Tipo_alimento", "Preco_alimento")
VALUES
('Hambúrguer Clássico', 'Lanche', 18.50),
('X-Bacon', 'Lanche', 19.90),
('X-Salada', 'Lanche', 18.90),
('Hot Dog Duplo', 'Lanche', 16.00),
('Pizza Margherita', 'Pizza', 45.00),
('Pizza Calabresa', 'Pizza', 48.00),
('Pizza Quatro Queijos', 'Pizza', 50.00),
('Porção de Batata Frita', 'Porção', 15.00),
('Porção de Calabresa', 'Porção', 25.00),
('Porção de Frango a Passarinho', 'Porção', 30.00),
('Temaki Salmão Completo', 'Japonesa', 22.00),
('Combinado 20 peças', 'Japonesa', 55.00),
('Feijoada (Final de Semana)', 'Brasileira', 35.00),
('PF de Frango Grelhado', 'Brasileira', 20.00),
('Pastel de Carne', 'Pastel', 8.00),
('Pastel de Queijo', 'Pastel', 8.00),
('Açaí 500ml', 'Sobremesa', 18.00),
('Coca-Cola Lata', 'Bebida', 5.00),
('Coca-Cola Zero Lata', 'Bebida', 5.00),
('Guaraná Antárctica Lata', 'Bebida', 5.00),
('Suco de Laranja (natural) 500ml', 'Bebida', 8.00),
('Suco de Morango (polpa) 500ml', 'Bebida', 7.00),
('Água Mineral com Gás', 'Bebida', 3.50),
('Água Mineral sem Gás', 'Bebida', 3.00),
('Cerveja Heineken Long Neck', 'Bebida Alcoolica', 9.00),
('Cerveja Brahma Duplo Malte Lata', 'Bebida Alcoolica', 4.50),
('Vinho Tinto (Garrafa)', 'Bebida Alcoolica', 60.00),
('Caipirinha de Limão', 'Bebida Alcoolica', 12.00),
('Gin Tônica', 'Bebida Alcoolica', 15.00);
