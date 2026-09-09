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
    void cadastrarVoluntarioTeste() {
        assertTrue(
                impacta.cadastrarVoluntario(
                        "Lucas",
                        "lucas@email.com",
                        "101"
                )
        );
    }
    @Test
    void cadastrarEmailDuplicadoTeste() {
        impacta.cadastrarVoluntario(
                "Lucas",
                "lucas@email.com",
                "101"
        );
        assertThrows(
                EmailDuplicadoException.class,
                () -> impacta.cadastrarVoluntario(
                        "Bruno",
                        "lucas@email.com",
                        "202"
                )
        );
    }
    @Test
    void exibirVoluntarioTeste() {
        impacta.cadastrarVoluntario(
                "Amanda",
                "amanda@email.com",
                "303"
        );
        assertEquals(
                "Amanda - amanda@email.com - 303 - Ações: 0 - Pontuação: 0",
                impacta.exibirVoluntario("amanda@email.com")
        );
    }
    @Test
    void cadastrarPlantioTeste() {
        int id = impacta.cadastrarPlantio(
                "Plantio Comunitario",
                "Plantio de mudas",
                LocalDateTime.now().toString(),
                10,
                5
        );
        assertEquals(1, id);
    }
    @Test
    void pontuacaoPlantioTeste() {
        Plantio plantio = new Plantio(
                1,
                "Plantio Verde",
                "Plantio de arvores",
                LocalDateTime.now(),
                10,
                5
        );
        assertEquals(5, plantio.getQtdMudas());
        assertEquals(15, plantio.calcularPontuacao());
    }
    @Test
    void cadastrarMutiraoTeste() {
        int id = impacta.cadastrarMutirao(
                "Mutirao Ambiental",
                "Limpeza de uma praca",
                LocalDateTime.now().toString(),
                8,
                4
        );
        assertEquals(1, id);
    }
    @Test
    void pontuacaoMutiraoTeste() {
        Mutirao mutirao = new Mutirao(
                1,
                "Mutirao Verde",
                "Limpeza ambiental",
                LocalDateTime.now(),
                10,
                4
        );
        assertEquals(4, mutirao.getDuracaoHoras());
        assertEquals(16, mutirao.calcularPontuacao());
    }
    @Test
    void cadastrarOficinaTeste() {
        int id = impacta.cadastrarOficina(
                "Oficina Sustentavel",
                "Atividade sobre reciclagem",
                LocalDateTime.now().toString(),
                10,
                3,
                true
        );
        assertEquals(1, id);
    }
    @Test
    void pontuacaoOficinaComKitTeste() {
        Oficina oficina = new Oficina(
                1,
                "Oficina Verde",
                "Reciclagem de materiais",
                LocalDateTime.now(),
                10,
                3,
                true
        );
        assertEquals(3, oficina.getDuracaoHoras());
        assertTrue(oficina.isKitMaterial());
        assertEquals(19, oficina.calcularPontuacao());
    }
    @Test
    void pontuacaoOficinaSemKitTeste() {
        Oficina oficina = new Oficina(
                1,
                "Educacao Ambiental",
                "Palestra sobre sustentabilidade",
                LocalDateTime.now(),
                10,
                3,
                false
        );
        assertEquals(3, oficina.getDuracaoHoras());
        assertFalse(oficina.isKitMaterial());
        assertEquals(9, oficina.calcularPontuacao());
    }
    @Test
    void inscreverVoluntarioTeste() {
        impacta.cadastrarVoluntario(
                "Pedro",
                "pedro@email.com",
                "404"
        );
        int id = impacta.cadastrarPlantio(
                "Plantio Local",
                "Plantio de mudas",
                LocalDateTime.now().toString(),
                5,
                4
        );
        assertTrue(
                impacta.inscreverVoluntario(
                        "pedro@email.com",
                        id
                )
        );
        assertEquals(
                "Pedro - pedro@email.com - 404 - Ações: 1 - Pontuação: 13",
                impacta.exibirVoluntario("pedro@email.com")
        );
    }
    @Test
    void voluntarioNaoEncontradoTeste() {
        int id = impacta.cadastrarPlantio(
                "Plantio",
                "Plantio comunitario",
                LocalDateTime.now().toString(),
                5,
                2
        );
        assertFalse(
                impacta.inscreverVoluntario(
                        "naoexiste@email.com",
                        id
                )
        );
    }
    @Test
    void acaoNaoEncontradaTeste() {
        impacta.cadastrarVoluntario(
                "Rafael",
                "rafael@email.com",
                "505"
        );
        assertFalse(
                impacta.inscreverVoluntario(
                        "rafael@email.com",
                        999
                )
        );
    }
    @Test
    void voluntarioJaInscritoTeste() {
        impacta.cadastrarVoluntario(
                "Carla",
                "carla@email.com",
                "606"
        );
        int id = impacta.cadastrarPlantio(
                "Plantio Repetido",
                "Plantio ambiental",
                LocalDateTime.now().toString(),
                5,
                3
        );
        impacta.inscreverVoluntario(
                "carla@email.com",
                id
        );
        assertThrows(
                VoluntarioJaInscritoException.class,
                () -> impacta.inscreverVoluntario(
                        "carla@email.com",
                        id
                )
        );
    }
    @Test
    void acaoLotadaTeste() {
        impacta.cadastrarVoluntario(
                "Felipe",
                "felipe@email.com",
                "707"
        );
        impacta.cadastrarVoluntario(
                "Julia",
                "julia@email.com",
                "808"
        );
        int id = impacta.cadastrarPlantio(
                "Plantio Limitado",
                "Acao com uma vaga",
                LocalDateTime.now().toString(),
                1,
                2
        );
        impacta.inscreverVoluntario(
                "felipe@email.com",
                id
        );
        assertThrows(
                AcaoLotadaException.class,
                () -> impacta.inscreverVoluntario(
                        "julia@email.com",
                        id
                )
        );
    }
    @Test
    void listarVoluntariosPorPontuacaoTeste() {
        impacta.cadastrarVoluntario(
                "Carlos",
                "carlos@email.com",
                "111"
        );
        impacta.cadastrarVoluntario(
                "Ana",
                "ana@email.com",
                "222"
        );
        impacta.cadastrarVoluntario(
                "Bruno",
                "bruno@email.com",
                "333"
        );
        int plantioMaior = impacta.cadastrarPlantio(
                "Plantio Grande",
                "Plantio de muitas mudas",
                LocalDateTime.now().toString(),
                5,
                8
        );
        int plantioMenor = impacta.cadastrarPlantio(
                "Plantio Pequeno",
                "Plantio de poucas mudas",
                LocalDateTime.now().toString(),
                5,
                2
        );
        impacta.inscreverVoluntario(
                "carlos@email.com",
                plantioMenor
        );
        impacta.inscreverVoluntario(
                "ana@email.com",
                plantioMaior
        );
        String[] resultado = impacta.listarVoluntarios();
        String[] esperado = {
                "Ana - ana@email.com - 222 - Ações: 1 - Pontuação: 21",
                "Carlos - carlos@email.com - 111 - Ações: 1 - Pontuação: 9",
                "Bruno - bruno@email.com - 333 - Ações: 0 - Pontuação: 0"
        };
        assertArrayEquals(esperado, resultado);
    }
    @Test
    void detalhesAcaoTeste() {
        int id = impacta.cadastrarPlantio(
                "Acao Verde",
                "Plantio de arvores",
                "2026-09-09T10:00:00",
                10,
                5
        );
        assertNotNull(
                impacta.exibirDetalhesAcao(id)
        );
    }
    @Test
    void detalhesAcaoInexistenteTeste() {
        assertNull(
                impacta.exibirDetalhesAcao(999)
        );
    }
    @Test
    void idsDasAcoesDevemSerSequenciaisTeste() {
        int primeiro = impacta.cadastrarPlantio(
                "Primeiro Plantio",
                "Primeira acao",
                LocalDateTime.now().toString(),
                5,
                2
        );
        int segundo = impacta.cadastrarMutirao(
                "Segundo Mutirao",
                "Segunda acao",
                LocalDateTime.now().toString(),
                5,
                2
        );
        int terceiro = impacta.cadastrarOficina(
                "Terceira Oficina",
                "Terceira acao",
                LocalDateTime.now().toString(),
                5,
                2,
                false
        );
        assertEquals(1, primeiro);
        assertEquals(2, segundo);
        assertEquals(3, terceiro);
    }
}
