# 🌱 Sistema Impacta

### Gestão de Ações Socioambientais

Sistema desenvolvido em **Java** para gerenciamento de ações socioambientais e controle da participação de voluntários.

Projeto desenvolvido como parte da **1ª Fase da disciplina Programar em Linguagem Orientada a Objetos Avançada**.

---

## 👨‍💻 Informações do Projeto

**Aluno:** Heitor Queiroga Tavares
**Disciplina:** Programar em Linguagem Orientada a Objetos Avançada

---

## 🎯 Objetivo

O Sistema Impacta tem como objetivo permitir o gerenciamento de ações socioambientais e dos voluntários participantes.

O sistema permite:

* Cadastro de voluntários;
* Cadastro de ações;
* Cadastro de diferentes tipos de ações;
* Inscrição de voluntários em ações;
* Controle do limite de participantes;
* Cálculo da pontuação;
* Controle da pontuação acumulada dos voluntários;
* Listagem dos voluntários por pontuação.

---

## 🏗️ Estrutura do Projeto

```text
Sistema-Impacta/
└── projeto/
    ├── java/
    │   ├── Acao.java
    │   ├── Plantio.java
    │   ├── Mutirao.java
    │   ├── Oficina.java
    │   ├── Voluntario.java
    │   ├── Impacta.java
    │   ├── AcaoLotadaException.java
    │   ├── EmailDuplicadoException.java
    │   └── VoluntarioJaInscritoException.java
    │
    └── test/
        └── ImpactaTest.java
```

---

## 📚 Classes do Sistema

### `Acao`

Classe abstrata que representa uma ação socioambiental.

Possui informações comuns às ações, como:

* ID;
* Título;
* Descrição;
* Data;
* Limite de participantes;
* Lista de voluntários.

Também possui o método responsável pelo cálculo da pontuação da ação.

### `Plantio`

Representa uma ação de plantio.

A pontuação é calculada de acordo com a quantidade de mudas:

```text
5 + (2 × quantidade de mudas)
```

### `Mutirao`

Representa uma ação de mutirão.

A pontuação é calculada de acordo com a duração da ação:

```text
4 × duração em horas
```

### `Oficina`

Representa uma ação de oficina.

A pontuação considera a duração da oficina e o bônus relacionado ao kit de materiais:

```text
3 × duração em horas + bônus do kit
```

### `Voluntario`

Representa um voluntário cadastrado no sistema.

Armazena informações como:

* Nome;
* E-mail;
* Matrícula;
* Quantidade de ações realizadas;
* Pontuação acumulada.

### `Impacta`

É a classe principal responsável pelo gerenciamento das funcionalidades do sistema.

Entre suas funções estão:

* Cadastrar voluntários;
* Cadastrar ações;
* Buscar voluntários;
* Buscar ações;
* Realizar inscrições;
* Atualizar pontuação;
* Listar voluntários.

---

## 🧪 Classe de Testes

### `ImpactaTest`

A classe `ImpactaTest` é responsável por testar as principais funcionalidades da classe `Impacta`.

Os testes verificam se o sistema apresenta o comportamento esperado em diferentes situações.

Entre os testes realizados estão:

* Cadastro de voluntários;
* Cadastro com e-mail duplicado;
* Busca de voluntários;
* Cadastro de ações;
* Busca de ações;
* Inscrição de voluntários;
* Tentativa de inscrição duplicada;
* Ação lotada;
* Cálculo de pontuação;
* Atualização da pontuação dos voluntários;
* Listagem dos voluntários.

A classe utiliza **JUnit 5** para criação e execução dos testes.

Exemplo da estrutura utilizada:

```java
@BeforeEach
public void setUp() {
    impacta = new Impacta();
}
```

O `@BeforeEach` cria uma nova instância do sistema antes de cada teste, garantindo que os testes sejam executados de forma independente.

Os testes utilizam métodos como:

```java
assertTrue()
assertFalse()
assertEquals()
assertThrows()
```

para verificar se os resultados obtidos estão de acordo com o comportamento esperado.

---

## ⚠️ Exceções

O sistema possui exceções personalizadas para tratar situações inválidas.

| Exceção                         | Situação                               |
| ------------------------------- | -------------------------------------- |
| `EmailDuplicadoException`       | E-mail já cadastrado                   |
| `AcaoLotadaException`           | Ação atingiu o limite de participantes |
| `VoluntarioJaInscritoException` | Voluntário já está inscrito na ação    |

Essas situações também são verificadas pelos testes da classe `ImpactaTest`.

---

## 🧠 Conceitos de Orientação a Objetos

O projeto utiliza conceitos fundamentais de Programação Orientada a Objetos.

### Encapsulamento

Os atributos das classes são protegidos utilizando `private`, com acesso controlado por métodos.

### Herança

As classes `Plantio`, `Mutirao` e `Oficina` herdam características da classe `Acao`.

```java
public class Plantio extends Acao
```

### Abstração

A classe `Acao` é abstrata e define características e comportamentos comuns aos diferentes tipos de ações.

```java
public abstract class Acao
```

### Polimorfismo

O método `calcularPontuacao()` apresenta comportamentos diferentes de acordo com o tipo de ação.

### Sobrescrita de métodos

As classes derivadas utilizam `@Override` para implementar comportamentos específicos.

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

Durante a inscrição, o sistema verifica:

* Se o voluntário existe;
* Se a ação existe;
* Se o voluntário já está inscrito;
* Se a ação ainda possui vagas.

---

## ☕ Tecnologias Utilizadas

* **Java**
* **JUnit 5**
* Programação Orientada a Objetos
* `ArrayList`
* `LocalDateTime`
* `Comparator`
* Exceções personalizadas

---

## 📌 Projeto Acadêmico

Projeto desenvolvido para a **1ª Fase da disciplina Programar em Linguagem Orientada a Objetos Avançada**.

**Sistema Impacta — Gestão de Ações Socioambientais 🌱**
