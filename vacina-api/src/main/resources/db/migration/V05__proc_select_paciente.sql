DELIMITER $$
USE `vacinaBD`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectDadosPaciente`(
IN numero_paciente INT, 
IN login_paciente VARCHAR(50),
IN senha_paciente VARCHAR(50))
BEGIN
	SELECT 
    c.numero_paciente,
    p.nome_paciente,
	TIMESTAMPDIFF(YEAR, p.nascimento, CURDATE()) as idade,
	DATE_FORMAT(c.data_aplicacao,'%d/%m/%Y') as dataAplicacao,
	v.nome_vacina,
    v.lote_vacina,
	v.descricao_vacina,
	DATE_FORMAT(v.data_vencimento,'%d/%m/%Y') as dataVencimento,
    DATE_FORMAT(v.data_producao,'%d/%m/%Y') as dataProducao,
    e.cofren_enfermeiro, e.cofren_enfermeiro
	FROM carteirinha c
	INNER JOIN vacina v ON v.numero_vacina = c.numero_vacina
	INNER JOIN paciente p ON p.numero_paciente = c.numero_paciente
	INNER JOIN enfermeiro e ON e.cofren_enfermeiro = c.cofren_enfermeiro
    WHERE c.numero_paciente = numero_paciente and p.login_paciente = login_paciente
    and p.senha_paciente = MD5(senha_paciente);
END$$

DELIMITER ;
