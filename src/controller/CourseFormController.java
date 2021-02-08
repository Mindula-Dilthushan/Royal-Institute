package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class CourseFormController {
    public TextField txtCourseID;
    public JFXTextField txtCourseName;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    public JFXButton btnSaveCourse;
    public JFXButton btnUpdateCourse;

    private CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.COURSE);

    public void btnSaveCourseOnAction(ActionEvent actionEvent) {
        try{
            boolean saved = courseBO.saveCourse(
                    new CourseDTO(
                        txtCourseID.getText(),
                        txtCourseName.getText(),
                        txtCourseDuration.getText(),
                        Double.parseDouble(txtCourseFee.getText())
                    )
            );

            if (saved){
                System.out.println("save");
            }else {
                System.out.println("no");
            }

        }catch (Exception e){

        }
    }

    public void btnUpdateCourseOnAction(ActionEvent actionEvent) {
    }
}
