package br.com.roberto.escola.dominio.aluno;

//Exemplo Associado ao Design Pattern Builder
public class FabricaDeAluno {

    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }

        public static void main(String[] args) {
            //Exemplo de Utilizacao
            FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
            Aluno aluno2 = fabricaDeAluno
                        .comNomeCPFEmail("", "", "")
                        .comTelefone("", "")
                        .criar();
        }


}
