package br.com.roberto.escola.aplicacao.indicacao;

import br.com.roberto.escola.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarPara(Aluno indicado);
}
