package com.codelab.integrationtest;

import jakarta.persistence.*;



@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pais;
    private String capital;
    private String continente;

    public Pais() {
    }

    public Pais(String pais, String capital, String continente) {
        this.pais = pais;
        this.capital = capital;
        this.continente = continente;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getContinente() {
        return continente;
    }
    public void setContinente(String continente) {
        this.continente = continente;
    }
}