CREATE TABLE IF NOT EXISTS users(
    id UUID PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS person(
    id UUID PRIMARY KEY,
    cpf_cnpj VARCHAR(14) NOT NULL,
    name VARCHAR(255) NOT NULL,
    name_social VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    birthday DATE,
    token VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS register(
    id UUID PRIMARY KEY,
    email VARCHAR(255),
    doing_business_as VARCHAR(255) NOT NULL,
    lastname_social VARCHAR(255) NOT NULL,
    company BOOLEAN NOT NULL,
    person_id UUID,
    CONSTRAINT fk_person
        FOREIGN KEY(person_id)
            REFERENCES person(id)
);

INSERT INTO users (id, login, password) VALUES(gen_random_uuid(),'admin','$2a$12$u/zNVJU7S3ZVQyS9seASMeiz8ys0QrYNn.fnbSwHQwFaKW1fpCmOC');