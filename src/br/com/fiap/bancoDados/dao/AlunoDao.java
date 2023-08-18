package br.com.fiap.bancoDados.dao;

import br.com.fiap.bancoDados.entity.Aluno;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDao {
    private Connection conexao;
    public void inserir(Aluno aluno) throws SQLException {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandoSql =  null;
        String sql = "insert into endereco (idAluno, nome, cpf, " +
                "idEnderecoAluno,) values(?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setInt(1, aluno.getIdAluno());
        comandoSql.setString(2, aluno.getNome());
        comandoSql.setInt(3, aluno.getCpf());
        comandoSql.setInt(4, aluno.getIdEnderecoAluno());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }
}
