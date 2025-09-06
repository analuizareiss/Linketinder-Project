class Pessoa implements IPessoa {
    String nome
    String email
    String cpfOuCnpj
    String estado
    String cep
    String descricao

    void exibirInfo() {
        println "Nome: $nome"
        println "Email: $email"
        println "Identificação (CPF ou CNPJ): $cpfOuCnpj"
        println "Estado: $estado"
        println "CEP: $cep"
        println "Descrição: $descricao"
    }
}
