create table endereco(
    idEndereco int primary key,
    cep varchar2(8),
    rua varchar2(50),
    complemento varchar2(30),
    bairro varchar2(20),
    cidade varchar2(20),
    uf varchar2(2),
    numero varchar2(6)
);