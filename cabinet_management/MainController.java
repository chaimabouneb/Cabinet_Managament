package cabinet_management;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javax.swing.Action;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    @FXML
    private AnchorPane patient_form;
    
    @FXML
    private Button addP_btn;

    @FXML 
    private TextField patient_nom;

    @FXML
    private TextField patient_prenom;

    @FXML
    private AnchorPane extra_infoY;

    @FXML
    private AnchorPane extra_infoA;

    @FXML
    private DatePicker AGE;

    @FXML
    private TextField lieu;

    @FXML
    private TextField adress;
    
    @FXML
    private TextField tel;

    @FXML
    private TextField profession;

    @FXML
    private TextField diplome;

    @FXML
    private TextField telparent;

    @FXML
    private TextField lieu1;

    @FXML
    private TextField adress1;

    @FXML
    private ComboBox<ClasseEtude> ClasseDetude;

    @FXML
    private TableColumn<Dossier, Double> patient_id;
    @FXML
    private TableColumn<Dossier, String> patient_lname;
    @FXML
    private TableColumn<Dossier, String> patient_fname;
    @FXML
    private TableView<Dossier> patientstab;

    @FXML
    private Label a;

    @FXML
    private Label f;

    @FXML
    private Label l;

    @FXML
    private Label b;

    @FXML
    private TextField numdos;

    @FXML
    private Label agepatient;


    private ObservableList<Dossier> dossierList;
    


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
                    patient_form.setVisible(false);
                    dash_form.setVisible(false);
                    patients_form.setVisible(true);
                    app_form.setVisible(false);
                    showPatientData();

                    
                }
            }
        }
    }

    public void switchFormTypeRendezv(ActionEvent event) {

        if (event.getSource() == type_app) {
            if (type_app.getValue() == "Consultation") {
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

    public void addPatient(ActionEvent event){
        patient_form.setVisible(true);
        extra_infoA.setVisible(false);
        extra_infoY.setVisible(false);
    }


     public void showPatientData() {
        //String doubleString = Double.toString(doss1.getNum());

        //patient_id.setCellValueFactory(cellData -> new SimpleStringProperty(doubleString));
        patient_fname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getpatient().getprenom()));
        patient_lname.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getpatient().getnom()));


        // Create an observable list for the dossiers
        dossierList = FXCollections.observableArrayList();
        patientstab.setItems(dossierList);
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);

        dossierList.clear(); // Clear existing data
        dossierList.addAll(loggedInOrthophonist.getPatients().values()); // Add new data
    }

    public void showDossierData(){
        f.setText(doss1.getpatient().getnom() + " " + doss1.getpatient().getprenom());
        a.setText(doss1.getpatient().getadress());
        l.setText(doss1.getpatient().getlieu());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = doss1.getpatient().getdate().format(formatter);
        b.setText(dateString);
        int age=doss1.getpatient().getAge(doss1.getpatient().getdate());
        String y =Integer.toString(age);
        System.out.println(y);
        agepatient.setText(y);


    }


    private Patient patient;
    Dossier doss1;


    public void submission(ActionEvent event ){
        String nom = patient_nom.getText();
        String prenom = patient_prenom.getText();
        LocalDate year = AGE.getValue();
        String text=numdos.getText();
        double id = Double.parseDouble(text);


        ClasseDetude.getItems().setAll(ClasseEtude.values());

        patient= new Patient(nom,prenom,year);
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);

        

         if (loggedInOrthophonist.isPatient(patient)){
                    patient_page.setVisible(true);
                    patient_form.setVisible(false);
                    dash_form.setVisible(false);
                    patients_form.setVisible(false);
                    app_form.setVisible(false);
                    patient_page.setVisible(true);
                    doss1=loggedInOrthophonist.getPatient(id);
                    showDossierData();


                    System.out.println("siiiiiii");

        }
        else {
            System.out.println("hereeeee");
            if (patient.isAdulte(year)){
                System.out.println("adulte");
                extra_infoY.setVisible(false);
                extra_infoA.setVisible(true);
            }
            else{
                System.out.println("young");
                extra_infoY.setVisible(true);
                extra_infoA.setVisible(false);
            }
            

        }
       
    }

    public void done(ActionEvent event){

        if (patient.getAdulte()) {
            String Lieu = lieu.getText();
            String adresse = adress.getText();
            String proffession = profession.getText();
            String telephone = tel.getText();
            String diplom = diplome.getText();
            patient.setadress(adresse);
            patient.setlieu(Lieu);
            Adulte adulte= new Adulte(patient ,diplom,proffession,telephone);
            doss1= new Dossier(adulte);


        }
        else{
            String Lieu1 = lieu1.getText();
            String adresse1 = adress1.getText();
            String tel1 = telparent.getText();
            ClasseEtude classe = ClasseDetude.getValue();
            patient.setadress(adresse1);
            patient.setlieu(Lieu1);
            Enfant enfant=new Enfant(patient, classe, tel1);
            doss1= new Dossier(enfant);

        }
        

        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        if (loggedInOrthophonist.isPatient(patient)){
                    patient_page.setVisible(true);
                    patient_form.setVisible(false);
                    dash_form.setVisible(false);
                    patients_form.setVisible(false);
                    app_form.setVisible(false);
                    System.out.println("siiiiiii");

        }
        else {
            System.out.println("hereeeee");
            loggedInOrthophonist.addPatient(doss1);

        }
        management.sauvegarderUtilisateurs();
        showPatientData();

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
