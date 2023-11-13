package WalysonHenrique.com.github.Kotlin

import java.util.Scanner
//classe pessoa que possui objetos com as propriedades nome e idade
class pessoa (val nome: String, val idade: Byte)

//Lista de objetos de classe pessoa
val usuarios = mutableListOf<pessoa>()

//variavel responsavel por escanear
val scanner = Scanner(System.`in`)

//Função para cadastras novos objetos a classe pessoa
fun cadastro(){

        println("Nome :")
        val nome = readLine() ?:""
        println("Digite agora a idade :")
        val idade = scanner.nextByte()
        usuarios.add(pessoa(nome, idade))
        println("Cadastro realizado com sucesso !")
}

//Lista todos os objetos da classe pessoa
fun listar()
{
    println("Listando...")
    if (usuarios.isEmpty())
    {
        println("Nenhum usuario cadastrado!")
    }
    for ((index, usuario) in usuarios.withIndex()){
        println("[ID:${index}] - Nome : ${usuario.nome}, Idade : ${usuario.idade}")
    }
}

//Busca determinado objeto na lista usuarios da classe pessoa
fun buscar()
{
    var verificador = false
    println("Digite o nome a ser buscado: ")
    val nomeBuscado = readLine() ?: ""
    for ((index, usuario) in usuarios.withIndex())
    {
        if (usuario.nome == nomeBuscado)
        {
            verificador = true
            println("[ID:$index] Nome : ${usuario.nome} Idade : ${usuario.idade}")
        }
    }
    if (verificador == false)
    {
        println("Nenhum usuario encontrado!")
    }
}

//Busca o nome do usuario, compara se o nome do usuario se encontra na lista usuarios, e exclui
//pelo indice
fun excluir()
{
    var verificador = false
    println("Digite o nome do usuario que deseja excluir do cadastro: ")
    val nomeBuscado = readLine() ?: ""
    for ((index, usuario) in usuarios.withIndex())
    {
        if (nomeBuscado == usuario.nome)
        {
            verificador = true
            println("Excluindo o usuario ${usuario.nome} ...")
            usuarios.removeAt(index)
            println("Excluído!")
        }
    }
    if (verificador == false)
    {
        println("Usuário nao encontrado")
    }
}

//Função principal
fun main()
{
    do {
        println("###### MENU ######")
        println("### 1 Cadastro ###")
        println("### 2 Listar   ###")
        println("### 3 Buscar   ###")
        println("### 4 Excluir  ###")
        println("### 5 Sair     ###")
        val escolha = scanner.nextInt()
        when (escolha)
        {
            1 -> cadastro()
            2 -> listar()
            3 -> buscar()
            4 -> excluir()
            5 -> print("Saindo...")
            else -> println("Opção inválida !")
        }

    }while(escolha != 5)
}