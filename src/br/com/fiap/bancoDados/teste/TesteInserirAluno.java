package br.com.fiap.bancoDados.teste;

import br.com.fiap.bancoDados.dao.AlunoDao;
import br.com.fiap.bancoDados.dao.EnderecoDao;
import br.com.fiap.bancoDados.entity.Aluno;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.SQLException;
import java.util.Scanner;

public class TesteInserirAluno {
    public static void main(String[] args) throws SQLException {
        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);

        Aluno aluno = new Aluno();
        System.out.println("Digite o id do aluno: ");
        aluno.setIdAluno(leitorNumerico.nextInt());
        System.out.println("Digite o nome do aluno: ");
        aluno.setNome(leitorTexto.nextLine());
        System.out.println("Digite o cpf do aluno: ");
        aluno.setCpf(leitorTexto.nextLine());

        System.out.println("Endereço");
        Endereco end = new Endereco();
        System.out.println("Digite o cep do endereço");
        end.setCep(leitorTexto.nextLine());
        System.out.println("Digite o nome da rua/avenida: ");
        end.setLogradouro(leitorTexto.nextLine());
        System.out.println("Número: ");
        end.setNumero(leitorTexto.nextLine());
        System.out.println("Digite o complemento [se houver]: ");
        end.setComplemento(leitorTexto.nextLine());
        System.out.println("Bairro: ");
        end.setBairro(leitorTexto.nextLine());
        System.out.println("Cidade: ");
        end.setLocalidade(leitorTexto.nextLine());
        System.out.println("Estado [UF]: ");
        end.setUf(leitorTexto.nextLine());
        System.out.println("Id");
        end.setId(leitorNumerico.nextInt());

        EnderecoDao endDao = new EnderecoDao();


        AlunoDao alunoDao = new AlunoDao();

        try {
            endDao.inserir(end);
            end = endDao.buscarPorId(end.getId());
            aluno.setEndereco(end);
            alunoDao.inserir(aluno);
            System.out.println("Aluno Cadastrado!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}