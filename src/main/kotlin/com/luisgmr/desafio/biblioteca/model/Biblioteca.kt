package com.luisgmr.desafio.biblioteca.model

import java.util.stream.Collectors

class Biblioteca {
    private val livros: ArrayList<Livro> = arrayListOf()
    private val clientes: ArrayList<Cliente> = arrayListOf()

    fun adicionarLivro(livro: Livro) {
        livros.add(livro)
    }

    fun removerLivro(titulo: String) {
        livros.remove(livros.stream().filter{ it.titulo == titulo }.findFirst().get())
    }

    fun listarLivrosDisponiveis() {
        val livrosDisponiveis = livros.stream().filter{it.disponivel}.collect(Collectors.toList());
        println("Livros disponívels para empréstimo:")
        for (livro in livrosDisponiveis) {
            livro.mostrarDetalhes()
        }
    }

    fun buscarLivroPorTitulo(titulo: String): Livro {
        val livro = livros.stream().filter{it.titulo == titulo}.findFirst().get()
        return livro
    }

    fun buscarClientePorCpf(cpf: String): Cliente {
        val cliente = clientes.stream().filter{it.cpf == cpf}.findFirst().get()
        return cliente
    }

    fun adicionarCliente(cliente: Cliente) {
        clientes.add(cliente)
    }

    fun removerCliente(cpf: String) {
        clientes.remove(clientes.stream().filter{it.cpf == cpf}.findFirst().get())
    }

    fun listarClientes() {
        println("Clientes registrados na biblioteca:")
        for (cliente in clientes) {
            cliente.mostrarDetalhes()
        }
        Thread.sleep(500)
    }

    fun listarLivros() {
        println("Livros registrados na biblioteca:")
        for (livro in livros) {
            livro.mostrarDetalhes()
        }
        Thread.sleep(500)
    }



}