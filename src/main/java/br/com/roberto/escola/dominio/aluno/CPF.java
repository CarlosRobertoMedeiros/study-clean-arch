package br.com.roberto.escola.dominio.aluno;

public class CPF {

    private String numero;

    public CPF(String numero) {
        if (numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Cpf Inválido !");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

}
