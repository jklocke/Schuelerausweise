/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.util.ArrayList;

/**
 *
 * @author jonas.klocke
 */
public class Verwaltung {
    private ArrayList<String> klassennamen = new ArrayList<>();
    private ArrayList<Schuelerausweis> schuelerausweise = new ArrayList<>();
    private ArrayList<Schueler> schueler = new ArrayList<>();

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



    public Verwaltung() {
    }

    @Override
    public String toString() {
        return "Verwaltung{" + "klassennamen=" + klassennamen + ", schuelerausweise=" + schuelerausweise + ", schueler=" + schueler + '}';
    }
    
    public void login(String user, String passwort){
        
    }
    
    public void erstelleSchuelerausweis(){
        schuelerausweise.clear();
        for(Schueler schueler: schueler){
            schuelerausweise.add(new Schuelerausweis(schueler," "));
        }
    }


    
}
