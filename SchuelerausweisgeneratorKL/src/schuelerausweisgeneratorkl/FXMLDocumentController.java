/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Pair;

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
    private ComboBox<String> cbKlasse;
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
                System.exit(-1);
            } catch (SQLException ex) {
               loginDlg.setContentText("Login fehlgeschlagen");
            }catch (Exception ex) {
               ex.printStackTrace();
            }
        });
        //result.orElseThrow(exceptionSupplier -> );
//        loginDlg.onCloseRequestProperty().addListener(new ChangeListener() -> {
//            System.out.println("Handled by anonymous class listener");
//        });
            ObservableList<String> options = 
            FXCollections.observableArrayList(
                "Option 1",
                "Option 2",
                "Option 3"
            );

            cbKlasse = new ComboBox<>();      
            cbKlasse.setItems(options);
    //            cbKlasse.getItems().clear();
    //            cbKlasse.getItems().addAll("FS161");
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
    
}
