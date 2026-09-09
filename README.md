# 🌱 Sistema Impacta

- Heitor Queiroga Tavares

## Gestão de Ações Socioambientais

O **Sistema Impacta** é um projeto desenvolvido em Java para o gerenciamento de ações socioambientais e controle da participação de voluntários.

O projeto foi desenvolvido como parte da **1ª Fase da disciplina Programar em Linguagem Orientada a Objetos Avançada**, com foco na aplicação de conceitos de Programação Orientada a Objetos.

**Aluno:** Heitor Queiroga Tavares
**Docente:** Samara Sonale Santos Sampaio

---

## 🎯 Objetivo

O sistema tem como objetivo permitir o cadastro e gerenciamento de:

* 👤 Voluntários
* 🌱 Ações de plantio
* ♻️ Mutirões
* 📚 Oficinas
* 📝 Inscrições em ações
* ⭐ Pontuação dos voluntários

---

## 🏗️ Estrutura do Projeto

```text
Sistema-Impacta/
└── projeto/
    └── java/
        ├── Acao.java
        ├── AcaoLotadaException.java
        ├── EmailDuplicadoException.java
        ├── Impacta.java
        ├── Mutirao.java
        ├── Oficina.java
        ├── Plantio.java
        ├── Voluntario.java
        └── VoluntarioJaInscritoException.java
```

---

## 📚 Classes do Sistema

### `Acao`

Classe **abstrata** que representa uma ação socioambiental.

Possui informações comuns às ações:

* ID
* Título
* Descrição
* Data
* Número máximo de participantes
* Lista de voluntários

Também possui o método abstrato `calcularPontuacao()`, que é implementado de forma diferente por cada tipo de ação.

---

### `Plantio`

Representa uma ação de plantio.

A pontuação é calculada de acordo com a quantidade de mudas:

```text
5 + (2 × quantidade de mudas)
```

---

### `Mutirao`

Representa uma ação de mutirão.

A pontuação é calculada de acordo com a duração:

```text
4 × duração em horas
```

---

### `Oficina`

Representa uma ação de oficina.

A pontuação considera a duração da atividade e a existência de um kit de materiais.

```text
3 × duração em horas + bônus do kit
```

---

### `Voluntario`

Representa um participante do sistema.

Armazena:

* Nome
* E-mail
* Matrícula
* Quantidade de ações realizadas
* Pontuação acumulada

---

### `Impacta`

É a principal classe de gerenciamento do sistema.

É responsável por:

* Cadastrar voluntários
* Cadastrar ações
* Buscar voluntários
* Buscar ações
* Inscrever voluntários
* Atualizar pontuação
* Listar voluntários por pontuação

A classe também controla a geração dos IDs das ações.

---

## ⚠️ Exceções Personalizadas

### `EmailDuplicadoException`

Utilizada quando é tentado cadastrar um voluntário utilizando um e-mail que já está cadastrado.

### `AcaoLotadaException`

Utilizada quando uma ação já atingiu o número máximo de participantes.

### `VoluntarioJaInscritoException`

Utilizada quando um voluntário tenta se inscrever novamente em uma ação da qual já participa.

---

## 🧠 Conceitos de POO

O projeto utiliza diversos conceitos de Programação Orientada a Objetos.

### Encapsulamento

Os atributos das classes são definidos como `private`, sendo acessados através de métodos.

### Abstração

A classe `Acao` é abstrata e concentra as características comuns aos diferentes tipos de ações.

### Herança

As classes:

```java
Plantio
Mutirao
Oficina
```

herdam de:

```java
Acao
```

### Polimorfismo

Cada tipo de ação possui sua própria implementação do método:

```java
calcularPontuacao()
```

### Sobrescrita

As classes filhas sobrescrevem métodos da classe `Acao` utilizando `@Override`.

---

## 🔄 Funcionamento

O funcionamento básico do sistema segue o fluxo:

```text
Cadastro de voluntário
        ↓
Cadastro de ação
        ↓
Escolha da ação
        ↓
Inscrição do voluntário
        ↓
Verificação das regras
        ↓
Participação registrada
        ↓
Pontuação calculada
        ↓
Pontuação atualizada
```

Durante uma inscrição, o sistema verifica:

1. Se o voluntário existe;
2. Se a ação existe;
3. Se o voluntário já está inscrito;
4. Se a ação ainda possui vagas.

---

## 🛠️ Tecnologias

* Java
* Programação Orientada a Objetos
* `ArrayList`
* `LocalDateTime`
* `Comparator`
* Exceções personalizadas

---

## 🎓 Projeto Acadêmico

Projeto desenvolvido para a **1ª Fase da disciplina Programar em Linguagem Orientada a Objetos Avançada**.

**Sistema Impacta — Gestão de Ações Socioambientais 🌱**
