package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentFormController {
    public JFXComboBox cmbCourseNameSearch;
    public JFXTextField txtStId;
    public JFXTextField txtStName;
    public JFXTextField txtStAddress;
    public JFXDatePicker txtStDob;
    public RadioButton rbtnMale;
    public RadioButton rbtnFemale;
    public JFXTextField txtStMobile;
    public JFXButton btnUpdateStudent;
    public JFXButton btnDeleteStudent;
    public TableView tblStudent;
    public TableColumn colRegNo;
    public TableColumn colCourseName;
    public TableColumn colStNo;
    public TableColumn colStName;
    public TableColumn colStAddress;
    public TableColumn colStContact;
    public TableColumn colStGender;
    public JFXButton btnRefreshTbl;

    public void btnRefreshTblOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void txtStIdOnAction(ActionEvent actionEvent) {
    }

    public void cmbCourseNameSearchOnAction(ActionEvent actionEvent) {
    }
}
