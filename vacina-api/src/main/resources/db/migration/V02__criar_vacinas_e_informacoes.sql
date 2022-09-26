CREATE TABLE IF NOT EXISTS `vacinaBD`.`vacina` (
  `id_vacina` INT NOT NULL AUTO_INCREMENT,
  `numero_vacina` VARCHAR(50) NOT NULL,
  `lote_vacina` VARCHAR(50) NOT NULL,
  `nome_vacina` VARCHAR(45) NOT NULL,
  `descricao_vacina` VARCHAR(400) NOT NULL,
  `data_vencimento` DATE NOT NULL,
  `data_producao` DATE NOT NULL,
  PRIMARY KEY (`id_vacina`, `numero_vacina`, `lote_vacina`),
  UNIQUE INDEX `numero_vacina_UNIQUE` (`numero_vacina` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
