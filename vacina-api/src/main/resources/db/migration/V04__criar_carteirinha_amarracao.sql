-- -----------------------------------------------------
-- Table `vacinaBD`.`carteirinha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vacinaBD`.`carteirinha` (
  `numero_paciente` INT NOT NULL,
  `cofren_enfermeiro` INT NOT NULL,
  `numero_vacina` VARCHAR(50) NOT NULL,
  `data_aplicacao` DATE NOT NULL,
  PRIMARY KEY (`numero_paciente`, `cofren_enfermeiro`, `numero_vacina`),
  INDEX `fk_paciente_has_medico_paciente1_idx` (`numero_paciente` ASC) VISIBLE,
  INDEX `fk_carteirinha_medico1_idx` (`cofren_enfermeiro` ASC) VISIBLE,
  INDEX `fk_carteirinha_vacina1_idx` (`numero_vacina` ASC) VISIBLE,
  CONSTRAINT `fk_carteirinha_medico1`
    FOREIGN KEY (`cofren_enfermeiro`)
    REFERENCES `vacinaBD`.`enfermeiro` (`cofren_enfermeiro`),
  CONSTRAINT `fk_carteirinha_vacina1`
    FOREIGN KEY (`numero_vacina`)
    REFERENCES `vacinaBD`.`vacina` (`numero_vacina`),
  CONSTRAINT `fk_paciente_has_medico_paciente1`
    FOREIGN KEY (`numero_paciente`)
    REFERENCES `vacinaBD`.`paciente` (`numero_paciente`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

USE `vacinaBD` ;