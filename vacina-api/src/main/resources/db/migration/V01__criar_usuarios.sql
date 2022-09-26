CREATE TABLE IF NOT EXISTS `vacinaBD`.`paciente` (
  `id_paciente` INT NOT NULL AUTO_INCREMENT,
  `numero_paciente` INT NOT NULL,
  `nome_paciente` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `sexo` ENUM('M', 'F') NOT NULL,
  `login_paciente` VARCHAR(50) CHARACTER SET 'utf8mb3' NOT NULL,
  `senha_paciente` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_paciente`, `numero_paciente`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`numero_paciente` ASC) VISIBLE,
  UNIQUE INDEX `nome_usuario_UNIQUE` (`login_paciente` ASC) VISIBLE,
  UNIQUE INDEX `id_paciente_UNIQUE` (`id_paciente` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;