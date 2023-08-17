package br.com.fiap.bancoDados.dao;

import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class
EnderecoDao {
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
    public void excluir(int id) {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandosql = null;
        String sql = "delete from endereco where idEndereco = ?";
        try {
            comandosql = conexao.prepareStatement(sql);
            comandosql.setInt(1, id);
            comandosql.executeUpdate();
            conexao.close();
            comandosql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Endereco buscarPorId(int id) {
        Endereco endereco = new Endereco();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBancoDados.obterConexao();
        try {
            String sql = "Select * from endereco where idendereco = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            ResultSet resultSet = comandoSql.executeQuery();
            if (resultSet.next()) {
                endereco.setId(resultSet.getInt(1));
                endereco.setCep(resultSet.getString(2));
                endereco.setLogradouro(resultSet.getString(3));
                endereco.setComplemento(resultSet.getString(4));
                endereco.setBairro((resultSet.getString(5)));
                endereco.setLocalidade(resultSet.getString(6));
                endereco.setUf(resultSet.getString(7));
                endereco.setNumero(resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

}
