CREATE DATABASE IF NOT EXISTS fatecservlets;
USE fatecservlets;

DROP TABLE IF EXISTS ALUNOS;

CREATE TABLE ALUNOS (
    ID BIGINT,
    RA VARCHAR(20),
    NOME VARCHAR(50),
    IDADE INT,
    SEXO VARCHAR(10)
);

ALTER TABLE ALUNOS 
ADD CONSTRAINT PKALUNO
PRIMARY KEY (ID);

INSERT INTO ALUNOS VALUES (
    1234567891011, "111999000999", "Teste", 17, "Masculino"
);