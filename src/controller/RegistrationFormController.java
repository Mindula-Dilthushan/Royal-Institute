package controller;

import bo.BOFactory;
import bo.custom.AddRegistrationBO;
import bo.custom.CourseBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Registration;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import tm.CourseTM;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationFormController {

    public JFXTextField txtStName;
    public Label lblStID;
    public RadioButton rbtnMale;
    public RadioButton rbtnFemale;
    public JFXDatePicker dpDate;
    public JFXDatePicker dpStDOB;
    public JFXTextField txtStAddress;
    public JFXComboBox cmbCourseID;
    public Label lblCourseID;
    public JFXTextField txtCourseDuration;
    public JFXTextField txtCourseFee;
    public JFXTextField txtStMobileNumber;
    public TableView <CourseTM>tblRegistration;
    public TableColumn <CourseTM,String> colCourseID;
    public TableColumn <CourseTM,String> colCourseName;
    public TableColumn <CourseTM,String> colCourseDuration;
    public TableColumn <CourseTM,Double> colCourseFee;
    public JFXButton btnAdd;
    public JFXButton btnRemove;
    public JFXTextField txtTotal;
    public JFXButton btnReg;
    public Label lblRegID;

    CourseBO courseBO = (CourseBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.COURSE);
    AddRegistrationBO addRegistrationBO = (AddRegistrationBO) BOFactory.getBoFactory().getSuperBO(BOFactory.BOType.ADDREGISTRATION);

    ObservableList<CourseTM> courseTMObservableList = FXCollections.observableArrayList();
    List<CourseDTO> courseDTOList = null;
    CourseDTO addCourses = null;

    public void initialize(){
        dpDate.setValue(LocalDate.now());
        courseFeesTot();
        tbl();
        loadAllCourse();
        genderToggleGroup();
    }
    private void courseFeesTot(){
        courseTMObservableList.addListener((ListChangeListener.Change<? extends CourseTM> courseTot) -> {
            double fees = 0;
            for (CourseTM courseTM : courseTMObservableList){
                fees += Double.parseDouble(String.valueOf(courseTM.getCoFee()));
            }
            txtTotal.setText(String.valueOf(fees));
        });

    }
    private void loadAllCourse(){
        try {
            List<CourseDTO> courseDTOList0 = courseBO.getAll();
            this.courseDTOList = courseDTOList0;
                for (CourseDTO courseDTO : courseDTOList0){
                    cmbCourseID.getItems().add(courseDTO.getCourseName());
                }
        }catch (Exception e){
        }
    }
    private void genderToggleGroup(){
        ToggleGroup tgGender = new ToggleGroup();
        rbtnMale.setToggleGroup(tgGender);
        rbtnFemale.setToggleGroup(tgGender);
    }
    private void tbl(){
        colCourseID.setCellValueFactory(new PropertyValueFactory<>("coId"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("coName"));
        colCourseDuration.setCellValueFactory(new PropertyValueFactory<>("coDuration"));
        colCourseFee.setCellValueFactory(new PropertyValueFactory<>("coFee"));
    }
    private void courseTextClear(){
        lblCourseID.setText(null);
        txtCourseDuration.setText(null);
        txtCourseFee.setText(null);
    }
    public void cmbCourseIDOnAction(ActionEvent actionEvent) {
        cmbCourseID.setValue("f");
//        try {
//            String coursesName = String.valueOf(cmbCourseID.getSelectionModel().getSelectedItem());
//
//            CourseDTO selectCourses = null;
//            for (CourseDTO courseDTO1 = courseDTOList){
//                if (courseDTO1.getCourseName().compareToIgnoreCase(coursesName) == 0) {
//                    selectCourses = courseDTO1;
//                    this.addCourses = selectCourses;
//                }
//            }
//            if (selectCourses != null) {
//                lblCourseID.setText(selectCourses.getCourseId());
//                txtCourseDuration.setText(selectCourses.getDuration());
//                txtCourseFee.setText(String.valueOf(selectCourses.getCourseFee()));
//            }
//        }catch (Exception e){
//
//        }
    }
    private StudentDTO selectStudentDTO(){
        StudentDTO selectStDTO = new StudentDTO();
        selectStDTO.setStudentId(lblStID.getText());
        selectStDTO.setStudentName(txtStName.getText());
        selectStDTO.setStudentAddress(txtStAddress.getText());
        selectStDTO.setStudentContact(txtStMobileNumber.getText());
        selectStDTO.setStudentDOB(String.valueOf(dpStDOB.getValue()));

            if (rbtnMale.isSelected()){
                selectStDTO.setStudentGender("Male");
            }
            if (rbtnFemale.isSelected()){
                selectStDTO.setStudentGender("Female");
            }
            return selectStDTO;
    }
    public void btnAddOnAction(ActionEvent actionEvent) {
        try{
            if (addCourses !=null){
                CourseTM courseTM = new CourseTM(
                        addCourses.getCourseId(),
                        addCourses.getCourseName(),
                        addCourses.getDuration(),
                        addCourses.getCourseFee()
                );
                courseTMObservableList.add(courseTM);
                tblRegistration.refresh();
                courseDTOList.remove(addCourses);
                cmbCourseID.getItems().clear();
                for (CourseDTO courseDTO : courseDTOList){
                    cmbCourseID.getItems().add(courseDTO.getCourseName());
                }
                courseTextClear();
                addCourses = null;
            }
        }catch (Exception e){

        }
    }
    public void btnRemoveOnAction(ActionEvent actionEvent) {
    }

    public void btnRegOnAction(ActionEvent actionEvent) {
        try {
            StudentDTO getSelectStudentDTO = selectStudentDTO();

            List<CourseDTO> selectCourseDTOList = new ArrayList<>();
            for (CourseTM courseTM : courseTMObservableList) {
                selectCourseDTOList.add(
                        new CourseDTO(
                                courseTM.getCoId(),
                                courseTM.getCoName(),
                                courseTM.getCoDuration(),
                                courseTM.getCoFee()
                        )
                );
            }

            List<RegistrationDTO> selectRegDTOList = new ArrayList<>();
            for (CourseDTO courseDTO : selectCourseDTOList) {
                selectRegDTOList.add(
                        new RegistrationDTO(
                                null,
                                String.valueOf(LocalDate.now()),
                                courseDTO.getCourseFee(),
                                selectStudentDTO(),
                                courseDTO
                        )
                );
            }

            boolean savedAddRegistration = addRegistrationBO.addRegistration(
                    selectStudentDTO(),
                    selectRegDTOList
            );

            if (savedAddRegistration){
                System.out.println("save");
            }else {
                System.out.println("no");
            }

        }catch (Exception e){

        }

    }
}
