/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

/**
 * @titel Diese Klasse wird zur Erstellung eines Schülerausweises, eines Schülers verwendet.
 * @author jonas.klocke
 */
public class Schuelerausweis {
    private Schueler schueler;
    private Atiw datenAtiw;
    private String schuelerDaten;

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

    public Schuelerausweis(Schueler schueler, String[] htmlSplitParts) {
        this.schueler = schueler;

        this.erstelleSchuelerausweis(htmlSplitParts);
    }

    @Override
    public String toString() {
        return "Schuelerausweis{" + "schueler=" + schueler + ", datenAtiw=" + datenAtiw + '}';
    }
    
    private void erstelleSchuelerausweis(String[] htmlSplitParts){
        schuelerDaten = htmlSplitParts[0] + schueler.getVname() + htmlSplitParts[1] + schueler.getName() + htmlSplitParts[2] + schueler.getGebDatum()
                + htmlSplitParts[3] + schueler.getPlz() + " " + schueler.getOrt() + htmlSplitParts[4] + schueler.getStrasse() + htmlSplitParts[5];
    }
}
