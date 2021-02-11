package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class LoginFormController {

    public JFXTextField txtUserName;
    public JFXTextField txtPw;
    public JFXButton btnPwView;
    public JFXButton btnEnter;

    public void btnEnterOnAction(ActionEvent actionEvent) {
        try {
            Stage exit_stage = (Stage) btnEnter.getScene().getWindow();
            exit_stage.close();
            URL resource = this.getClass().getResource("/view/MainForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
        }
    }

    public void btnPwViewOnAction(ActionEvent actionEvent) {
    }
}
