package br.com.fiap.bancoDados.dao;

import br.com.fiap.bancoDados.entity.Aluno;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDao {
    private Connection conexao;


    public void inserir(Aluno aluno)  {

        try {
            conexao =  GerenciadorBancoDados.obterConexao();
            PreparedStatement comandoSql = null;
            String sql = "insert into aluno (idaluno, nome, cpf, idenderecoAluno) " +
                    "values (?, ?, ?, ?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, aluno.getIdAluno());
            comandoSql.setString(2, aluno.getNome());
            comandoSql.setString(3, aluno.getCpf());
            comandoSql.setInt(4, aluno.getEndereco().getId());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Aluno buscarPorId(int id) throws SQLException {
        Aluno aluno = new Aluno();
        EnderecoDao eDao = new EnderecoDao();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBancoDados.obterConexao();
        try{
            String sql = "Select * from aluno where idaluno = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1,id);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                aluno.setIdAluno(rs.getInt(1));
                aluno.setNome(rs.getString(2));
                aluno.setCpf(rs.getString(3));
                int idEndereco = rs.getInt(4);
                System.out.println(idEndereco);
                aluno.setEndereco(eDao.buscarPorId(idEndereco));
            }
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return aluno;
    }
}
