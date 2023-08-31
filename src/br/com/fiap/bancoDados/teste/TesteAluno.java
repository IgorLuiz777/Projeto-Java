package br.com.fiap.bancoDados.teste;

import br.com.fiap.bancoDados.dao.AlunoDao;
import br.com.fiap.bancoDados.dao.EnderecoDao;
import br.com.fiap.bancoDados.entity.Aluno;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteAluno {
    public static void main(String[] args) throws SQLException {
        Scanner leitor = new Scanner(System.in);
        Aluno aluno = new Aluno();
        EnderecoDao endDado = new EnderecoDao();
        Endereco endereco = new Endereco();
        System.out.println("Por favor digite o id da residencia:");
        int id = leitor.nextInt();
        endereco = endDado.buscarPorId(id);
        aluno.setEndereco(endereco);
        System.out.println(aluno.getEndereco().toString());
        aluno.setIdAluno(2);
        aluno.setNome("Eliane2");
        aluno.setCpf("121545445");
        AlunoDao alunoDao = new AlunoDao();
        alunoDao.inserir(aluno);


    }
}
