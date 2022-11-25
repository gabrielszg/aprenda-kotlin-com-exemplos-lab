enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val sobrenome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)
    
data class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    
    // Criacao de usuarios
    val usuario1 = Usuario("Gabriel", "Souza")
    val usuario2 = Usuario("Carlos", "Neto")
    val usuario3 = Usuario("Ana", "Paula")
    val usuario4 = Usuario("Maria", "Silva")
    
    // Criacao de conteudos
    val conteudo1 = ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 2, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Introdução Prática a Linguagem de Programação Kotlin", 2, Nivel.BASICO)
    val conteudo3 = ConteudoEducacional("Conhecendo o Java", 2, Nivel.BASICO)
    val conteudo4 = ConteudoEducacional("Introdução Prática a Linguagem de Programação Java", 2, Nivel.BASICO)
    val listaConteudoEducacionalKotlin = mutableListOf(conteudo1, conteudo2)
    val listaConteudoEducacionalJava = mutableListOf(conteudo3, conteudo4)
    
    // Criacao de formacoes
    val kotlin = Formacao("Kotlin Experience", Nivel.BASICO, listaConteudoEducacionalKotlin)
    val java = Formacao("Java Experience", Nivel.INTERMEDIARIO, listaConteudoEducacionalJava)
    
    // Matricula usuario na formacao kotlin
    kotlin.matricular(usuario1)
    kotlin.matricular(usuario2)
    
    // Matricula usuario na formacao java
    java.matricular(usuario3)
    java.matricular(usuario4)
    
    // Impressão
    println("==Formacao ${kotlin.nome}==")
    println("Conteudos da Formacao:")
    kotlin.conteudos.forEach { println("- $it") }
    println()
    println("Usuarios inscritos na formacao ${kotlin.nome}:")
    kotlin.inscritos.forEach { println("- $it") }
    
    println()
    
    println("==Formacao ${java.nome}==")
    println("Conteudos da Formacao:")
    java.conteudos.forEach { println("- $it") }
    println()
    println("Usuarios inscritos na formacao ${kotlin.nome}:")
    java.inscritos.forEach { println("- $it") }
}
