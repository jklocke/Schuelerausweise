/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jonas.klocke
 */
public class Verwaltung {
    private ArrayList<String> klassennamen = new ArrayList<>();
    private ArrayList<Schuelerausweis> schuelerausweise = new ArrayList<>();
    private ArrayList<Schueler> schueler = new ArrayList<>();
    private String[] htmlSplitParts = null;
    private DB_Verbindung dbVerbindung;
    private PDF_Generator pdfGenerator;

    public String[] getHtmlSplitParts() {
        return htmlSplitParts;
    }

    public void setHtmlSplitParts(String[] htmlSplitParts) {
        this.htmlSplitParts = htmlSplitParts;
    }

    public DB_Verbindung getDbVerbindung() {
        return dbVerbindung;
    }

    public void setDbVerbindung(DB_Verbindung dbVerbindung) {
        this.dbVerbindung = dbVerbindung;
    }

    public PDF_Generator getPdfGenerator() {
        return pdfGenerator;
    }

    public void setPdfGenerator(PDF_Generator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    public ArrayList<String> getKlassennamen() {
        return klassennamen;
    }

    public void setKlassennamen(ArrayList<String> klassennamen) {
        this.klassennamen = klassennamen;
    }

    public ArrayList<Schuelerausweis> getSchuelerausweise() {
        return schuelerausweise;
    }

    public void setSchuelerausweise(ArrayList<Schuelerausweis> schuelerausweise) {
        this.schuelerausweise = schuelerausweise;
    }

    public ArrayList<Schueler> getSchueler() {
        return schueler;
    }

    public void setSchueler(ArrayList<Schueler> schueler) {
        this.schueler = schueler;
    }
    
    public void holeKlassennamenAusDB(){
        klassennamen = dbVerbindung.getKlassennamen();
    }
    
    public void holeSchuelerAusDB(String klasse){
        schueler = dbVerbindung.getSchueler(klasse);
    }


    public Verwaltung() throws FileNotFoundException {
        this.login("root","root");
        this.splitHTML();
        pdfGenerator = new PDF_Generator();
    }
    
    private void splitHTML() throws FileNotFoundException{
        String htmlFile = new Scanner(new File("schuelerausweis.html")).useDelimiter("\\Z").next();
        htmlSplitParts = htmlFile.split("§");
    }

    @Override
    public String toString() {
        return "Verwaltung{" + "klassennamen=" + klassennamen + ", schuelerausweise=" + schuelerausweise + ", schueler=" + schueler + '}';
    }
    
    public void login(String user, String passwort){
        dbVerbindung = new DB_Verbindung("jdbc:mysql://localhost/schild_nrw",user,passwort);
    }
    
    public void erstelleSchuelerausweis(){
        schuelerausweise.clear();
        for(Schueler schueler: schueler){
            schuelerausweise.add(new Schuelerausweis(schueler, htmlSplitParts));
        }
    }


    
}
