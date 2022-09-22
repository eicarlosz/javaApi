CREATE TABLE IF NOT EXISTS vacina (
  id_vacina INT NOT NULL AUTO_INCREMENT,
  nome_vacina VARCHAR(45) NOT NULL,
  descricao VARCHAR(45) NOT NULL,
  lote VARCHAR(100) NOT NULL,
  data_vencimento DATE NOT NULL,
  data_producao DATE NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id_vacina` ASC) VISIBLE,
  PRIMARY KEY (id_vacina)
) ENGINE=InnoDB DEFAULT CHARSET = utf8;

INSERT INTO vacina (nome_vacina, descricao, lote, data_vencimento, data_producao)
VALUES ('VACINAFERNANDEX', 'VACINA MAIS DA FAVELA QUE EXISTE','Fernan001', '2022-11-22',
'2001-02-08');