package com.vacina.api.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vacina;

    private String nome_vacina;

    private String descricao;

    private String lote;

    private Date data_vencimento;

    private Date data_producao;

    public Long getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(Long id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(Date data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public Date getData_producao() {
        return data_producao;
    }

    public void setData_producao(Date data_producao) {
        this.data_producao = data_producao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_vacina == null) ? 0 : id_vacina.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vacina other = (Vacina) obj;
        if (id_vacina == null) {
            if (other.id_vacina != null)
                return false;
        } else if (!id_vacina.equals(other.id_vacina))
            return false;
        return true;
    }

}
