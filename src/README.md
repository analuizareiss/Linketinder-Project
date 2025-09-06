# Linketinder - Sistema de Contratação de Funcionários

<!-- Autor: Seu Nome Aqui -->

## Descrição

Linketinder é um sistema simples para contratação de funcionários, inspirado no LinkedIn e Tinder. O objetivo é facilitar a busca e o cadastro de candidatos e empresas baseando-se em competências. Implementado em Groovy como projeto MVP (Produto Mínimo Viável).

---

## Funcionalidades

- Lista candidatos pré-cadastrados com informações completas.
- Lista empresas pré-cadastradas com seus dados e competências desejadas.
- Cadastro interativo via terminal de novos candidatos.
- Cadastro interativo via terminal de novas empresas.
- Persistência dos dados em arquivos JSON para manter informações entre execuções.
- Menu simples de navegação via terminal.

---

## Estrutura do Projeto

- `IPessoa.groovy` - Interface comum para candidatos e empresas.
- `Pessoa.groovy` - Classe base herdada por candidatos e empresas.
- `Candidato.groovy` - Classe que representa candidatos.
- `Empresa.groovy` - Classe que representa empresas.
- `LinketinderApp.groovy` - Classe principal com lógica do sistema, menu, controle de fluxo e persistência.
- `Main.groovy` - Script para iniciar a aplicação.

---

## Persistência de Dados

- Ao executar o programa pela primeira vez, arquivos `candidatos.json` e `empresas.json` são criados automaticamente com dados iniciais.
- Caso esses arquivos sejam apagados, os dados iniciais pré-definidos são recarregados e salvos novamente na próxima execução.
- Novos cadastros realizados durante a execução são automaticamente salvos nos arquivos JSON.
- Isso garante que os dados permaneçam persistidos entre diferentes execuções do programa.


---

## Como Executar

1. Certifique-se que o Groovy está instalado e configurado no seu sistema.

2. Coloque todos os arquivos `.groovy` no mesmo diretório, por exemplo `src/`.
   Va para a pasta src e abra o terminal
3. Execute o script principal com o comando:
   groovy Main.groovy

4. Use o menu para listar candidatos, empresas ou cadastrar novos registros.

---

## Comentários

- O projeto implementa POO e estrutura de dados para um sistema simplificado de recrutamento.
- Utiliza classes Groovy com listas para armazenar objetos em memória.
- O foco principal foi a praticidade e clareza, com interface via terminal.
- Esta versão é um MVP e pode ser expandida com persistência, interface gráfica e funcionalidades adicionais.

---

## Autor

Nome: Ana Luiza Reis

