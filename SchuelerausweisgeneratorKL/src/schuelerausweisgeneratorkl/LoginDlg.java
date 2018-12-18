/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuelerausweisgeneratorkl;

/**
 *
 * @author jonas.klocke, jonas.linde
 */
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * a login dialog
 */
public class LoginDlg extends Dialog {

    public LoginDlg() {
        setTitle("Login");
        setHeaderText("Bitte melden Sie sich an!");

        initGUI();
    }

    private void initGUI() {
        // Create the username and password labels and fields:
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Benutzername");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Benutzername:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

        ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Initiales enable/disable für den Login-Button:
        Node loginButton = getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Enable/disable für den Login-Button abhängig von der Eingabe:
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        getDialogPane().setContent(grid);

        // Das Ergebnis der Eingabe abrufbar machen:
        setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        // Den Focus auf das Textfeld für den Namen stetzen:
        Platform.runLater(() -> username.requestFocus());

        }
    }
