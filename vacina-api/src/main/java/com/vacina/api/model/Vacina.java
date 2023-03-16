package com.vacina.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "vacina")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vacina;

    @NotNull
    @Size(min = 3, max = 100)
    private String lote_vacina;

    @NotNull
    @Size(min = 3, max = 45)
    private String nome_vacina;

    @NotNull
    @Size(min = 3, max = 45)
    private String descricao_vacina;

    @NotNull
    private String faixa_etaria;

    public Long getId_vacina() {
        return id_vacina;
    }

    public void setId_vacina(Long id_vacina) {
        this.id_vacina = id_vacina;
    }

    public String getLote_vacina() {
        return lote_vacina;
    }

    public void setLote_vacina(String lote_vacina) {
        this.lote_vacina = lote_vacina;
    }

    public String getNome_vacina() {
        return nome_vacina;
    }

    public void setNome_vacina(String nome_vacina) {
        this.nome_vacina = nome_vacina;
    }

    public String getDescricao_vacina() {
        return descricao_vacina;
    }

    public void setDescricao_vacina(String descricao_vacina) {
        this.descricao_vacina = descricao_vacina;
    }

    public String getFaixa_etaria() {
        return faixa_etaria;
    }

    public void setFaixa_etaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
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
