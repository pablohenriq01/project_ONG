
CREATE TABLE tb_login (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE

);

CREATE TABLE tb_product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    expiration_date DATE,
    fk_userID BIGINT,
    FOREIGN KEY(fk_userID) REFERENCES tb_login(id)
);