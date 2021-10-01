package br.com.roberto.escola.infra.indicacao;

import br.com.roberto.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.roberto.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarPara(Aluno indicado) {
        //Lógica de envio de email com Java Mail
    }
}
