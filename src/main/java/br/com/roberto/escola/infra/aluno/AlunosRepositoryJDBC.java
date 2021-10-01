package br.com.roberto.escola.infra.aluno;

import br.com.roberto.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunosRepositoryJDBC implements AlunosRepository {

    private final Connection connection;

    public AlunosRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO TB_ALUNO VALUES (? , ?, ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, aluno.getCpf().getNumero());
            pstmt.setString(2, aluno.getNome());
            pstmt.setString(3, aluno.getCpf().getNumero());
            pstmt.execute();

            sql = "INSERT INTO TB_TELEFONE VALUES (?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (Telefone telefone : aluno.getTelefones()) {
                pstmt.setString(1, telefone.getDdd());
                pstmt.setString(2, telefone.getNumero());
                pstmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCpf(CPF cpf) {
        String sql = "SELECT id, nome, email FROM TB_ALUNO WHERE cpf = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cpf.getNumero());

            ResultSet rs = pstmt.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontradoException(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno alunoEncontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TB_TELFONE WHERE aluno_id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                alunoEncontrado.adicionarTelefone(ddd, numero);
            }
            return alunoEncontrado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        String sql = "SELECT id, cpf, nome, email FROM TB_ALUNO ";
        PreparedStatement pstmt = null;
        PreparedStatement pstmtFone = null;

        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<Aluno> alunos = new ArrayList<>();

            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long id = rs.getLong("id");

                sql = "SELECT ddd, numero FROM TB_TELFONE WHERE aluno_id = ?";
                pstmtFone = connection.prepareStatement(sql);
                pstmtFone.setLong(1, id);
                ResultSet rsFone = pstmtFone.executeQuery();

                while (rsFone.next()) {
                    String numero = rsFone.getString("numero");
                    String ddd = rsFone.getString("ddd");
                    aluno.adicionarTelefone(ddd, numero);
                }

                alunos.add(aluno);
            }
            return alunos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
