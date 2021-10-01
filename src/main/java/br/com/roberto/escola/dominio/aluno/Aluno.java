package br.com.roberto.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    //    public static void main(String[] args) {
//        Aluno a = new Aluno(new CPF("123"),"Fulano de Tal",new Email("email"));
//    }
}
