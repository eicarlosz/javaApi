CREATE SCHEMA IF NOT EXISTS `vacinaBD` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `vacinaBD` ;

-- -----------------------------------------------------
-- Table `vacinaBD`.`enfermeiro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vacinaBD`.`enfermeiro` (
  `id_enfermeiro` INT NOT NULL AUTO_INCREMENT,
  `cofren_enfermeiro` INT NOT NULL,
  `nome_enfermeiro` VARCHAR(50) NOT NULL,
  `senha_enfermeiro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_enfermeiro`, `cofren_enfermeiro`),
  UNIQUE INDEX `crm_UNIQUE` (`cofren_enfermeiro` ASC) VISIBLE,
  UNIQUE INDEX `id_medico_UNIQUE` (`id_enfermeiro` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
