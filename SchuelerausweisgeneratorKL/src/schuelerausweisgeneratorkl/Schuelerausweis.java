/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

/**
 * @titel Diese Klasse wird zur Erstellung eines Schülerausweises, eines Schülers verwendet.
 * @author jonas.klocke, jonas.linde
 */
public class Schuelerausweis {
    private Schueler schueler;
    private Atiw datenAtiw;
    private String schuelerDaten;

    public String getSchuelerDaten() {
        return schuelerDaten;
    }

    public void setSchuelerDaten(String schuelerDaten) {
        this.schuelerDaten = schuelerDaten;
    }

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
        String vorname = schueler.getVname();
        if(vorname.length() > 30){
            vorname = vorname.substring(0, 29);
        }
        String nachname = schueler.getName();
        if(schueler.getOrt().length() > 30){
            nachname = nachname.substring(0, 29);
        }
        String ort = schueler.getOrt();
        if(ort.length() > 24){
            ort = ort.substring(0, 23);
        }
        String str = schueler.getStrasse();
        if(str.length() > 30){
            str = str.substring(0, 29);
        }
        
        schuelerDaten = htmlSplitParts[0] + vorname + htmlSplitParts[1] + nachname + htmlSplitParts[2] + schueler.getGebDatum()
                + htmlSplitParts[3] + schueler.getPlz() + " " + ort + htmlSplitParts[4] + str + htmlSplitParts[5] + schueler.getAbschlussdatum() + htmlSplitParts[6];
    }
}
