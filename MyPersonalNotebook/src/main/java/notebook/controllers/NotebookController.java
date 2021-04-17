package notebook.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class NotebookController{
    public void menuFileItemExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
