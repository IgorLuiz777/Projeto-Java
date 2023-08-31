package br.com.fiap.bancoDados.teste;

import br.com.fiap.bancoDados.entity.Aluno;
import br.com.fiap.bancoDados.entity.Endereco;

import java.util.Scanner;

public class TesteInserirAluno {
    public static Aluno preencerDados(Aluno aluno, Endereco endereco) {
        Scanner input = new Scanner(System.in);

        //Aluno

        System.out.println("Digite o seu nome: ");
        aluno.setNome(input.nextLine());

        System.out.println("Digite o seu CPF: ");
        aluno.setCpf(input.nextLine());

        System.out.println("Digite o ID: ");
        aluno.setIdAluno(input.nextInt());


        //Endereço

        aluno.setEndereco(endereco.getCep());

        aluno.setEndereco(endereco.setId(input.nextInt()));

        System.out.println("Digite o cep: ");
        endereco.setCep(input.nextLine());

        System.out.println("Digite a rua: ");
        endereco.setLogradouro(input.nextLine());

        System.out.println("Digite o número: ");
        endereco.setNumero(input.nextLine());

        System.out.println("Digite o complemento (se não houver apenas pule): ");
        endereco.setComplemento(input.nextLine());

        System.out.println("Digite o bairro: ");
        endereco.setBairro(input.nextLine());

        System.out.println("Digite a cidade: ");
        endereco.setLocalidade(input.nextLine());

        System.out.println("Digite a sigla do estado: ");
        endereco.setUf(input.nextLine());

        System.out.println("Digite o Id: ");
        endereco.setId(input.nextInt());

        return aluno;
    }
    public static void main(String[] args) {

    }
}
