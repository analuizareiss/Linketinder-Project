import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.util.Scanner
import java.nio.file.Files
import java.nio.file.Paths

class LinketinderApp {
    List<Candidato> candidatos = []
    List<Empresa> empresas = []

    String candidatosFile = "candidatos.json"
    String empresasFile = "empresas.json"

    void inicializarDados() {
        if (Files.exists(Paths.get(candidatosFile)) && Files.exists(Paths.get(empresasFile))) {
            carregarDados()
        } else {
            popularDadosIniciais()
            salvarDados()
        }
    }

    void popularDadosIniciais() {
        candidatos = [
                new Candidato(nome: "Ana Silva", email: "ana@email.com", cpfOuCnpj: "123.456.789-00", idade: 28, estado: "SP", cep: "01001-000", descricao: "Desenvolvedora backend", competencias: ["Java", "Spring Framework"]),
                new Candidato(nome: "Carlos Souza", email: "carlos@email.com", cpfOuCnpj: "456.789.123-44", idade: 35, estado: "RJ", cep: "22040-001", descricao: "Frontend developer", competencias: ["Angular", "JavaScript"]),
                new Candidato(nome: "Maria Oliveira", email: "maria@email.com", cpfOuCnpj: "789.123.456-20", idade: 30, estado: "MG", cep: "30140-010", descricao: "Especialista em dados", competencias: ["Python", "Spark"]),
                new Candidato(nome: "Lucas Pereira", email: "lucas@email.com", cpfOuCnpj: "321.654.987-30", idade: 40, estado: "RS", cep: "90020-320", descricao: "Analista de sistemas", competencias: ["Java", "Angular"]),
                new Candidato(nome: "Juliana Lima", email: "juliana@email.com", cpfOuCnpj: "654.321.987-11", idade: 25, estado: "BA", cep: "40010-020", descricao: "Developer fullstack", competencias: ["JavaScript", "Spring Framework"])
        ]

        empresas = [
                new Empresa(nome: "Arroz-Gostoso", email: "contato@arrozgostoso.com", cpfOuCnpj: "12.345.678/0001-90", pais: "Brasil", estado: "SP", cep: "01000-000", descricao: "Empresa alimentícia", competencias: ["Python", "Java"]),
                new Empresa(nome: "Império do Boliche", email: "contato@imperiodoboliche.com", cpfOuCnpj: "98.765.432/0002-21", pais: "Brasil", estado: "RJ", cep: "22000-000", descricao: "Entretenimento", competencias: ["Angular", "JavaScript"]),
                new Empresa(nome: "Tech Soft", email: "rh@techsoft.com", cpfOuCnpj: "45.678.901/0001-12", pais: "Brasil", estado: "MG", cep: "30000-000", descricao: "Desenvolvimento de software", competencias: ["Java", "Spring Framework"]),
                new Empresa(nome: "Data Science", email: "contato@datascience.com", cpfOuCnpj: "32.109.876/0001-34", pais: "Brasil", estado: "RS", cep: "90000-000", descricao: "Consultoria em dados", competencias: ["Python", "Spark"]),
                new Empresa(nome: "Market Web", email: "contact@marketweb.com", cpfOuCnpj: "56.123.789/0001-56", pais: "Brasil", estado: "BA", cep: "40000-000", descricao: "Marketing digital", competencias: ["JavaScript", "Angular"])
        ]
    }

    void salvarDados() {
        Files.write(Paths.get(candidatosFile), JsonOutput.prettyPrint(JsonOutput.toJson(candidatos))?.getBytes("UTF-8"))
        Files.write(Paths.get(empresasFile), JsonOutput.prettyPrint(JsonOutput.toJson(empresas))?.getBytes("UTF-8"))
    }

