package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.RegistrationDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tm.StudentTM;

import java.util.List;

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
    public TableView<StudentTM> tblStudent;
    public TableColumn <StudentTM,String> colRegNo;
    public TableColumn <StudentTM,String> colCourseName;
    public TableColumn <StudentTM,String> colStNo;
    public TableColumn <StudentTM,String> colStName;
    public TableColumn <StudentTM,String> colStAddress;
    public TableColumn <StudentTM,String> colStContact;
    public TableColumn <StudentTM,String>colStDOB;
    public TableColumn <StudentTM,String> colStGender;
    public JFXButton btnRefreshTbl;

    CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.COURSE);
    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.STUDENT);
    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.REGISTRATION);

    ObservableList<StudentTM> studentTMObservableList = FXCollections.observableArrayList();
    List<CourseDTO> courseDTOList = null;

    public void initialize(){
        colRegNo.setCellValueFactory(new PropertyValueFactory<>("regisID"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("couName"));
        colStNo.setCellValueFactory(new PropertyValueFactory<>("stuID"));
        colStName.setCellValueFactory(new PropertyValueFactory<>("stuName"));
        colStAddress.setCellValueFactory(new PropertyValueFactory<>("stuAddress"));
        colStContact.setCellValueFactory(new PropertyValueFactory<>("stuContact"));
        colStDOB.setCellValueFactory(new PropertyValueFactory<>("stuDOB"));
        colStGender.setCellValueFactory(new PropertyValueFactory<>("stuGender"));
        tblStudent.setItems(studentTMObservableList);
        loadStudents();
    }
    private void loadStudents(){
        try {
            List<CourseDTO> courseDTOList = courseBO.getAll();
            for (CourseDTO courseDTOs : courseDTOList){
                cmbCourseNameSearch.getItems().add(courseDTOs.getCourseName());
            }
            this.courseDTOList= courseDTOList;
        }catch (Exception e){
        }
    }
    public void cmbCourseNameSearchOnAction(ActionEvent actionEvent) {
        String courses = (String) cmbCourseNameSearch.getSelectionModel().getSelectedItem();
        CourseDTO courseDTO1 = null;
        for (CourseDTO courseDTO : courseDTOList){
            if (!courses.isEmpty() && courseDTO.getCourseName().
                    compareToIgnoreCase(courses) == 0){
                courseDTO1 = courseDTO;
            }
        }
        try {
            if (courseDTO1 !=null){
                List<RegistrationDTO> registrationDTOList = registrationBO.getAllRegistration(courseDTO1.getCourseId());
                studentTMObservableList.clear();

                for (RegistrationDTO registrationDTO : registrationDTOList){
                    studentTMObservableList.add(searchStudentTMs(registrationDTO,courseDTO1));
                    tblStudent.refresh();
                }
            }
        }catch (Exception e){
        }
    }

    private StudentTM searchStudentTMs(RegistrationDTO registrationDTO,CourseDTO courseDTOs){
        StudentTM studentTMss = new StudentTM();

        studentTMss.setRegisID(registrationDTO.getRegId());
        studentTMss.setCouName(courseDTOs.getCourseName());
        studentTMss.setStuID(registrationDTO.getStudentDTO().getStudentId());
        studentTMss.setStuName(registrationDTO.getStudentDTO().getStudentName());
        studentTMss.setStuAddress(registrationDTO.getStudentDTO().getStudentAddress());
        studentTMss.setStuContact(registrationDTO.getStudentDTO().getStudentContact());
        studentTMss.setStuDOB(registrationDTO.getStudentDTO().getStudentDOB());
        studentTMss.setStuGender(registrationDTO.getStudentDTO().getStudentGender());
        return studentTMss;
    }
    public void btnRefreshTblOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void txtStIdOnAction(ActionEvent actionEvent) {
    }


}
