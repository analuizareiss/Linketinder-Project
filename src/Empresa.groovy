class Empresa extends Pessoa {
    String pais
    List<String> competencias = []

    @Override
    void exibirInfo() {
        super.exibirInfo()
        println "País: $pais"
        println "Competências esperadas: ${competencias.join(', ')}"
        println ""
    }
}
