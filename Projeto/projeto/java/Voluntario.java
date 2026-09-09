package Projeto.projeto.java;

public class Voluntario {
    private String nome;
    private String email;
    private String matricula;
    private int quantidadeAcoes;
    private int pontuacao;

    public Voluntario(String nome, String email, String matricula) {
        this.nome = nome;
        this.email = email;
        this.matricula = matricula;
    }
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getMatricula() {return matricula;}
    public int getQuantidadeAcoes() {return quantidadeAcoes;}
    public int getPontuacao() {return pontuacao;}
    public void participarAcao(int pontos) {quantidadeAcoes++;
        pontuacao += pontos; }
    public String exibir() {return nome + " - " + email + " - " + matricula + " - Ações: " + quantidadeAcoes + " - Pontuação: " + pontuacao;}
}