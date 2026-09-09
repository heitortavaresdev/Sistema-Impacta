package Projeto.test.java;

import Projeto.projeto.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ImpactaTest {
    private Impacta impacta;
    @BeforeEach
    public void setUp() {
        impacta = new Impacta();
    }
    @Test
    void cadastrarEmailDuplicadoTeste() {
        impacta.cadastrarVoluntario("Gabriel", "gabriel@email.com", "789");
        assertThrows(EmailDuplicadoException.class, () -> {
            impacta.cadastrarVoluntario("Rafael", "gabriel@email.com", "654");
        });
    }
    @Test
    void cadastrarVoluntarioSucessoTeste() {
        assertTrue(
                impacta.cadastrarVoluntario(
                        "Mariana",
                        "mariana@email.com",
                        "456"
                )
        );
    }
    @Test
    void inscreverVoluntarioTeste() {
        impacta.cadastrarVoluntario(
                "Pedro",
                "pedro@email.com",
                "987"
        );
        int idAcao = impacta.cadastrarPlantio(
                "Plantio Comunitário",
                "Plantio de árvores no bairro",
                LocalDateTime.now().toString(),
                8,
                6
        );
        assertTrue(
                impacta.inscreverVoluntario(
                        "pedro@email.com",
                        idAcao
                )
        );
    }
    @Test
    void cadastrarPlantioSucessoTeste() {
        int id = impacta.cadastrarPlantio(
                "Árvores para a Comunidade",
                "Plantio de mudas nativas",
                LocalDateTime.now().toString(),
                6,
                5
        );
        assertEquals(1, id);
    }
    @Test
    void cadastrarPlantioComResultadoCorretoTeste() {
        Plantio plantio = new Plantio(
                8,
                "Projeto Verde",
                "Recuperação de uma área degradada",
                LocalDateTime.now(),
                12,
                9
        );
        assertEquals("Projeto Verde", plantio.getTitulo());
        assertEquals(
                "Recuperação de uma área degradada",
                plantio.getDescricao()
        );
        assertEquals(9, plantio.getQtdMudas());
        assertEquals(23, plantio.calcularPontuacao());
    }
    @Test
    void cadastrarMutiraoSucessoTeste() {
        int id = impacta.cadastrarMutirao(
                "Mutirão de Limpeza",
                "Limpeza de uma praça pública",
                LocalDateTime.now().toString(),
                4,
                3
        );
        assertEquals(1, id);
        int id2 = impacta.cadastrarMutirao(
                "Reciclagem no Bairro",
                "Coleta de materiais recicláveis",
                LocalDateTime.now().toString(),
                7,
                5
        );
        assertEquals(2, id2);
    }
    @Test
    void cadastrarMutiraoComResultadoCorretoTeste() {
        Mutirao mutirao = new Mutirao(
                4,
                "Ação Recicla",
                "Separação de materiais recicláveis",
                LocalDateTime.now(),
                15,
                3
        );
        assertEquals("Ação Recicla", mutirao.getTitulo());
        assertEquals(
                "Separação de materiais recicláveis",
                mutirao.getDescricao()
        );
        assertEquals(3, mutirao.getDuracaoHoras());
        assertEquals(12, mutirao.calcularPontuacao());
    }
    @Test
    void cadastrarOficinaComResultadoCorretoComKitTeste() {
        Oficina oficina = new Oficina(
                6,
                "Oficina Sustentável",
                "Produção de materiais reutilizáveis",
                LocalDateTime.now(),
                10,
                2,
                true
        );
        assertEquals("Oficina Sustentável", oficina.getTitulo());
        assertEquals(2, oficina.getDuracaoHoras());
        assertTrue(oficina.isKitMaterial());
        assertEquals(16, oficina.calcularPontuacao());
    }
    @Test
    void cadastrarOficinaComResultadoCorretoSemKitTeste() {
        Oficina oficina = new Oficina(
                9,
                "Educação Ambiental",
                "Palestra sobre sustentabilidade",
                LocalDateTime.now(),
                20,
                5,
                false
        );
        assertEquals("Educação Ambiental", oficina.getTitulo());
        assertEquals(5, oficina.getDuracaoHoras());
        assertFalse(oficina.isKitMaterial());
        assertEquals(15, oficina.calcularPontuacao());
    }
    @Test
    void exibirVoluntarioTeste() {
        impacta.cadastrarVoluntario(
                "Juliana",
                "juliana@email.com",
                "321"
        );
        assertEquals(
                "Juliana - juliana@email.com - 321 - Ações: 0 - Pontuação: 0",
                impacta.exibirVoluntario("juliana@email.com")
        );
    }
    @Test
    void listarVoluntariosOrdenadoPorPontuacaoTeste() {
        impacta.cadastrarVoluntario(
                "Felipe",
                "felipe@email.com",
                "111"
        );
        impacta.cadastrarVoluntario(
                "Camila",
                "camila@email.com",
                "222"
        );
        impacta.cadastrarVoluntario(
                "Diego",
                "diego@email.com",
                "333"
        );
        int idAcao1 = impacta.cadastrarPlantio(
                "Grande Plantio",
                "Plantio de várias mudas",
                LocalDateTime.now().toString(),
                10,
                8
        );
        int idAcao2 = impacta.cadastrarPlantio(
                "Pequeno Plantio",
                "Plantio de poucas mudas",
                LocalDateTime.now().toString(),
                10,
                2
        );
        impacta.inscreverVoluntario(
                "felipe@email.com",
                idAcao2
        );
        impacta.inscreverVoluntario(
                "camila@email.com",
                idAcao1
        );
        String[] resultado = impacta.listarVoluntarios();
        String[] esperado = {
                "Camila - camila@email.com - 222 - Ações: 1 - Pontuação: 21",
                "Felipe - felipe@email.com - 111 - Ações: 1 - Pontuação: 9",
                "Diego - diego@email.com - 333 - Ações: 0 - Pontuação: 0"
        };
        assertArrayEquals(esperado, resultado);
    }
    @Test
    void inscreverVoluntarioEmAcaoLotadaDeveLancarExcecao() {
        impacta.cadastrarVoluntario(
                "Larissa",
                "larissa@email.com",
                "555"
        );
        impacta.cadastrarVoluntario(
                "Renato",
                "renato@email.com",
                "666"
        );
        int idAcao = impacta.cadastrarPlantio(
                "Plantio Limitado",
                "Ação com poucas vagas",
                LocalDateTime.now().toString(),
                1,
                4
        );
        impacta.inscreverVoluntario(
                "larissa@email.com",
                idAcao
        );
        assertThrows(AcaoLotadaException.class, () -> {
            impacta.inscreverVoluntario(
                    "renato@email.com",
                    idAcao
            );
        });
    }
    @Test
    void inscreverMesmoVoluntarioDuasVezesDeveLancarExcecao() {
        impacta.cadastrarVoluntario(
                "Beatriz",
                "beatriz@email.com",
                "777"
        );
        int idAcao = impacta.cadastrarPlantio(
                "Plantio Repetido",
                "Ação de preservação ambiental",
                LocalDateTime.now().toString(),
                10,
                3
        );
        impacta.inscreverVoluntario(
                "beatriz@email.com",
                idAcao
        );
        assertThrows(VoluntarioJaInscritoException.class, () -> {
            impacta.inscreverVoluntario(
                    "beatriz@email.com",
                    idAcao
            );
        });
    }
    @Test
    void cadastrarOficinaSucessoTeste() {
        int id = impacta.cadastrarOficina(
                "Oficina de Reciclagem",
                "Criação de objetos com materiais recicláveis",
                LocalDateTime.now().toString(),
                8,
                4,
                true
        );
        assertEquals(1, id);
    }
}