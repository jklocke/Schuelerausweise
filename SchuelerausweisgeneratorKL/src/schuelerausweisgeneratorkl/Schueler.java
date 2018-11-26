/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.sql.Blob;

/**
 *
 * @author jonas.klocke
 */
public class Schueler {
    private String name;
    private String vname;
    private String gebDatum;
    private String strasse;
    private String plz;
    private String ort;
    private Blob bild;
    private String abschlussdatum;

    public Schueler(String name, String vname, String gebDatum, String strasse, String plz, String ort, Blob bild, String abschlussdatum) {
        this.name = name;
        this.vname = vname;
        this.gebDatum = gebDatum;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.bild = bild;
        this.abschlussdatum = abschlussdatum;
    }

    @Override
    public String toString() {
        return "Schueler{" + "name=" + name + ", vname=" + vname + ", gebDatum=" + gebDatum + ", strasse=" + strasse + ", plz=" + plz + ", ort=" + ort + ", bild=" + bild + ", abschlussdatum=" + abschlussdatum + '}';
    }

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(String gebDatum) {
        this.gebDatum = gebDatum;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Blob getBild() {
        return bild;
    }

    public void setBild(Blob bild) {
        this.bild = bild;
    }

    public String getAbschlussdatum() {
        return abschlussdatum;
    }

    public void setAbschlussdatum(String abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }
    
    
}
