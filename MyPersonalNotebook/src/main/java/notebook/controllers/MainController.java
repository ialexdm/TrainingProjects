package notebook.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import notebook.database.DBConn;
import notebook.database.User;
import notebook.database.UsersDAO;

import java.io.IOException;
import java.sql.SQLException;

public class MainController {
    @FXML
    public TextField mainEmail;
    public PasswordField mainPassword;

    public void menuFileItemExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public Button signIn =  new Button();
    @FXML
    public Button signUp =  new Button();

    @FXML
    private void signIn(ActionEvent event) throws IOException, SQLException {
        User user = new User(mainEmail.getText(), mainPassword.getText());
        UsersDAO dao = new UsersDAO();
        dao.authentication(user);
        if (user.getUsername()!=null){
            System.out.println("You signed In");
            Stage stage = (Stage) signIn.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/notebook.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1,400,400));
            stage.setTitle("MyPersonalNotebook");
            stage.show();
        }else {
            mainEmail.setStyle("-fx-prompt-text-fill: red ;");
            mainEmail.setPromptText("*Invalid e-mail or password");
            mainEmail.setText("");
        }
    }

    @FXML
    private void signUp(ActionEvent actionEvent) throws IOException {
        System.out.println("You signed Up");
        Stage stage = (Stage) signUp.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sign_up_form.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("MyPersonalNotebook");
        stage.setScene(new Scene(root1,400,400));
        stage.show();
    }


}
