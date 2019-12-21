package sample.ui.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import sample.ui.memberui.MemberMainController;

import java.awt.*;
import java.io.IOException;

public class LoginController {
    @FXML
    private TextField logintext;
    @FXML
    private PasswordField passwordtext;

    public void goToRegisterPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../register/Register.fxml"));
        Scene scene = new Scene(root, 420, 460);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
        appStage.setResizable(false);
    }
    public void tryLogin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../addbook/AddBook.fxml"));
        Scene scene = new Scene(root, 420, 460);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
        appStage.setResizable(false);
    }
}
