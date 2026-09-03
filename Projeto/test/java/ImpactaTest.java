package Projeto.test.java;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import Projeto.projeto.java.Impacta;
import Projeto.projeto.java.Mutirao;
import Projeto.projeto.java.Oficina;
import Projeto.projeto.java.Plantio;
import org.junit.jupiter.api.Test;

public class ImpactaTest {
    @org.junit.Test
    @Test public void testarPontuacaoPlantio(){
        Plantio a=new Plantio(1,"Plantio","Teste",LocalDateTime.now(),20,10);
        assertEquals(25,a.calcularPontuacao());}
    @Test public void testarPontuacaoMutirao(){
        Mutirao a=new Mutirao(1,"Mutirão","Teste",LocalDateTime.now(),20,3);
        assertEquals(12,a.calcularPontuacao());}
    @Test public void testarPontuacaoOficina(){
        Oficina a=new Oficina(1,"Oficina","Teste",LocalDateTime.now(),20,4,true);
        assertEquals(22,a.calcularPontuacao());}
    @Test public void testarOrdenacao(){
        Impacta i=new Impacta();
        i.cadastrarVoluntario("Carlos","carlos@email.com","001");
        i.cadastrarVoluntario("Ana","ana@email.com","002");
        i.cadastrarVoluntario("Bruno","bruno@email.com","003");
        int id=i.cadastrarPlantio("Plantio","Teste","2026-09-10T10:00:00",10,5);
        i.inscreverVoluntario("carlos@email.com",id);
        i.inscreverVoluntario("ana@email.com",id);
        String[] r=i.listarVoluntarios();
        assertEquals("Ana - ana@email.com - 002 - Ações: 1 - Pontuação: 15",r[0]);
        assertEquals("Carlos - carlos@email.com - 001 - Ações: 1 - Pontuação: 15",r[1]);
        assertEquals("Bruno - bruno@email.com - 003 - Ações: 0 - Pontuação: 0",r[2]);
    }
}