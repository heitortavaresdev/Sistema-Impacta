package Projeto.projeto.java;

import java.time.LocalDateTime;

public class Plantio extends Acao {
    private int qtdMudas;
    public Plantio(int id,String titulo,String descricao,LocalDateTime data,int maxParticipantes,int qtdMudas){super(id,titulo,descricao,data,maxParticipantes);
        this.qtdMudas=qtdMudas;}
    public int getQtdMudas(){return qtdMudas;}
    @Override public int calcularPontuacao(){return 5+2*qtdMudas;}
    @Override public String detalhesBase(){return "Tipo: Plantio de Mudas\nQuantidade de mudas: "+qtdMudas+"\n"+super.detalhesBase();}
}