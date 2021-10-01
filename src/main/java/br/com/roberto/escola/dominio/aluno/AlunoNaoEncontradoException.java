package br.com.roberto.escola.dominio.aluno;

public class AlunoNaoEncontradoException extends RuntimeException {

    public AlunoNaoEncontradoException(CPF cpf) {
        super("Aluno nao encontrado com CPF: "+cpf.getNumero());
    }
}
