/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Pair;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML
    private Label lblPlz;
    @FXML
    private TextField txtPlz;
    
    //private ObservableList<String> klassennamen = FXCollections.observableArrayList();
    
    private Verwaltung verwaltung;
    int permission;
    DB_Verbindung db;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoginDlg loginDlg = new LoginDlg();
        Optional<Pair<String, String>> result = loginDlg.showAndWait();
        
        result.ifPresent(usernamePassword -> {
            try {
                verwaltung = new Verwaltung(usernamePassword.getKey(),usernamePassword.getValue());
                verwaltung.holeKlassennamenAusDB();
                ArrayList<String> klassennamen = verwaltung.getKlassennamen();
                for(String klasse: klassennamen)
                {
                    cbKlasse.getItems().add(klasse);
                }
                //System.exit(-1);
            } catch (SQLException ex) {
               loginDlg.setContentText("Login fehlgeschlagen");
            }catch (Exception ex) {
               ex.printStackTrace();
            }
        });
    }
    /**
     *
     */
    public FXMLDocumentController() {
        this.lvSchueler = new ListView<>();
        ObservableList<String> items =FXCollections.observableArrayList();
        lvSchueler.setItems(items);
    }
    
    @FXML
    private void btnPDFClick(ActionEvent event) {
        try{
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("MyGui.fxml"));
//        Parent root = (Parent)loader.load();
//        FXMLDocumentController myConroller = loader.getController();
        Stage stage = (Stage) btnPDF.getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(stage);
        verwaltung.erstelleSchuelerausweis();
        verwaltung.getPdfGenerator().erzeugePDF(verwaltung.getSchuelerausweise(), file.getPath());   
        }catch (NullPointerException e){
            
        }catch (Exception e){
            e.printStackTrace();
        }
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
        txtPlz.setDisable(false);
    }

    @FXML
    private void schuelerZuKlasse(ActionEvent event) {
        
        //lvSchueler.getItems().add(verwaltung.getSchueler().get(0));
        String klasse = cbKlasse.getSelectionModel().getSelectedItem();
        verwaltung.holeSchuelerAusDB(klasse);
        
        for(Schueler schueler: verwaltung.getSchueler()){
            lvSchueler.getItems().add(schueler.getVname() + "/" + schueler.getName());
        }
    }

    @FXML
    private void schuelerAnzeigen(MouseEvent event) {
        String schuelername = lvSchueler.getSelectionModel().getSelectedItem();
        String[] split = schuelername.split("/");
        for(Schueler schueler: verwaltung.getSchueler()){
            if(schueler.getVname().equals(split[0]) && schueler.getName().equals(split[1])){
                txtVorname.setText(schueler.getVname());
                txtNachname.setText(schueler.getName());
                txtStr.setText(schueler.getStrasse());
                txtOrt.setText(schueler.getOrt());
                txtPlz.setText(schueler.getPlz());
                txtGeb.setText(schueler.getGebDatum()); 
            }
        }           
    }

}
