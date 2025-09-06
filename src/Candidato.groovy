class Candidato extends Pessoa {
    int idade
    List<String> competencias = []

    @Override
    void exibirInfo() {
        super.exibirInfo()
        println "Idade: $idade"
        println "Competências: ${competencias.join(', ')}"
        println ""
    }
}
