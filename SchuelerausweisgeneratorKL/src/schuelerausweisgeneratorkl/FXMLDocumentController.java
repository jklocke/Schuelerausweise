/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import java.net.URL;
import java.util.ResourceBundle;
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
    private ComboBox<?> cbKlasse;
    @FXML
    private Button btnImp;
    @FXML
    private ListView<?> lvSchueler;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnPDFClick(ActionEvent event) {
        
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
