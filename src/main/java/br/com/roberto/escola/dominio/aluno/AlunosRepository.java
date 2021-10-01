package br.com.roberto.escola.dominio.aluno;

import java.util.List;

//Inversão de Dependência, ou seja, quem for implementar tem que utilizar a assinatura dessa interface
public interface AlunosRepository {

    void matricular(Aluno aluno);
    Aluno buscarPorCpf(CPF cpf);
    List<Aluno> listarTodosAlunos();

}
