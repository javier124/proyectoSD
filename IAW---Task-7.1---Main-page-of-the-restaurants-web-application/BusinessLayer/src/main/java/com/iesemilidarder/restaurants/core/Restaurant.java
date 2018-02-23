package com.iesemilidarder.restaurants.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;

// creacion de get , set y clases

@Entity()
public class Restaurant {
    @Column (name = "RES_CODI")
    private String Code;
    @Column (name = "RES_NOM")
    private String nom;
    @Column(name = "RES_ADRECA")
    private String adresa;
    @Column(name = "RES_WEB")
    private String website;
    @Column(name = "RES_TELEFON")
    private String telefono;
    @Column(name = "TRS_DESCRIPCIO")
    private String tipus;
    @Column(name = "RES_URL_IMG")
    private String Imagen;
    @Column(name = "RES_MITJANA")
    private String Mitjana;


    private ArrayList<Opinions> opinions;

    public ArrayList<Opinions> getOpinions() {
        return opinions;
    }

    public String getCode() {
        return Code;
    }

    public String getMitjana() {
        return Mitjana;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getWebsite() {
        return website;
    }

    public String getImagen() {
        return Imagen;
    }

    public String getTelefono() {

        return telefono;
    }

    public String getTipus() {
        return tipus;
    }

    public void setOpinions(ArrayList<Opinions> opinions) {
        this.opinions = opinions;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public void setMitjana(String mitjana) {
        Mitjana = mitjana;
    }
}