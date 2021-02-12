package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardFormController {

    public AnchorPane dashboardAnchor;
    public JFXButton btnExit;
    public JFXButton btnCourse;
    public JFXButton btnRegistration;
    public JFXButton btnStudent;

    public void initialize(){
        try {
            dashboardAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/RegistrationForm.fxml"));
            dashboardAnchor.getChildren().addAll(load.getChildren());
        }catch (Exception e){
        }
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
        Stage exit_stage = (Stage) btnExit.getScene().getWindow();
        exit_stage.close();
    }

    public void btnCourseOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/CourseForm.fxml"));
            dashboardAnchor.getChildren().addAll(load.getChildren());
        }catch (Exception e){
        }
    }

    public void btnRegistrationOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/RegistrationForm.fxml"));
            dashboardAnchor.getChildren().addAll(load.getChildren());
        }catch (Exception e){
        }
    }

    public void btnStudentOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnchor.getChildren().clear();
            AnchorPane load = FXMLLoader.load(this.getClass().getResource("/view/StudentForm.fxml"));
            dashboardAnchor.getChildren().addAll(load.getChildren());
        }catch (Exception e){
        }
    }
}
