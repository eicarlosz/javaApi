package com.vacina.api.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;

    @NotNull
    private int numero_paciente;

    @NotNull
    @Size(min = 3, max = 50)
    private String nome_paciente;

    @NotNull
    private Date nascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private Sexo sexo;

    @NotNull
    @Size(min = 3, max = 50)
    private String login_paciente;

    @NotNull
    @Size(min = 3, max = 50)
    private String senha_paciente;

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getNumero_paciente() {
        return numero_paciente;
    }

    public void setNumero_paciente(int numero_paciente) {
        this.numero_paciente = numero_paciente;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getLogin_paciente() {
        return login_paciente;
    }

    public void setLogin_paciente(String login_paciente) {
        this.login_paciente = login_paciente;
    }

    public String getSenha_paciente() {
        return senha_paciente;
    }

    public void setSenha_paciente(String senha_paciente) {
        this.senha_paciente = senha_paciente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_paciente == null) ? 0 : id_paciente.hashCode());
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
        Paciente other = (Paciente) obj;
        if (id_paciente == null) {
            if (other.id_paciente != null)
                return false;
        } else if (!id_paciente.equals(other.id_paciente))
            return false;
        return true;
    }

    public enum Sexo {
        F("F"),
        M("M");

        String sexo;

        Sexo(String sexo) {
            this.sexo = sexo;
        }
    }
}
