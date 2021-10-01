package br.com.roberto.escola.infra.aluno;

import br.com.roberto.escola.dominio.aluno.Aluno;
import br.com.roberto.escola.dominio.aluno.AlunoNaoEncontradoException;
import br.com.roberto.escola.dominio.aluno.AlunosRepository;
import br.com.roberto.escola.dominio.aluno.CPF;

import java.util.ArrayList;
import java.util.List;

public class AlunosRepositoryMemory implements AlunosRepository {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().getNumero().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        return this.matriculados;
    }
}
