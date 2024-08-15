package com.luisgmr.desafio.biblioteca.model

class Cliente(
    private val nome: String,
    val cpf: String,
) {
    private val livrosEmprestados: ArrayList<Livro> = arrayListOf()

    fun emprestarLivro(livro: Livro) {
        if (livrosEmprestados.size >= 5) {
            println("O cliente $nome excedeu o máximo de livros emprestados (5).")
            return;
        }
        if (livrosEmprestados.contains(livro)) {
            println("O cliente já tem esse livro emprestado.")
            return;
        }
        if (livro.emprestar()) {
            livrosEmprestados.add(livro)
            println("O livro ${livro.titulo} foi emprestado para $nome")
        }
    }

    fun devolverLivro(livro: Livro) {
        if (!livrosEmprestados.contains(livro)) {
            println("O cliente $nome não possui o livro ${livro.titulo}")
            return;
        }
        if (!livrosEmprestados.contains(livro)) {
            println("O cliente não possui esse livro para devolver.")
            return;
        }
        if (livro.devolver()) {
            livrosEmprestados.remove(livro)
            println("O livro ${livro.titulo} foi devolvido por $nome")
        }
    }

    fun listarLivrosEmprestados() {
        if (livrosEmprestados.size > 1) {
            println("Livros emprestados para $nome:")
            for (livro in livrosEmprestados) {
                livro.mostrarDetalhes()
            }
        } else {
            println("O cliente $nome não tem nenhum livro emprestado.")
        }
    }

    fun mostrarDetalhes() {
        println("$nome, CPF nº $cpf - ${livrosEmprestados.size} livros emprestados.")
    }

}