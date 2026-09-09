package Projeto.projeto.java;

import java.time.LocalDateTime;

public class Oficina extends Acao {
    private int duracaoHoras;
    private boolean kitMaterial;
    public Oficina(int id,String titulo,String descricao,LocalDateTime data,int maxParticipantes,int duracaoHoras,boolean kitMaterial){super(id,titulo,descricao,data,maxParticipantes);
        this.duracaoHoras=duracaoHoras;
        this.kitMaterial=kitMaterial;}
    public int getDuracaoHoras(){return duracaoHoras;}
    public boolean isKitMaterial(){return kitMaterial;}
    @Override public int calcularPontuacao(){return 3*duracaoHoras+(kitMaterial?10:0);}
    @Override public String detalhesBase(){return
            "Tipo: Oficina Ecológica\nDuração: "+duracaoHoras+" horas\nKit de material: "+(kitMaterial?"Sim":"Não")+"\n"+super.detalhesBase();}
}