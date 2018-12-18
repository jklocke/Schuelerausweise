/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;

/**
 * Impressum
 * @author: jonas.klocke, jonas.linde
 */
public class Impressum extends Dialog {

    public Impressum() {
        setTitle("Impressum");
        initGUI();
    }

    private void initGUI() {        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Impressum");
        alert.setHeaderText("Impressum");
        alert.setContentText("Angaben gemäß § 5 TMG \nMax Muster \nMusterweg \n12345 Musterstadt \n\nVertreten durch: \nJonas Linde \nJonas Klocke \n\nKontakt: \nTelefon: 01234-789456 \nFax: 1234-56789 \nE-Mail: max@muster.de \nUmsatzsteuer-ID: \nUmsatzsteuer-Identifikationsnummer gemäß §27a Umsatzsteuergesetz: Musterustid. \n\nWirtschafts-ID: \nMusterwirtschaftsid \n\nAufsichtsbehörde: \nMusteraufsicht Musterstadt \n\nWebsite Impressum erstellt durch impressum-generator.de von der Kanzlei Hasselbach");
        alert.showAndWait();
    }
}

