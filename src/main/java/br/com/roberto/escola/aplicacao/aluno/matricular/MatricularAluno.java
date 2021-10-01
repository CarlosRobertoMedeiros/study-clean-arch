package br.com.roberto.escola.aplicacao.aluno.matricular;

import br.com.roberto.escola.dominio.aluno.Aluno;
import br.com.roberto.escola.dominio.aluno.AlunosRepository;

public class MatricularAluno {

    private final AlunosRepository repositorio;

    public MatricularAluno(AlunosRepository repositorio) {
        this.repositorio = repositorio;
    }

    //Command
    public void executa(MatricularAlunoDto dados){
        Aluno novoAluno = dados.criarAluno();
        repositorio.matricular(novoAluno);
    }
}
