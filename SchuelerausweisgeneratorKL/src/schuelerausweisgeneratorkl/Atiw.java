/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

//import java.sql.Blob;

/**
 *
 * @author jonas.klocke, jonas.linde
 */
public class Atiw {
    private String nameKurz;
    private String nameLang;
    private String strasse;
    private String plz;
    private String ort;
    //private Blob bild;

    public Atiw(String nameKurz, String nameLang, String strasse, String plz, String ort) {
        this.nameKurz = nameKurz;
        this.nameLang = nameLang;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
       // this.bild = bild;
    }
    
    public Atiw(){
        this.nameKurz = "ATIW";
        this.nameLang = "Ausbildungszentrum für Technik, Informationsverarbeitung und Wirtschaft gemeinnützige GmbH Staatlich genehmigtes Berufskolleg";
        this.strasse = "Riemekestraße 160";
        this.plz = "33106";
        this.ort = "Paderborn";
       // this.bild = 
    }

    @Override
    public String toString() {
        return "Atiw{" + "nameKurz=" + nameKurz + ", nameLang=" + nameLang + ", strasse=" + strasse + ", plz=" + plz + ", ort=" + ort +  '}';
    }
    

    public String getNameKurz() {
        return nameKurz;
    }

    public void setNameKurz(String nameKurz) {
        this.nameKurz = nameKurz;
    }

    public String getNameLang() {
        return nameLang;
    }

    public void setNameLang(String nameLang) {
        this.nameLang = nameLang;
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

//    public Blob getBild() {
//        return bild;
//    }
//
//    public void setBild(Blob bild) {
//        this.bild = bild;
//    }
    
}
