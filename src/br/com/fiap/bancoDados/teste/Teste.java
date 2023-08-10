package br.com.fiap.bancoDados.teste;

import br.com.fiap.bancoDados.entity.Endereco;

public class Teste {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Av. Paulista");
        endereco.setNumero("1106");
        endereco.setComplemento("");
        endereco.setBairro("Bela Vista");
        endereco.setUf("SP");
        endereco.setLocalidade("São Paulo");
        System.out.printf(endereco.toString());

    }
}
