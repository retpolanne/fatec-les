DROP DATABASE IF EXISTS BANCOFATEC;
CREATE DATABASE BANCOFATEC;
USE BANCOFATEC;

DROP TABLE IF EXISTS Conta;
DROP TABLE IF EXISTS Lancamento;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS UsuarioConta;

CREATE TABLE Conta (
    id BIGINT,
    tipo VARCHAR(10),
    numero VARCHAR(5),
    saldo FLOAT,
    limite FLOAT,
    taxaServico FLOAT,
    taxaJuros FLOAT,
    taxaRendimento FLOAT,
    dataAbertura DATE,
    diaRendimento FLOAT,
    nomeGerente VARCHAR(30)
);
CREATE TABLE Lancamento (
    id BIGINT,
    idConta BIGINT,
    tipo VARCHAR(10),
    descricao VARCHAR(255),
    saldoAnterior FLOAT,
    saldoPosterior FLOAT,
    valor FLOAT,
    dataLancamento DATE
);
CREATE TABLE Usuario (
    id BIGINT,
    usuario VARCHAR(10),
    nome VARCHAR(30),
    email VARCHAR(50),
    telefone VARCHAR(20),
    senha VARCHAR(32),
    perfil VARCHAR(50)
);
CREATE TABLE UsuarioConta (
    id BIGINT,
    idUsuario BIGINT,
    idConta BIGINT
);

ALTER TABLE Conta
ADD CONSTRAINT PkConta
PRIMARY KEY (id);

ALTER TABLE Lancamento
ADD CONSTRAINT PkLancamento
PRIMARY KEY (id);

ALTER TABLE Usuario
ADD CONSTRAINT PkUsuario
PRIMARY KEY (id);

ALTER TABLE UsuarioConta
ADD CONSTRAINT PkUsuarioConta
PRIMARY KEY (id);

ALTER TABLE UsuarioConta 
ADD CONSTRAINT FkUsuario
FOREIGN KEY (idUsuario) REFERENCES Usuario(id);

ALTER TABLE UsuarioConta 
ADD CONSTRAINT FkUsuarioConta
FOREIGN KEY (idConta) REFERENCES Conta(id);

ALTER TABLE Lancamento 
ADD CONSTRAINT FkLancamentoConta
FOREIGN KEY (idConta) REFERENCES Conta(id);