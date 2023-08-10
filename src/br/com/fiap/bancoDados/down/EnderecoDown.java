package br.com.fiap.bancoDados.down;

import br.com.fiap.bancoDados.down.GerenciadorBancoDados;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDown {
    private Connection conexao;
    public void inserir(Endereco endereco) {
        conexao = GerenciadorBancoDados.obterConexao();
        PreparedStatement comandoSql =  null;
        String sql = "insert into endereco (idEndereco, cep, rua, complemento, bairro, " +
                "cidade, uf, numero) values(?,?,?,?,?,?,?,?)";
    }
}
