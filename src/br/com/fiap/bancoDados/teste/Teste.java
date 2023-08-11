package br.com.fiap.bancoDados.teste;

import br.com.fiap.bancoDados.down.EnderecoDown;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.SQLException;
import java.util.Scanner;

public class Teste {

    public void menu() {
        System.out.println(
                "  Bem-vindo ao nosso programa!!\n" +
                        "---------------------------------\n" +
                        "Selecione uma opção:\n" +
                        " 1 - Cadastrar um endereço\n" +
                        " 2 - Alterar um endereço\n" +
                        " 3 - Excluir um endereço\n" +
                        " 4 - Consultar endereço pelo ID\n" +
                        " 5 - Consultar endereço pelo CEP\n" +
                        " 6 - Exibir todos os endereços\n" +
                        "---------------------------------");
    }

    public void cadastrar(Endereco endereco, Scanner input) {
        System.out.println("Digite o cep: ");
        endereco.setCep(input.next());

        System.out.println("Digite a rua: ");
        endereco.setLogradouro(input.next());

        System.out.println("Digite o número: ");
        endereco.setNumero(input.next());

        System.out.println("Digite o complemento (se não houver apenas pule): ");
        endereco.setComplemento(input.next());

        System.out.println("Digite o bairro: ");
        endereco.setBairro(input.next());

        System.out.println("Digite a cidade: ");
        endereco.setLocalidade(input.next());

        System.out.println("Digite a sigla do estado: ");
        endereco.setUf(input.next());

        System.out.println("Digite o Id: ");
        endereco.setId(input.nextInt());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        Endereco endereco = new Endereco();
        EnderecoDown enderecoDown = new EnderecoDown();

        Teste teste = new Teste();

        teste.menu();
        opcao = input.nextInt();


    }
}
