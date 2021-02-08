package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MainFormController {
    public AnchorPane mainAnchor;

    public void initialize(){
        try {
            mainAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/DashboardForm.fxml"));
            mainAnchor.getChildren().addAll(load.getChildren());
        }catch (Exception e){

        }
    }
}
