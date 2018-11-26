/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

/**
 *
 * @author jonas.klocke
 */
public class Schuelerausweis {
    private Schueler schueler;
    private Atiw datenAtiw;
    private String schuelerausweisXML;

    public Schueler getSchueler() {
        return schueler;
    }

    public void setSchueler(Schueler schueler) {
        this.schueler = schueler;
    }

    public Atiw getDatenAtiw() {
        return datenAtiw;
    }

    public void setDatenAtiw(Atiw datenAtiw) {
        this.datenAtiw = datenAtiw;
    }

    public String getSchuelerausweisXML() {
        return schuelerausweisXML;
    }

    public void setSchuelerausweisXML(String schuelerausweisXML) {
        this.schuelerausweisXML = schuelerausweisXML;
    }

    public Schuelerausweis(Schueler schueler, Atiw datenAtiw, String schuelerausweisXML) {
        this.schueler = schueler;
        this.datenAtiw = datenAtiw;
        this.schuelerausweisXML = schuelerausweisXML;
        this.erstelleSchuelerausweis();
    }

    @Override
    public String toString() {
        return "Schuelerausweis{" + "schueler=" + schueler + ", datenAtiw=" + datenAtiw + ", schuelerausweisXML=" + schuelerausweisXML + '}';
    }
    
    private void erstelleSchuelerausweis(){
        
    }
}
