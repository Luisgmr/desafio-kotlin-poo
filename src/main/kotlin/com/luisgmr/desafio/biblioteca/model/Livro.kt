package com.luisgmr.desafio.biblioteca.model

import java.time.LocalDate

class Livro(
    val titulo: String = "nenhum",
    private val autor: String = "nenhum",
    private val dataPublicacao: LocalDate = LocalDate.now(),
) {

    var disponivel: Boolean = true

    fun emprestar(): Boolean {
        if (disponivel) {
            disponivel = false
            println("O livro $titulo agora está indisponível.")
            return true;
        } else {
            println("O livro está indisponível para ser emprestado.")
            return false;
        }
    }

    fun devolver(): Boolean {
        if (!disponivel) {
            disponivel = true
            println("O livro $titulo foi devolvido e agora está disponível.")
            return true;
        } else {
            println("O livro já está disponível e não pode ser devolvido.")
            return false;
        }
    }

    fun mostrarDetalhes() {
        val disponibilidade = if (disponivel) "disponível" else "indisponível"
        println("$titulo, de $autor, ${dataPublicacao.year} - $disponibilidade")
    }
}