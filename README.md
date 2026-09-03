# 🌱 Sistema Impacta
Aluno: Heitor Queiroga Tavares
Docente: Samara Sonale Santos Sampaio
Competência: Programar em linguagem orientada a objetos avançada

### Gestão de Ações Socioambientais

O **Sistema Impacta** é um sistema desenvolvido em **Java** para gerenciamento de ações socioambientais e controle da participação de voluntários.

O projeto foi desenvolvido como parte da **1ª Fase da disciplina de Programação Orientada a Objetos**, com foco na aplicação dos principais conceitos de **POO**.

---

## 🎯 Objetivo

O sistema tem como objetivo permitir o gerenciamento de:

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
        ├── Plantio.java
        ├── Mutirao.java
        ├── Oficina.java
        ├── Voluntario.java
        ├── Impacta.java
        ├── AcaoLotadaException.java
        ├── EmailDuplicadoException.java
        └── VoluntarioJaInscritoException.java
```

---

## 📚 Classes

### `Acao`

Classe abstrata que serve como base para os diferentes tipos de ações do sistema.

Contém informações comuns como:

* ID
* Título
* Descrição
* Data
* Número máximo de participantes
* Lista de voluntários

Também define o método de cálculo da pontuação.

### `Plantio`

Representa uma ação de plantio.

A pontuação é calculada de acordo com a quantidade de mudas:

```text
5 + (2 × quantidade de mudas)
```

### `Mutirao`

Representa uma ação de mutirão.

A pontuação é calculada de acordo com a duração:

```text
4 × duração em horas
```

### `Oficina`

Representa uma ação de oficina.

A pontuação considera a duração e a presença de kit de materiais:

```text
3 × duração em horas + bônus do kit
```

### `Voluntario`

Representa os participantes do sistema.

Armazena informações como:

* Nome
* E-mail
* Matrícula
* Quantidade de ações realizadas
* Pontuação acumulada

### `Impacta`

É a principal classe de gerenciamento do sistema.

É responsável por funcionalidades como:

* Cadastro de voluntários
* Cadastro de ações
* Busca de voluntários
* Busca de ações
* Inscrição em ações
* Atualização da pontuação
* Listagem dos voluntários

### Exceções personalizadas

O sistema possui exceções específicas para situações inválidas:

| Exceção                         | Situação                               |
| ------------------------------- | -------------------------------------- |
| `EmailDuplicadoException`       | E-mail já cadastrado                   |
| `AcaoLotadaException`           | Ação atingiu o limite de participantes |
| `VoluntarioJaInscritoException` | Voluntário já está inscrito na ação    |

---

## 🧠 Conceitos de POO utilizados

O projeto aplica conceitos fundamentais de **Programação Orientada a Objetos**:

### Encapsulamento

Os atributos das classes são protegidos utilizando `private`, com acesso controlado através de métodos.

### Herança

As classes `Plantio`, `Mutirao` e `Oficina` herdam características de `Acao`.

```java
public class Plantio extends Acao
```

### Abstração

`Acao` é uma classe abstrata que define características e comportamentos comuns às ações.

```java
public abstract class Acao
```

### Polimorfismo

O método `calcularPontuacao()` possui comportamentos diferentes dependendo do tipo de ação.

### Sobrescrita de métodos

As classes filhas utilizam `@Override` para implementar seus próprios comportamentos.

---

## 🔄 Funcionamento básico

O fluxo principal do sistema pode ser representado da seguinte forma:

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
Pontuação do voluntário atualizada
```

Durante a inscrição, o sistema verifica se:

* O voluntário existe;
* A ação existe;
* O voluntário já está inscrito;
* A ação atingiu o limite de participantes.

---

## ☕ Tecnologias

* **Java**
* Programação Orientada a Objetos
* `ArrayList`
* `LocalDateTime`
* Exceções personalizadas
* `Comparator`

---

## 👨‍💻 Projeto

Projeto acadêmico desenvolvido para a **1ª Fase de Programação Orientada a Objetos**.

**Sistema Impacta — Gestão de Ações Socioambientais** 🌱
