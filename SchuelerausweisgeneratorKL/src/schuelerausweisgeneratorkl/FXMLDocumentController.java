/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author jonas.klocke
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnPDF;
    @FXML
    private Label lblKopf;
    @FXML
    private ImageView imageAtiw;
    @FXML
    private ComboBox<String> cbKlasse = new ComboBox<>(FXCollections.observableArrayList(""));
    @FXML
    private Button btnImp;
    @FXML
    private ListView<String> lvSchueler;
    @FXML
    private Label lblVorname;
    @FXML
    private Label lblNachname;
    @FXML
    private Label lblGeb;
    @FXML
    private Label lblOrt;
    @FXML
    private Label lblStr;
    @FXML
    private TextField txtVorname;
    @FXML
    private TextField txtNachname;
    @FXML
    private TextField txtGeb;
    @FXML
    private TextField txtOrt;
    @FXML
    private TextField txtStr;
    @FXML
    private Button btnBearbeiten;
    
    //private ObservableList<String> klassennamen = FXCollections.observableArrayList();
    
    private Verwaltung verwaltung;

    public FXMLDocumentController() {
        this.lvSchueler = new ListView<>();
        ObservableList<String> items =FXCollections.observableArrayList();
        lvSchueler.setItems(items);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            verwaltung = new Verwaltung();
            verwaltung.holeKlassennamenAusDB();
            ArrayList<String> klassennamen = verwaltung.getKlassennamen();
            for(String klasse: klassennamen)
            {
                cbKlasse.getItems().add(klasse);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnPDFClick(ActionEvent event) {
        verwaltung.getPdfGenerator().erzeugePDF(verwaltung.getSchuelerausweise());      
    }

    @FXML
    private void btnImpressumClick(ActionEvent event) {
    }

    @FXML
    private void btnBearbeitenClick(ActionEvent event) {
        txtVorname.setDisable(false);
        txtNachname.setDisable(false);
        txtStr.setDisable(false);
        txtOrt.setDisable(false);
        txtGeb.setDisable(false);      
    }

    @FXML
    private void schuelerZuKlasse(ActionEvent event) {
        //Schueler schueler = lvSchueler.getSelectionModel().getSelectedItem();
        //lvSchueler.getItems().add(verwaltung.getSchueler().get(0));
        //String klasse = cbKlasse.getSelectionModel().getSelectedItem();
        
        lvSchueler.getItems().add("Jonas Klocke");
    }

}
