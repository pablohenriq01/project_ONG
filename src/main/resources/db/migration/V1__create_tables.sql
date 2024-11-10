
CREATE TABLE tb_login (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL
);

CREATE TABLE tb_product (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    expiration_date DATE,
    fk_loginID BIGINT,
    FOREIGN KEY(fk_loginID) REFERENCES tb_login(id)
);