CREATE TABLE IF NOT EXISTS usuarios(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pessoa(
    id BIGSERIAL PRIMARY KEY,
    cpf_cnpj VARCHAR(14) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    nome_social VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    aniversario DATE,
    token VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cadastro(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255),
    nome_fantasia VARCHAR(255) NOT NULL,
    sobrenome_social VARCHAR(255) NOT NULL,
    empresa BOOLEAN NOT NULL,
    pessoa_id BIGINT,
    CONSTRAINT fk_pessoa
        FOREIGN KEY(pessoa_id)
            REFERENCES pessoa(id)
);

INSERT INTO usuarios (login, senha) VALUES('admin','$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');