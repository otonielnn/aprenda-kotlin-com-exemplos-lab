

import Formacao// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, var idade : Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("O ${usuario.nome} foi Matriculado!!!")
    }
}

fun main() {
    val cursoDeRedes = ConteudoEducacional("Curso de Redes", 100, Nivel.DIFICIL)
    val cursoDeKotlin = ConteudoEducacional("Curso de Kotlin", 80, Nivel.INTERMEDIARIO)
    val cursoDePython = ConteudoEducacional("Curso de Python", 40, Nivel.BASICO)

    val cienciaComputacao = Formacao("Ciência da Computação", listOf(cursoDeRedes, cursoDeKotlin, cursoDePython))

    val aluno1 = Usuario("Otoniel", 21)
    val aluno2 = Usuario("Jorge", 18)
    val aluno3 = Usuario("Isabella", 23)

    cienciaComputacao.matricular(aluno1)
    cienciaComputacao.matricular(aluno2)
    cienciaComputacao.matricular(aluno3)

    println("\nBacharelado em ${cienciaComputacao.nome}")

    println("\nCadeiras: ")
    for (cadeira in cienciaComputacao.conteudos) {
        println("${cadeira.nome} com duração de ${cadeira.duracao} horas - Nivel = ${cadeira.nivel}")
    }

    println("\nAlunos que cursam o Bacharelado em Ciência da Computação: ")
    for (aluno in cienciaComputacao.inscritos) {
        println(aluno.nome)
    }
}