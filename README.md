# Desafio: Sistema de Gestão de Biblioteca
``Objetivo: Criar um sistema de gestão de uma biblioteca que permita o gerenciamento de livros, clientes (leitores), e empréstimos de livros.
``
###
### Classe Livro

Propriedades: ``titulo, autor, anoPublicacao, disponivel`` (um booleano que indica se o livro está disponível ou não).

#### Métodos:
- emprestar(): define disponivel como false.
- devolver(): define disponivel como true.
- mostrarDetalhes(): imprime os detalhes do livro, incluindo título, autor, ano de publicação, e disponibilidade.
###
### Classe Cliente:

Propriedades: ``nome, cpf, livrosEmprestados`` (uma lista de livros que o cliente tomou emprestado).

#### Métodos:
- emprestarLivro(livro: Livro): adiciona o livro à lista de livrosEmprestados e define o livro como não disponível.
- devolverLivro(livro: Livro): remove o livro da lista de livrosEmprestados e define o livro como disponível.
- listarLivrosEmprestados(): lista todos os livros que o cliente atualmente tem emprestados.
Classe Biblioteca:

Propriedades: ``livros (lista de Livro), clientes`` (lista de Cliente).

#### Métodos:
- adicionarLivro(livro: Livro): adiciona um livro à biblioteca.
- removerLivro(titulo: String): remove um livro da biblioteca pelo título.
- listarLivrosDisponiveis(): lista todos os livros disponíveis para empréstimo.
- buscarLivroPorTitulo(titulo: String): retorna um livro específico pelo título.
- adicionarCliente(cliente: Cliente): adiciona um cliente à biblioteca.
- removerCliente(cpf: String): remove um cliente da biblioteca pelo CPF.
- listarClientes(): lista todos os clientes registrados na biblioteca.
###
### Classe Emprestimo:

Propriedades: ``livro (um Livro), cliente (um Cliente), dataEmprestimo, dataDevolucao``.

#### Métodos:
- realizarEmprestimo(): registra o empréstimo de um livro para um cliente e define as datas de empréstimo e devolução.
- concluirEmprestimo(): marca o empréstimo como concluído e define o livro como disponível novamente.
- mostrarDetalhes(): imprime os detalhes do empréstimo, incluindo o cliente, o livro, e as datas de empréstimo e devolução.

###
#### Regras e Funcionalidades:
> Gestão de Livros: A biblioteca deve ser capaz de adicionar e remover livros, bem como listar os livros disponíveis e buscar por título.

> Gestão de Clientes: A biblioteca deve gerenciar clientes, incluindo a capacidade de adicionar e remover clientes e listar todos os clientes registrados.

> Gestão de Empréstimos: O sistema deve permitir o registro de empréstimos de livros para clientes, e deve rastrear quais livros estão emprestados e quais estão disponíveis.

> Limite de Empréstimos: Cada cliente pode ter um número máximo de livros emprestados simultaneamente (por exemplo, 5 livros). O sistema deve impedir novos empréstimos caso o limite seja atingido.
