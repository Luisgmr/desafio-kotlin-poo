package com.luisgmr.com.luisgmr.desafio.biblioteca

import com.luisgmr.desafio.biblioteca.model.Biblioteca
import com.luisgmr.desafio.biblioteca.model.Cliente
import com.luisgmr.desafio.biblioteca.model.Livro
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Sistema {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val biblioteca = Biblioteca()
            var opcao = -1
            while (opcao != 0) {
                println("Sistema de biblioteca:\n" +
                        "1- Adicionar cliente à biblioteca\n" +
                        "2- Adicionar livro à biblioteca\n" +
                        "3- Remover cliente da biblioteca\n" +
                        "4- Remover livro da biblioteca\n" +
                        "5- Buscar livro por título\n" +
                        "6- Acessar menu do cliente (emprestar e devolver)\n" +
                        "7- Listar todos os livros\n" +
                        "8- Listar livros disponíveis\n" +
                        "9- Listar clientes\n" +
                        "0- Sair\n\n")
                print("Digite a opção: ")
                opcao = readln().toInt()
                when (opcao) {
                    1 -> {
                        println("Adicionando cliente à biblioteca...")
                        print("Digite o nome do cliente: ")
                        val nome = readLine().toString()
                        print("Digite o cpf do cliente: ")
                        val cpf = readLine().toString()
                        biblioteca.adicionarCliente(Cliente(nome, cpf))
                    }
                    2 -> {
                        println("Adicionando cliente à biblioteca...")
                        print("Digite o título do livro: ")
                        val titulo: String = readLine().toString()
                        print("Digite o autor do livro: ")
                        val autor = readLine().toString()

                        val format = SimpleDateFormat("dd/MM/yyyy")
                        val dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                        print("Digite a data do livro (dd/MM/yyyy): ")
                        val dataPublicacao = LocalDate.parse(readLine().toString(), dataFormato)
                        biblioteca.adicionarLivro(Livro(titulo, autor, dataPublicacao))
                    }
                    3 -> {
                        println("Removendo cliente da biblioteca...")
                        print("Digite o CPF do cliente: ")
                        val cpf = readLine().toString()
                        biblioteca.removerCliente(cpf)
                    }
                    4 -> {
                        println("Removendo livro da biblioteca...")
                        print("Digite o nome do livro: ")
                        val nomeDoLivro = readLine().toString()
                        biblioteca.removerCliente(nomeDoLivro)
                    }
                    5 -> {
                        println("Buscando livro por título...")
                        print("Digite o título do livro: ")
                        val titulo = readLine().toString()
                        biblioteca.buscarLivroPorTitulo(titulo).mostrarDetalhes()
                    }
                    6 -> {
                        print("Digite o cpf do cliente: ")
                        val cpf = readLine().toString()
                        val cliente = biblioteca.buscarClientePorCpf(cpf)
                        if (cliente != null) {
                            println("Cliente encontrado! Menu do cliente:")
                            var opcaoCliente = -1
                            var livro: Livro = Livro()
                            while (opcaoCliente != 0) {
                                println("Livro selecionado: " + livro.titulo)
                                print("1- Selecionar livro da biblioteca\n" +
                                        "2- Emprestar livro selecionado\n" +
                                        "3- Devolver livro selecionado\n\n" +
                                        "0- Sair do menu do cliente\n" +
                                        "Selecione a opção: ")
                                opcaoCliente = readln().toInt()
                                when (opcaoCliente) {
                                    1 -> {
                                        print("Digite o título do livro: ")
                                        livro = biblioteca.buscarLivroPorTitulo(readLine().toString())
                                        println(if (livro != null) "Livro encontrado!" else "Livro não encontrado!")
                                    }
                                    2 -> cliente.emprestarLivro(livro)
                                    3 -> cliente.devolverLivro(livro)
                                }
                            }
                        } else {
                            println("Cliente não encontrado.")
                        }
                    }
                    7 -> biblioteca.listarLivros()
                    8 -> biblioteca.listarLivrosDisponiveis()
                    9 -> biblioteca.listarClientes()
                }

            }
        }
    }

}