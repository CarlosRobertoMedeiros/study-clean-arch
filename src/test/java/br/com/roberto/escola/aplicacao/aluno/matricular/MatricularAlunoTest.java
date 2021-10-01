package br.com.roberto.escola.aplicacao.aluno.matricular;

import br.com.roberto.escola.dominio.aluno.Aluno;
import br.com.roberto.escola.dominio.aluno.AlunosRepository;
import br.com.roberto.escola.dominio.aluno.CPF;
import br.com.roberto.escola.infra.aluno.AlunosRepositoryMemory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        AlunosRepository repositorio = new AlunosRepositoryMemory();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Fulano",
                "123.456.789-00",
                "fulano@email.com");

        useCase.executa(dados);

        Aluno alunoEncontado = repositorio.buscarPorCpf(new CPF("123.456.789-00"));

        assertEquals("Fulano", alunoEncontado.getNome());
        assertEquals("123.456.789-00", alunoEncontado.getCpf().getNumero());
        assertEquals("fulano@email.com", alunoEncontado.getEmail().getEndereco());

    }


}