    void carregarDados() {
        def candidatosJson = new File(candidatosFile).text
        def empresasJson = new File(empresasFile).text

        def slurper = new JsonSlurper()

        def candidatosList = slurper.parseText(candidatosJson)
        def empresasList = slurper.parseText(empresasJson)

        candidatos = candidatosList.collect { c ->
            new Candidato(
                    nome: c.nome,
                    email: c.email,
                    cpfOuCnpj: c.cpfOuCnpj,
                    idade: c.idade,
                    estado: c.estado,
                    cep: c.cep,
                    descricao: c.descricao,
                    competencias: c.competencias
            )
        }

        empresas = empresasList.collect { e ->
            new Empresa(
                    nome: e.nome,
                    email: e.email,
                    cpfOuCnpj: e.cpfOuCnpj,
                    pais: e.pais,
                    estado: e.estado,
                    cep: e.cep,
                    descricao: e.descricao,
                    competencias: e.competencias
            )
        }
    }

    void listarCandidatos() {
        println "--- Lista de Candidatos ---\n"
        if (candidatos.isEmpty()) {
            println "Nenhum candidato cadastrado."
        } else {
            candidatos.each { it.exibirInfo() }
        }
    }

    void listarEmpresas() {
        println "--- Lista de Empresas ---\n"
        if (empresas.isEmpty()) {
            println "Nenhuma empresa cadastrada."
        } else {
            empresas.each { it.exibirInfo() }
        }
    }

    void cadastrarCandidato(Scanner scanner) {
        println "Cadastro de Novo Candidato"

        print "Nome: "
        String nome = scanner.nextLine()

        print "Email: "
        String email = scanner.nextLine()

        print "CPF: "
        String cpf = scanner.nextLine()

        print "Idade: "
        int idade = Integer.parseInt(scanner.nextLine())

        print "Estado: "
        String estado = scanner.nextLine()

        print "CEP: "
        String cep = scanner.nextLine()

        print "Descrição pessoal: "
        String descricao = scanner.nextLine()

        print "Digite as competências separadas por vírgula: "
        List<String> competencias = scanner.nextLine().split(',').collect { it.trim() }

        Candidato novo = new Candidato(nome: nome, email: email, cpfOuCnpj: cpf, idade: idade, estado: estado, cep: cep, descricao: descricao, competencias: competencias)
        candidatos << novo
        salvarDados()

        println "Candidato cadastrado com sucesso!\n"
    }

    void cadastrarEmpresa(Scanner scanner) {
        println "Cadastro de Nova Empresa"

        print "Nome: "
        String nome = scanner.nextLine()

        print "Email Corporativo: "
        String email = scanner.nextLine()

        print "CNPJ: "
        String cnpj = scanner.nextLine()

        print "País: "
        String pais = scanner.nextLine()

        print "Estado: "
        String estado = scanner.nextLine()

        print "CEP: "
        String cep = scanner.nextLine()

        print "Descrição da empresa: "
        String descricao = scanner.nextLine()

        print "Digite as competências esperadas separadas por vírgula: "
        List<String> competencias = scanner.nextLine().split(',').collect { it.trim() }

        Empresa nova = new Empresa(nome: nome, email: email, cpfOuCnpj: cnpj, pais: pais, estado: estado, cep: cep, descricao: descricao, competencias: competencias)
        empresas << nova
        salvarDados()

        println "Empresa cadastrada com sucesso!\n"
    }

    void exibirMenu() {
        println "\nMenu Linketinder MVP"
        println "1 - Listar candidatos"
        println "2 - Listar empresas"
        println "3 - Cadastrar candidato"
        println "4 - Cadastrar empresa"
        println "0 - Sair"
        print "Escolha uma opção: "
    }

    void iniciar() {
        inicializarDados()
        def scanner = new Scanner(System.in)
        int opcao

        do {
            exibirMenu()
            opcao = Integer.parseInt(scanner.nextLine())  // para evitar problema com nextInt
            switch (opcao) {
                case 1:
                    listarCandidatos()
                    break
                case 2:
                    listarEmpresas()
                    break
                case 3:
                    cadastrarCandidato(scanner)
                    break
                case 4:
                    cadastrarEmpresa(scanner)
                    break
                case 0:
                    println "Encerrando..."
                    break
                default:
                    println "Opção inválida. Tente novamente."
            }
        } while (opcao != 0)
    }
}

