package br.com.roberto.escola.dominio.aluno;

public class Telefone {

    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        //TODO validar dd = 2 telefone = 8 ou 9

        if (ddd == null || numero == null) {
            throw new IllegalArgumentException("DDD e Número são obrigatórios");
        }

        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD Inválido ");
        }

        if (!numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Número Inválido ");
        }

        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public String getNumero() {
        return numero;
    }
}
