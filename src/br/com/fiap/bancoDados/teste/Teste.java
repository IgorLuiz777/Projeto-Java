package br.com.fiap.bancoDados.teste;

import br.com.fiap.bancoDados.dao.EnderecoDao;
import br.com.fiap.bancoDados.entity.Endereco;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public static Endereco preencerDados(Endereco endereco) {
        Scanner input = new Scanner(System.in);
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
        return endereco;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        Endereco endereco = new Endereco();
        EnderecoDao enderecoDao = new EnderecoDao();
        List<Endereco> enderecos = new ArrayList<>();

        Teste teste = new Teste();

        teste.menu();
        opcao = input.nextInt();
        switch (opcao) {
            case 1:
                teste.preencerDados(endereco);
                try {
                    enderecoDao.inserir(endereco);
                    System.out.println("Endereço cadastrado!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    teste.preencerDados(endereco);
                    enderecoDao.alterar(endereco);
                    System.out.println("Endereço atualizado!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 3:
                System.out.println("Digite o id do endereço que será excluído: ");
                int id = input.nextInt();
                enderecoDao.buscarPorId(id);
                System.out.println();
                break;

            case 4:
                System.out.println("Digite o id do endereço que será exibido: ");
                id = input.nextInt();
                endereco = enderecoDao.buscarPorId(id);
                System.out.println(endereco.toString());
                break;

            case 5:
                String dados = "";
                System.out.println("Digite o CEP: ");
                String cep = input.next();
                enderecos = enderecoDao.buscarPorCep(cep);
                for (Endereco end : enderecos) {
                    //end.toString();
                    dados +=  "\n---------------------------------";
                    dados +=  "\n     Rua: " + end.getLocalidade();
                    dados +=  "\n     Número: " + end.getNumero();
                    dados +=  "\n     Complemento: " + end.getComplemento();
                    dados +=  "\n     Bairro: " + end.getBairro();
                    dados +=  "\n     Cidade: " + end.getLocalidade();
                    dados +=  "\n     UF: " + end.getUf();
                    dados +=  "\n---------------------------------";
                }
                System.out.println(dados);
                break;

            case 6:
                dados = "";
                enderecos = enderecoDao.buscarEnderecos();
                for (Endereco end: enderecos) {
                    dados += "=====================================\n";
                    dados += "Id: " + end.getId() + "\n";
                    dados += "Endereço: " + end.getLogradouro() + "\n";
                    dados += "Número: " + end.getNumero() + "\n";
                    dados += "Complemento: " + end.getComplemento() + "\n";
                    dados += "CEP: " + end.getCep() + "\n";
                    dados += "Bairro: " + end.getBairro() + "\n";
                    dados += "Cidade: " + end.getLogradouro() + "\n";
                    dados += "UF: " + end.getUf() + "\n";
                    dados += "=====================================\n";
                }   System.out.println(dados);
                break;
            default:
                System.out.println("Opção incorreta!! Tente Novamente!!");
        }


    }
}
