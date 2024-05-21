package cabinet_management;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javax.swing.Action;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
    @FXML
    private Button addapp;

    @FXML
    private AnchorPane adult_info;

    @FXML
    private TextField ageconsultation;

    @FXML
    private TableColumn<?, ?> agecontab;

    @FXML
    private Button app_btn;

    @FXML
    private AnchorPane app_form;

    @FXML
    private AnchorPane atelier;

    @FXML
    private AnchorPane consultation;

    @FXML
    private AnchorPane dash_form;

    @FXML
    private Button dashboard_btn;

    @FXML
    private DatePicker date;

    @FXML
    private TableColumn<?, ?> dateateliertab;

    @FXML
    private TableColumn<?, ?> datecontab;

    @FXML
    private TableColumn<?, ?> datesuivitab;

    @FXML
    private TableColumn<?, ?> duationcontab;

    @FXML
    private TableColumn<?, ?> durationateliertab;

    @FXML
    private TableColumn<?, ?> durationsuivitab;

    @FXML
    private CheckBox enlign;

    @FXML
    private TableColumn<?, ?> eopsuivitab;

    @FXML
    private ComboBox<?> gender_Consultation;

    @FXML
    private TableColumn<?, ?> gender_col_atelier;

    @FXML
    private TableColumn<?, ?> gendercontab;

    @FXML
    private TextField hour;

    @FXML
    private AnchorPane kid_info;

    @FXML
    private TextField min;

    @FXML
    private TextField namecon;

    @FXML
    private TableColumn<?, ?> namecontab;

    @FXML
    private TableColumn<?, ?> namesateliertab;

    @FXML
    private TextField namesuivi;

    @FXML
    private TableColumn<?, ?> namesuivitab;

    @FXML
    private Label nav_name;

    @FXML
    private TableColumn<?, ?> numdossierateliertab;

    @FXML
    private TableColumn<?, ?> numdossiersuivitab;

    @FXML
    private TableColumn<?, ?> patient_id;

    @FXML
    private TableColumn<?, ?> patient_name;

    @FXML
    private AnchorPane patient_page;

    @FXML
    private Button patients_btn;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private Button profil_btn;

    @FXML
    private AnchorPane suivi;

    @FXML
    private TableView<RendezVous> tableAtelier;

    @FXML
    private TableView<RendezVous> tableConsultaion;

    @FXML
    private TableView<RendezVous> tablesuivi;

    @FXML
    private ComboBox<?> type_app;

    @FXML
    private Label window_name;

    /*
     * public ObservableList<RendezVous> getAppData(){
     * 
     * 
     * ObservableList<RendezVous> listData = FXCollections.observableArrayList();
     * 
     * }
     */ public void appointmentGenderList() {
        List<String> listG = new ArrayList<>();

        for (String data : Data.gender) {
            listG.add(data);
            System.out.println(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listG);
        gender_Consultation.setItems(listData);

    }

    public void appointmentStatusList() {
        List<String> listS = new ArrayList<>();

        for (String data : Data.status) {
            listS.add(data);
        }

        ObservableList listData = FXCollections.observableArrayList(listS);
        type_app.setItems(listData);

    }

    public void AddAppBtn(ActionEvent e) {
        if (e.getSource() == addapp) {
            AlertMessage a = new AlertMessage();
            System.out.println("heehe");
            TextField hourTextField = hour;
            TextField minuteTextField = min;
            String hourText = hourTextField.getText();
            String minuteText = minuteTextField.getText();

            int houre = Integer.parseInt(hourText);
            int minute = Integer.parseInt(minuteText);

            LocalTime localTime = LocalTime.of(houre, minute);
            System.out.println(localTime);
            System.out.println(type_app.getValue());
            TreeSet<Consultation> s = Data.orthophoniste.getConsultations();
            for (Consultation r : s) {
                System.out.println(r.getDate());
            }

            if (Data.orthophoniste.rendezVousExists(date.getValue(), localTime)) {
                a.errorMessg("already taken");

            } else {
                if (type_app.getValue() == "Consultation") {
                    Consultation c = new Consultation(Integer.parseInt(ageconsultation.getText()), namecon.getText(),
                            date.getValue(), localTime);
                    Data.orthophoniste.ajouterc(c);

                    System.out.println("c1");

                } else if (type_app.getValue() == "Suivi") {

                    Suivi ss = new Suivi(enlign.isSelected(), date.getValue(), localTime);
                    System.out.println("suivi");

                } else if (type_app.getValue() == "atelier") {
                    System.out.println("ate");

                }
            }
            showAppData();
            a.succesMessage("success");
        }
    }

    public ObservableList<RendezVous> appointmentGetData() {
        ObservableList<RendezVous> listData = FXCollections.observableArrayList();
        RendezVous appData = null;

        for (RendezVous r : Data.orthophoniste.rendezVousSet) {

            if (type_app.getValue() == "Consultation" && r.getClass().getName() == "Consultation") {
                appData = new Consultation(((Consultation) r).getage(), ((Consultation) r).getnom(), r.getDate(),
                        r.getHeure());
            } else if (type_app.getValue() == "Suivi" && r.getClass().getName() == "Suivi") {
                appData = new Suivi();

            } else if (type_app.getValue() == "atelier" && r.getClass().getName() == "Atelier") {
                appData = new Atelier();
            }

            // STORE ALL DATA
            listData.add(appData);
        }
        return listData;

    }

    public void showAppData() {

        ObservableList<RendezVous> appoinmentListData = appointmentGetData();
        if (type_app.getValue() == "Consultation") {
            tableConsultaion.setItems(appoinmentListData);

        } else if (type_app.getValue() == "Suivi") {
            tablesuivi.setItems(appoinmentListData);

        } else if (type_app.getValue() == "atelier") {
            tableAtelier.setItems(appoinmentListData);

        }

        // appointments_col_name.setCellValueFactory(new
        // PropertyValueFactory<>("name"));
        /*
         * .setCellValueFactory(new PropertyValueFactory<>("gender"));
         * appointments_col_contactNumber.setCellValueFactory(new
         * PropertyValueFactory<>("mobileNumber"));
         * appointments_col_description.setCellValueFactory(new
         * PropertyValueFactory<>("description"));
         * appointments_col_date.setCellValueFactory(new
         * PropertyValueFactory<>("date"));
         * appointments_col_dateModify.setCellValueFactory(new
         * PropertyValueFactory<>("dateModify"));
         * appointments_col_dateDelete.setCellValueFactory(new
         * PropertyValueFactory<>("dateDelete"));
         * appointments_col_status.setCellValueFactory(new
         * PropertyValueFactory<>("status"));
         * 
         * appointments_tableView.setItems(appoinmentListData);
         */
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dash_form.setVisible(true);
            patients_form.setVisible(false);
            app_form.setVisible(false);
        } else {
            if (event.getSource() == app_btn) {
                dash_form.setVisible(false);
                patients_form.setVisible(false);
                app_form.setVisible(true);
            } else {
                if (event.getSource() == patients_btn) {
                    dash_form.setVisible(false);
                    patients_form.setVisible(true);
                    app_form.setVisible(false);
                }
            }
        }
    }

    public void switchFormTypeRendezv(ActionEvent event) {

        if (event.getSource() == type_app) {
            if (type_app.getValue() == "Consultaion") {
                consultation.setVisible(true);
                suivi.setVisible(false);
                atelier.setVisible(false);
            } else if (type_app.getValue() == "Suivi") {
                consultation.setVisible(false);
                suivi.setVisible(true);
                atelier.setVisible(false);
            } else if (type_app.getValue() == "atelier") {
                consultation.setVisible(false);
                suivi.setVisible(false);
                atelier.setVisible(true);
            }
        }
    }

    public void displayName() {
        String name = Data.name;
        nav_name.setText(name);
    }

    Management m = new Management();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // kkk
        displayName();
        appointmentGenderList();
        appointmentStatusList();
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        System.out.println(Data.orthophoniste.getNom());

        for (Consultation x : Data.orthophoniste.getConsultations()) {
            System.out.println(x.getnom());
        }

        // showAppData();
    }

  
}
