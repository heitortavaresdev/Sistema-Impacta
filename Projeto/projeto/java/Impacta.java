package Projeto.projeto.java;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Impacta {
    private ArrayList<Voluntario> voluntarios = new ArrayList<>();
    private ArrayList<Acao> acoes = new ArrayList<>();
    private int proximoId = 1;

    public boolean cadastrarVoluntario(String nome,String email,String matricula){
        for(Voluntario v:voluntarios)
            if(v.getEmail().equals(email))
                throw new EmailDuplicadoException("E-mail já cadastrado.");
        voluntarios.add(new Voluntario(nome,email,matricula));
        return true;
    }
    public String exibirVoluntario(String email){
        for(Voluntario v:voluntarios)
            if(v.getEmail().equals(email))
                return v.exibir();
        return null;}
    public String[] listarVoluntarios(){
        ArrayList<Voluntario> lista=new ArrayList<>(voluntarios);
        lista.sort(Comparator.comparingInt(Voluntario::getPontuacao).reversed().thenComparing(Voluntario::getNome));
        String[] resultado=new String[lista.size()];
        for(int i=0;
            i<lista.size();
            i++) resultado[i]=lista.get(i).exibir();
        return resultado;
    }
    public int cadastrarPlantio(String titulo,String descricao,String data,int maxParticipantes,int qtdMudas){
        Plantio a=new Plantio(proximoId++,titulo,descricao,LocalDateTime.parse(data),maxParticipantes,qtdMudas);
        acoes.add(a);
        return a.getId();
    }
    public int cadastrarMutirao(String titulo,String descricao,String data,int maxParticipantes,int duracaoHoras){
        Mutirao a=new Mutirao(proximoId++,titulo,descricao,LocalDateTime.parse(data),maxParticipantes,duracaoHoras);
        acoes.add(a);
        return a.getId();
    }
    public int cadastrarOficina(String titulo,String descricao,String data,int maxParticipantes,int duracaoHoras,boolean kitMaterial){
        Oficina a=new Oficina(proximoId++,titulo,descricao,LocalDateTime.parse(data),maxParticipantes,duracaoHoras,kitMaterial);
        acoes.add(a);
        return a.getId();
    }
    public boolean inscreverVoluntario(String emailVoluntario,int idAcao){
        Voluntario v=encontrarVoluntario(emailVoluntario);
        Acao a=encontrarAcao(idAcao);
        if(v==null||a==null)
            return false;
        if(a.getVoluntarios().contains(v))
            throw new VoluntarioJaInscritoException("Voluntário já está inscrito nessa ação.");
        if(a.getVoluntarios().size()>=a.getMaxParticipantes())
            throw new AcaoLotadaException("A ação já atingiu o limite de participantes.");
        a.getVoluntarios().add(v); v.participarAcao(a.calcularPontuacao());
        return true;
    }
    public String exibirDetalhesAcao(int idAcao){Acao a=encontrarAcao(idAcao);
        return a==null?null:a.detalhesBase();}
    private Voluntario encontrarVoluntario(String email){
        for(Voluntario v:voluntarios)
            if(v.getEmail().equals(email))
                return v;
        return null;}
    private Acao encontrarAcao(int id){
        for(Acao a:acoes)
            if(a.getId()==id)
                return a;
        return null;}
}