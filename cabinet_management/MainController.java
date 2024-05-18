package cabinet_management;

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
import javafx.fxml.Initializable;
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

public class MainController implements Initializable {
    private Management management = new Management();

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
    private TextField thema;
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
    private TableView<Patient> patientstab;

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

            try {
                int houre = Integer.parseInt(hour.getText());
                int minute = Integer.parseInt(min.getText());

                LocalTime localTime = LocalTime.of(houre, minute);
                Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);

                if (loggedInOrthophonist.rendezVousExists(date.getValue(), localTime)) {
                    a.errorMessg("already taken");
                } else {
                    if (type_app.getValue().equals("Consultation")) {
                        Consultation c = new Consultation(
                                Integer.parseInt(ageconsultation.getText()),
                                (String) gender_Consultation.getValue(),
                                namecon.getText(),
                                date.getValue(), localTime);
                        loggedInOrthophonist.ajouterc(c);
                    } else if (type_app.getValue().equals("Suivi")) {
                        Suivi ss = new Suivi(
                                enlign.isSelected(),
                                date.getValue(),
                                localTime,
                                namesuivi.getText() // Assuming namesuivi is the patient's name field
                        );
                        loggedInOrthophonist.ajouters(ss);
                    } else if (type_app.getValue().equals("atelier")) {
                        Atelier atelier = new Atelier(
                                thema.getText(),
                                date.getValue(),
                                localTime);
                        loggedInOrthophonist.ajoutera(atelier);
                    }
                    showAppData();
                    a.succesMessage("success");
                    management.sauvegarderUtilisateurs();
                }
            } catch (NumberFormatException ex) {
                a.errorMessg("Invalid time format");
            }
        }
    }

    public ObservableList<Patient> PateintsgetData() {
        ObservableList<Patient> listData = FXCollections.observableArrayList();

        for (Patient r : Data.orthophoniste.patient) {
            listData.add(r);
        }
        return listData;
    }

    public void showPatientsData() {

        ObservableList<Patient> appoinmentListData = PateintsgetData();

        patientstab.setItems(appoinmentListData);
    }

    public ObservableList<RendezVous> appointmentGetData() {
        ObservableList<RendezVous> listData = FXCollections.observableArrayList();
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);

        if (loggedInOrthophonist != null) {
            if ("Consultation".equals(type_app.getValue())) {
                TreeSet<Consultation> consultations = loggedInOrthophonist.getConsultations();
                if (consultations != null && !consultations.isEmpty()) {
                    listData.addAll(consultations);
                }
            } else if ("Suivi".equals(type_app.getValue())) {
                TreeSet<Suivi> suivi = loggedInOrthophonist.getSuivi();
                if (suivi != null && !suivi.isEmpty()) {
                    listData.addAll(suivi);
                }
            } else if ("atelier".equals(type_app.getValue())) {
                TreeSet<Atelier> ateliers = loggedInOrthophonist.getAtelier();
                if (ateliers != null && !ateliers.isEmpty()) {
                    listData.addAll(ateliers);
                }
            }
        }
        return listData;
    }

    public void showAppData() {
        ObservableList<RendezVous> appointmentListData = appointmentGetData();
        tableConsultaion.setItems(appointmentListData);
        tableAtelier.setItems(appointmentListData);
        tablesuivi.setItems(appointmentListData);

        // Set up the nameSuivitab and enligneSuivitab columns for Suivi appointments
        namesuivitab.setCellValueFactory(new PropertyValueFactory<>("nom"));
        eopsuivitab.setCellValueFactory(new PropertyValueFactory<>("e"));

        // Set up other columns similarly, assuming these methods exist in RendezVous
        namecontab.setCellValueFactory(new PropertyValueFactory<>("nom"));
        agecontab.setCellValueFactory(new PropertyValueFactory<>("age"));
        datecontab.setCellValueFactory(new PropertyValueFactory<>("date"));
        duationcontab.setCellValueFactory(new PropertyValueFactory<>("duree"));
        gendercontab.setCellValueFactory(new PropertyValueFactory<>("gender"));

    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            patient_page.setVisible(false);

            dash_form.setVisible(true);
            patients_form.setVisible(false);
            app_form.setVisible(false);
        } else {
            if (event.getSource() == app_btn) {
                dash_form.setVisible(false);
                patients_form.setVisible(false);
                patient_page.setVisible(false);
                app_form.setVisible(true);

            } else {
                if (event.getSource() == patients_btn) {
                    patient_page.setVisible(false);

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

        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        // loggedInOrthophonist.ajouterc(c);
        // management.sauvegarderUtilisateurs();
        // showAppData();
    }

}
