package br.com.roberto.escola.dominio.aluno;

import br.com.roberto.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TelefoneTest {

    @Test
    void naoDeveriaCriarTelefonesComDDDInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null,"123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("","123456789"));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("1","123456789"));
    }

    @Test
    void naoDeveriaCriarTelefonesComNumerosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("11",null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("11",""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("11","123"));
    }

    @Test
    void deveriaPermitirCriarTelefoneComDDDENumeroValidos() {
        String ddd = "11";
        String numero = "123456789";
        Telefone telefone = new Telefone(ddd,numero);
        assertEquals(ddd,telefone.getDdd());
        assertEquals(numero,telefone.getNumero());
    }




}
