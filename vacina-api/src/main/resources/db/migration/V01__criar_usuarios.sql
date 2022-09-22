CREATE TABLE IF NOT EXISTS usuario (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    nascimento DATE NOT NULL,
    sexo CHAR(1) NOT NULL,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
) ENGINE=InnoDB DEFAULT CHARSET = utf8;


INSERT INTO usuario (nome, nascimento, sexo) values ('CRIA!', '2002-10-27', 'M');
INSERT INTO usuario (nome, nascimento, sexo) values ('CACHORRO LOKO', '1999-01-12', 'M');

    -- tipo enum('Crianca', 'Adulto', 'Idoso'),