package Projeto.projeto.java;

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Acao {
    private int id; private String titulo;
    private String descricao;
    private LocalDateTime data;
    private int maxParticipantes;
    private ArrayList<Voluntario> voluntarios;
    public Acao(int id, String titulo, String descricao, LocalDateTime data, int maxParticipantes) {
        this.id=id;
        this.titulo=titulo;
        this.descricao=descricao;
        this.data=data;
        this.maxParticipantes=maxParticipantes;
        voluntarios=new ArrayList<>();
    }
    public int getId(){return id;}
    public String getTitulo(){return titulo;}
    public String getDescricao(){return descricao;}
    public LocalDateTime getData(){return data;}
    public int getMaxParticipantes(){return maxParticipantes;}
    public ArrayList<Voluntario> getVoluntarios(){return voluntarios;}
    public abstract int calcularPontuacao();
    public String detalhesBase(){
        String resultado=
                "Título: "+titulo+"\nDescrição: "+descricao+"\nData: "+data+"\nPontuação: "+calcularPontuacao()+"\nVoluntários inscritos:\n";
        for(Voluntario v: voluntarios) resultado += "- "+v.getNome()+"\n";
        return resultado;
    }
}