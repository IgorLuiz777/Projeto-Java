package br.com.fiap.bancoDados.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorBancoDados {
    public static Connection obterConexao(){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "rm99809","300804");

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }

}
