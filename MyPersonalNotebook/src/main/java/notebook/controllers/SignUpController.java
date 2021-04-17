package notebook.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notebook.database.User;
import notebook.database.UsersDAO;

import java.io.IOException;
import java.sql.SQLException;


public class SignUpController{
    @FXML
    public RadioButton male;

    public void menuFileItemExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public Button signUpandIn = new Button();

    @FXML
    private TextField eMailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField countryField;

    public void signUpAndIn(ActionEvent actionEvent) throws IOException, SQLException {
        if (eMailField.getText().isEmpty()){
            eMailField.setStyle("-fx-prompt-text-fill: red ;");
            eMailField.setPromptText("*E-mail field is required to fill");
        }

        if (passwordField.getText().isEmpty()){
            passwordField.setStyle("-fx-prompt-text-fill: red ;");
            passwordField.setPromptText("*Password field is required to fill");
        }
        if (userNameField.getText().isEmpty()){
            userNameField.setStyle("-fx-prompt-text-fill: red ;");
            userNameField.setPromptText("*Username field is required to fill");
        }
        else if (!eMailField.getText().contains("@")){
            eMailField.setStyle("-fx-prompt-text-fill: red ;");
            eMailField.setPromptText("*Invalid e-mail format (name@example.com)");
            eMailField.setText("");
        }
        else {
            UsersDAO dao = new UsersDAO();
            User user = new User(eMailField.getText(),passwordField.getText(), userNameField.getText(), countryField.getText(), male.isSelected());
            dao.addUser(user);

            dao.authentication(user);
            if (user.getUsername()!=null){
                System.out.println("You signed In");
                Stage stage = (Stage) signUpandIn.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/notebook.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root1,400,400));
                stage.setTitle("MyPersonalNotebook");
                stage.show();
            }
        }


    }

}
