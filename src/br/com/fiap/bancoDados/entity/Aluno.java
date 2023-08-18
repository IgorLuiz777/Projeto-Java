package br.com.fiap.bancoDados.entity;

public class Aluno {
    private int idAluno;
    private String nome;
    private int cpf;
    private int idEnderecoAluno;

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getIdEnderecoAluno() {
        return idEnderecoAluno;
    }

    public void setIdEnderecoAluno(int idEnderecoAluno) {
        this.idEnderecoAluno = idEnderecoAluno;
    }
}
