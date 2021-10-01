package br.com.roberto.escola;

import br.com.roberto.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.roberto.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.roberto.escola.infra.aluno.AlunosRepositoryMemory;

//Poderia Isolar todos os trechos de códigos aqui
public class MatricularAlunoViaLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@gmail.com";

        MatricularAluno matricularAluno = new MatricularAluno(new AlunosRepositoryMemory());
        matricularAluno.executa(new MatricularAlunoDto(nome, cpf, email));
    }
}
