CREATE TABLE IF NOT EXISTS usuarios(
    id UUID PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pessoa(
    id UUID PRIMARY KEY,
    cpf_cnpj VARCHAR(14) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    nome_social VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    aniversario DATE,
    token VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cadastro(
    id UUID PRIMARY KEY,
    email VARCHAR(255),
    nome_fantasia VARCHAR(255) NOT NULL,
    sobrenome_social VARCHAR(255) NOT NULL,
    empresa BOOLEAN NOT NULL,
    pessoa_id UUID,
    CONSTRAINT fk_pessoa
        FOREIGN KEY(pessoa_id)
            REFERENCES pessoa(id)
);

INSERT INTO usuarios (id, login, senha) VALUES(gen_random_uuid(),'admin','$2a$12$u/zNVJU7S3ZVQyS9seASMeiz8ys0QrYNn.fnbSwHQwFaKW1fpCmOC');