# Sistema Acadêmico

Este documento visa apresentar a forma como o sistema acadêmico foi construído, fornecendo informações relevantes acerca do projeto, tais como a linguagem de programação utilizada, a arquitetura de software e o design pattern escolhidos.

## Índice

- [Sobre](#sobre)
- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Autores](#autores)
- [Agradecimentos](#agradecimentos)

## Sobre

### Tema do Projeto

Sistema Acadêmico

### Objetivo

O objetivo deste projeto é criar um sistema acadêmico que permita aos usuários (docentes, secretaria e direção de escolas de ensino fundamental e médio) acessar e administrar os dados da escola de forma eficiente. O sistema é projetado para facilitar o processo de matrícula de alunos, registro de aulas, notas e ocorrências, além de promover a comunicação entre o time, proporcionando uma experiência intuitiva e satisfatória para os usuários.

### Descrição do Sistema

Um sistema acadêmico que permite a gestão eficiente de dados escolares, incluindo matrícula de alunos, registro de aulas, notas e ocorrências. O sistema oferece uma interface intuitiva para os usuários, facilitando a administração de informações acadêmicas e a comunicação entre docentes, secretaria e direção.

### Organização do Trabalho

O trabalho foi dividido em quatro partes:
1. Desenvolvimento front-end
2. Criação do banco de dados
3. Desenvolvimento back-end
4. Escrita da documentação

## Especificidades

### Linguagens de Programação Utilizadas

- JavaScript
- HTML

### Arquitetura de Software

- Model-view-controller (MVC)

### Design Pattern

- Facade

### Explicação dos Objetivos do Projeto e Problema que Ele Resolve

#### Objetivos do Projeto

1. **Gerenciamento de Alunos**:
   - Permitir a criação, leitura, atualização e exclusão (CRUD) de informações dos alunos.
   - Manter um registro detalhado de informações pessoais e acadêmicas dos alunos.

2. **Gerenciamento de Professores**:
   - Facilitar o CRUD de informações dos professores, incluindo dados pessoais e de ensino.

3. **Registro de Aulas**:
   - Proporcionar uma maneira de registrar, atualizar, visualizar e deletar registros de aulas, incluindo detalhes como data, hora, local, professor responsável e materiais utilizados.

#### Problema que Resolve

O sistema acadêmico visa resolver a dificuldade de gerenciar informações acadêmicas de forma centralizada e eficiente. Em muitas instituições educacionais, a gestão de dados de alunos, professores e registros de aulas pode ser fragmentada e desorganizada. Este sistema oferece uma solução integrada que melhora a eficiência administrativa, assegura a integridade dos dados e facilita o acesso a informações essenciais para a gestão acadêmica.

### Demonstração da Arquitetura Escolhida

#### Arquitetura de Software

O sistema segue uma arquitetura de camadas (layered architecture), organizada em pelo menos três camadas principais:

1. **Camada de Apresentação (API)**:
   - Esta camada lida com a comunicação entre o cliente (usuário ou outro sistema) e o servidor. Utiliza controladores RESTful para expor endpoints HTTP para operações CRUD.
   - Exemplos: AlunosAPI, ProfessoresAPI, AulasAPI.

2. **Camada de Negócio (Facade)**:
   - Contém a lógica de negócio e as regras para manipulação de dados. Centraliza operações complexas e coordenadas sobre os dados.
   - Exemplos: AlunoFacade, ProfessorFacade, AulaFacade.

3. **Camada de Dados (DTO)**:
   - Define os Data Transfer Objects que são usados para transferir dados entre a camada de apresentação e a camada de negócio.
   - Exemplos: AlunoDTO, ProfessorDTO, AulaDTO.

### Demonstração das Técnicas de Código Limpo Utilizadas

1. **Nomenclatura Descritiva**:
   - Nomes de classes, métodos e variáveis são claros e descritivos, facilitando a compreensão do código. Exemplo: AlunoFacade, criar(), getById().

2. **Responsabilidade Única**:
   - Cada classe tem uma única responsabilidade. Por exemplo, AlunoFacade é responsável apenas pela lógica de negócios de Aluno, enquanto AlunoDTO é responsável pela estrutura de dados de Aluno.

3. **Funções Curtas e Simples**:
   - Os métodos são curtos e focados em uma única tarefa, o que aumenta a legibilidade e facilita a manutenção. Exemplo: o método getAll() retorna uma lista de todos os alunos de forma direta e simples.

4. **Evitar Comentários Desnecessários**:
   - O código é autoexplicativo na maior parte, evitando a necessidade de comentários redundantes. A legibilidade é alcançada através de uma escrita clara e nomes significativos.

5. **Controle de Erros**:
   - Utilização de exceções específicas para tratar erros de forma apropriada, como ResponseStatusException para respostas HTTP específicas.

### Demonstração dos Padrões de Projeto Utilizados

1. **Data Transfer Object (DTO)**:
   - Os DTOs (AlunoDTO, ProfessorDTO, AulaDTO) são usados para encapsular dados e transportar informações entre diferentes camadas do sistema sem expor a estrutura interna.

2. **Facade**:
   - As classes AlunoFacade, ProfessorFacade e AulaFacade servem como fachadas, fornecendo uma interface simplificada para o conjunto de operações possíveis com alunos, professores e aulas. Isso oculta a complexidade da lógica de negócios interna.

3. **Dependency Injection (DI)**:
   - Utilizado amplamente para injeção de dependências entre classes, facilitando o desacoplamento e a substituição de componentes. Exemplo: injeção de AlunoFacade em AlunosAPI.

4. **Controller**:
   - As classes como AlunosAPI, ProfessoresAPI e AulasAPI seguem o padrão de Controller para gerenciar as solicitações HTTP e delegar a lógica de negócios para as classes apropriadas.

## Conclusão

O código apresentado para o sistema acadêmico segue boas práticas de design e implementação, focando na clareza, manutenibilidade e separação de responsabilidades. A arquitetura escolhida facilita o desenvolvimento, a escalabilidade e a manutenção do sistema. Além disso, o uso de padrões de projeto ajuda a estruturar o código de maneira clara e eficiente, garantindo que o sistema seja robusto e fácil de entender.
