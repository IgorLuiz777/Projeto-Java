package br.com.fiap.bancoDados.down;

import br.com.fiap.bancoDados.down.GerenciadorBancoDados;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDown {
    private Connection conexao;
    public void inserir(Endereco endereco) throws SQLException {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandoSql =  null;
        String sql = "insert into endereco (idEndereco, cep, rua, complemento, bairro, " +
                "cidade, uf, numero) values(?,?,?,?,?,?,?,?)";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setInt(1, endereco.getId());
        comandoSql.setString(2, endereco.getCep());
        comandoSql.setString(3, endereco.getLogradouro());
        comandoSql.setString(4, endereco.getComplemento());
        comandoSql.setString(5, endereco.getBairro());
        comandoSql.setString(6, endereco.getLocalidade());
        comandoSql.setString(7, endereco.getUf());
        comandoSql.setString(8, endereco.getNumero());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    public void alterar(Endereco endereco) throws SQLException {
        PreparedStatement comandoSql =  null;
        String sql = "update endereco set cep = ?, rua = ?, complemento = ?, bairro = ?, " +
                "cidade = ?, uf = ?, numero = ? where idEndereco ";
        comandoSql = conexao.prepareStatement(sql);

        comandoSql.setString(1, endereco.getCep());
        comandoSql.setString(2, endereco.getLogradouro());
        comandoSql.setString(3, endereco.getComplemento());
        comandoSql.setString(4, endereco.getUf());
        comandoSql.setString(5, endereco.getBairro());
        comandoSql.setString(6, endereco.getLocalidade());
        comandoSql.setString(7, endereco.getNumero());
        comandoSql.setInt(8, endereco.getId());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }
}
