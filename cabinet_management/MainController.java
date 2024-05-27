package cabinet_management;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import javafx.beans.property.SimpleDoubleProperty;

import javax.swing.Action;

import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
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
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
    private Management management = new Management();

    @FXML
    private Button addapp;

    @FXML
    private Button addBtnObj;

    @FXML
    private Button mod;

    @FXML
    private TextArea objarea;
    @FXML
    private Button addatelier;

    @FXML
    private Button deletatelier;
    @FXML
    private AnchorPane adult_info;
    @FXML
    private AnchorPane enfant_info;
    @FXML
    private TextField ageconsultation;
    @FXML
    private Label numerofich;

    @FXML
    private Label datecrefiche;

    @FXML
    private TextField namatelier;

    @FXML
    private TableColumn<?, ?> agecontab;

    @FXML
    private TableColumn<?, ?> colscore;

    @FXML
    private Button app_btn;
    @FXML
    private Button addBtnScore;
    @FXML
    private TextField scoreText;
    @FXML
    private Button addsuivipatpage;
    @FXML
    private Button save;

    @FXML
    private AnchorPane app_form;

    @FXML
    private AnchorPane fiche_form;

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
    private Dossier ddi;
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
    private TableColumn<Atelier, String> namesateliertab;

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
    private TableColumn<?, ?> patient_idd;
    @FXML
    private TableColumn<?, ?> patient_contact;
    @FXML
    private TableColumn<?, ?> patient_gender;

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
    private TableView<FicheSuivi> tabfichepatpage;

    @FXML
    private TableView<RendezVous> apppat;
    @FXML
    private CheckBox att;
    @FXML
    private TableView<Objectif> tablefiche;
    @FXML
    private TableColumn<?, ?> colobj;

    @FXML
    private TableColumn<?, ?> numfiche;
    private ObservableList<Item> data;
    private ObservableList<Objectif> dataobj;

    @FXML
    private TableView<Item> tabnomatelier;
    @FXML
    private TableColumn<Item, String> nametabatelier;
    @FXML
    private TableView<RendezVous> patientstabb;

    @FXML
    private TableColumn<?, ?> patientstabbdate;

    @FXML
    private TableColumn<?, ?> patientstabbtype;

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
    private HashMap<String, Dossier> patientFolders;
    @FXML
    private ComboBox<ClasseEtude> ClasseDetude;

    @FXML
    private TableColumn<Dossier, Double> patient_id;
    @FXML
    private TableColumn<Dossier, String> patient_lname;
    @FXML
    private TableColumn<Dossier, String> patient_fname;
    @FXML
    private TableColumn<?, ?> et;
    @FXML
    private TableColumn<?, ?> dt;
    @FXML
    private TableColumn<Dossier, String> patient_age;

    @FXML
    private TableView<Patient> patientstab;

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

    @FXML
    private AnchorPane bo_init;

    @FXML
    private Button addBo;

    @FXML
    private BorderPane maine;

    @FXML
    private ListView<String> questionListView;

    @FXML
    private TextField answerTextField;

    @FXML
    private Button ajouter_epreuve;

    @FXML
    private Button ajouterQuest;

    @FXML 
    private Button ajouterExo;

    @FXML
    private AnchorPane BO;

    @FXML 
    private TextField nom_quest;

    @FXML
    private ListView<TextFlow> form;

    @FXML
    private Button okk;

    @FXML
    private ComboBox<Integer> scoreComboBox;

    @FXML
    private Button submitScoreButton;

    @FXML
    private Label totalScoreLabel;

    @FXML
    private TextField troubleNameField;

    @FXML
    private ComboBox<CategorieTrouble> categorieComboBox;

    @FXML
    private AnchorPane troubleAnch;

    @FXML
    private TextArea projetNameField;

    @FXML
    private TextArea Conclusion_test;

    @FXML 
    private TableView<Bo> boTableView;


    @FXML
    private ListView<String> troubleListView;


    @FXML
    private AnchorPane affichage_Bo;

    @FXML
    private TableView<Test> testTable;

    

    @FXML
    private TableColumn<Test, String> nomColumn;

    @FXML
    private TableColumn<Test, Double> scoreColumn;

    @FXML
    private TableColumn<Test, String> conclusionColumn;


    @FXML
    private TextArea projetTherapeutiqueField;

    @FXML
    private TextArea troublesArea;

    @FXML
    private TextArea anamArea;


    private ObservableList<String> troubleList;



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




    public void save(ActionEvent e) {
        // FicheSuivi s = tabfichepatpage.getSelectionModel().getSelectedItem();
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        if (e.getSource() == save) {
            List<Objectif> regularList = new ArrayList<>(dataobj);
            System.out.println(regularList);
            System.out.println("ssssssssssssssssssssssss");
            Patient selectedPatient = patientstab.getSelectionModel().getSelectedItem();
            Double d = loggedInOrthophonist.getPP().get(selectedPatient.getNom());
            System.out.println("zzzzzzzzzzzzzzzzzzzz");
            System.out.println(d);
            Dossier ddi = loggedInOrthophonist.getPatient(d);
            if (ddi.getFiche() == null || ddi.getFiche().isEmpty()) {
                System.out.println("love");
                FicheSuivi ff = new FicheSuivi(regularList, LocalDate.now(), 1, att.isSelected());

                loggedInOrthophonist.getPatient(d).addF(ff);
                System.out.println(loggedInOrthophonist.getPatient(d).getFiche());
                System.out.println("love");

            } else {
                /*
                 * if (s != null) {
                 * // Remove the existing FicheSuivi from the set
                 * Set<FicheSuivi> fs = loggedInOrthophonist.getPatient(d).getFiche();
                 * fs.remove(s);
                 * 
                 * // Update the Objectifs of the selected FicheSuivi
                 * s.setO(regularList);
                 * 
                 * // Add the updated FicheSuivi back to the set
                 * fs.add(s);
                 * 
                 * // Update the set of Fiches in the Dossier
                 * loggedInOrthophonist.getPatient(d).setFiche(fs);
                 * } else {
                 */
                FicheSuivi ff = new FicheSuivi(regularList, LocalDate.now(),
                        loggedInOrthophonist.getPatient(d).getFiche().size() + 1, att.isSelected());
                loggedInOrthophonist.getPatient(d).addF(ff);
                System.out.println("eeeeeeeeeen");
                System.out.println(loggedInOrthophonist.getPatient(d).getFiche());
                System.out.println("eeeeeeeeeen");

            }
            // Assuming patient_page is Form2
            fiche_form.setVisible(false);
            patient_page.setVisible(true);

            // saveOrthophoniste(loggedInOrthophonist);
            management.sauvegarderUtilisateurs();
            tablefiche.getItems().clear();
            scoreText.clear();
            objarea.clear();

            // Refresh the table in form2
            onRowSelect();

        }
    }

    public void saveOrthophoniste(Orthophoniste orthophoniste) {
        // Implement the logic to save the Orthophoniste object to your data storage
        // mechanism
        // For example, if using Java Object Serialization to save to a file:
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("orthophoniste_data.ser"))) {
            outputStream.writeObject(orthophoniste);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public void switchFiche(ActionEvent e) {
        if (e.getSource() == addsuivipatpage) {
            fiche_form.setVisible(true);
            patient_page.setVisible(false);
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            datecrefiche.setText(formattedDate);
            System.out.println(ddi.getNum());
            System.out.println("ooooooooooooooooooooooo");
            if (ddi.getFiche() == null || ddi.getFiche().isEmpty()) {
                numerofich.setText("01");
            } else {
                numerofich.setText(String.valueOf(ddi.getFiche().size()));
            }
            colobj.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colscore.setCellValueFactory(new PropertyValueFactory<>("note"));

            // Initialize the data list
            // dataobj = FXCollections.observableArrayList();

            // Set the data list to the TableView

        }
    }




    public Patient checkConsultation(String nom) {

        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);




        for (Patient p : loggedInOrthophonist.patient) {

            if (p.getNom().equals(nom)) {

                return p;

            }




        }

        return null;

    }

    public void AddAtelierBtn(ActionEvent e) {
        if (e.getSource() == addatelier) {

            AlertMessage a = new AlertMessage();
            String name = namatelier.getText();
            Item newItem = new Item(name);
            data.add(newItem);

            // Clear the TextField
            namatelier.clear();

        }

    }

    public void AddObjetctifBtn(ActionEvent e) {
        if (e.getSource() == addBtnObj) {

            AlertMessage a = new AlertMessage();
            String name = objarea.getText();
            // Item newItem = new Item(name);
            Objectif newObjectif = new Objectif(name);
            dataobj.add(newObjectif);

            // Clear the TextField
            objarea.clear();

        }

    }

    public void AddAppBtn(ActionEvent e) {

        if (e.getSource() == addapp) {

            AlertMessage a = new AlertMessage();




            try {
                patientFolders = new HashMap<>();
                int houre = Integer.parseInt(hour.getText());

                int minute = Integer.parseInt(min.getText());




                LocalTime localTime = LocalTime.of(houre, minute);

                Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);

                System.out.println(loggedInOrthophonist.getPatient());

                if (loggedInOrthophonist.rendezVousExists(date.getValue(), localTime)) {

                    a.errorMessg("already taken");

                } else {

                    if (type_app.getValue().equals("Consultation")) {
                        Patient p = checkConsultation(namecon.getText());
                        System.out.println("1");

                        Consultation c = new Consultation(

                                Integer.parseInt(ageconsultation.getText()),

                                (String) gender_Consultation.getValue(),

                                namecon.getText(),

                                date.getValue(), localTime);

                        System.out.println(c.getAge());




                        if (p != null) {
                            System.out.println("const patient exist");
                            loggedInOrthophonist.ajouterc(c);

                            if (p.isAdmet()) {

                                Dossier d = loggedInOrthophonist.chercheDossier(p.getNom());

                                d.addRendezVous(c.getDate(), c);

                            }

                        } else {




                            if (Integer.parseInt(ageconsultation.getText()) >= 19) {

                                System.out.println("oui");




                                p = new Adulte(namecon.getText());
                                loggedInOrthophonist.addP(p);

                                loggedInOrthophonist.ajouterc(c);




                            } else {

                                p = new Enfant(namecon.getText());
                                loggedInOrthophonist.addP(p);

                                loggedInOrthophonist.ajouterc(c);
                                System.out.println("const enf dont exist but created");

                            }




                        }

                    } else if (type_app.getValue().equals("Suivi")) {




                        Suivi ss = new Suivi(

                                enlign.isSelected(),

                                date.getValue(),

                                localTime,

                                namesuivi.getText() // Assuming namesuivi is the patient's name field

                        );
                        Patient pp = checkConsultation(namesuivi.getText());

                        if (pp != null && pp.isAdmet()) {
                            System.out.println("patient is admet");
                            loggedInOrthophonist.ajouters(ss);
                            Dossier d = loggedInOrthophonist.chercheDossier(pp.getNom());
                            System.out.println(d.getPatient().getNom());
                            d.addRendezVous(ss.getDate(), ss);

                        } else {
                            loggedInOrthophonist.ajouters(ss);

                            System.out.println("patient is not admet");
                            pp.setAdmet();
                            loggedInOrthophonist.addP(pp);// add to set patient
                            Dossier d = new Dossier(pp);
                            System.out.println(d.getPatient().getNom());
                            d.addRendezVous(ss.getDate(), ss);
                            loggedInOrthophonist.addPatient(d);// add to set of dossier
                            System.out.println(d.getNum());
                            loggedInOrthophonist.addPP(pp.getNom(), d.getNum());
                        }

                    }

                    else if (type_app.getValue().equals("atelier")) {
                        Atelier atelier = new Atelier(

                                thema.getText(),

                                date.getValue(),

                                localTime);
                        /*************************************************** */
                        // liste num dossier des patients

                        for (Item item : data) {
                            Patient ppp = checkConsultation(item.getName());

                            if (ppp != null && ppp.isAdmet()) {
                                Dossier dd = loggedInOrthophonist.chercheDossier(ppp.getNom());
                                System.out.println("ddddddddddddd");
                                patientFolders.put(ppp.getNom(), dd);
                                dd.addRendezVous(atelier.getDate(), atelier);
                                atelier.Addpn(ppp.getNom());

                            } else {
                                System.out.println("22");
                                // loggedInOrthophonist.ajoutera(atelier);
                                ppp.setAdmet();
                                atelier.Addpn(ppp.getNom());

                                // loggedInOrthophonist.addP(ppp);// add to set patient
                                Dossier d = new Dossier(ppp);
                                System.out.println(d.getPatient().getNom());

                                d.addRendezVous(atelier.getDate(), atelier);
                                loggedInOrthophonist.addPatient(d);// add to set of dossier
                                System.out.println(d.getNum());
                                loggedInOrthophonist.addPP(ppp.getNom(), d.getNum());
                                patientFolders.put(ppp.getNom(), d);
                            }

                            atelier.setPat(patientFolders);
                            System.out.println("***********************");

                            System.out.println(patientFolders);
                            System.out.println("***********************");

                            loggedInOrthophonist.ajoutera(atelier);
                        }

                        /*************************************************** */

                        loggedInOrthophonist.ajoutera(atelier);
                    }
                }
                showAppDatainit();
                a.succesMessage("success");
                management.sauvegarderUtilisateurs();
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

            System.out.println("trii");

            if ("Consultation".equals(type_app.getValue())) {

                TreeSet<Consultation> consultations = loggedInOrthophonist.getConsultations();

                if (!consultations.isEmpty()) {

                    listData.addAll(consultations);

                    System.out.println("true bb");

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
        // patientstabb.setItems(appointmentListData);

        // Set up the nameSuivitab and enligneSuivitab columns for Suivi appointments
        namesuivitab.setCellValueFactory(new PropertyValueFactory<>("nom"));
        // eopsuivitab.setCellValueFactory(new PropertyValueFactory<>("e"));
        // numdossiersuivitab.setCellValueFactory(new
        // PropertyValueFactory<>("numerodossier"));

        // Set up other columns similarly, assuming these methods exist in RendezVous
        namecontab.setCellValueFactory(new PropertyValueFactory<>("nom"));
        agecontab.setCellValueFactory(new PropertyValueFactory<>("age"));
        datecontab.setCellValueFactory(new PropertyValueFactory<>("date"));
        duationcontab.setCellValueFactory(new PropertyValueFactory<>("duree"));
        // gendercontab.setCellValueFactory(new PropertyValueFactory<>("gender"));
        // .setCellValueFactory(new PropertyValueFactory<>("nom"));
        // numdossierateliertab.setCellValueFactory(new
        // PropertyValueFactory<>("numerodossier"));
        namesateliertab.setCellValueFactory(new PropertyValueFactory<>("numerodossier"));

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
                showAppDatainit();

            } else {

                if (event.getSource() == patients_btn) {

                    patient_page.setVisible(false);

                    patient_form.setVisible(false);

                    dash_form.setVisible(false);

                    patients_form.setVisible(true);

                    app_form.setVisible(false);
                    showAppDatainit();
                    // showPatientData();




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




    /*
     * public void addPatient(ActionEvent event) {
     * patient_form.setVisible(true);
     * extra_infoA.setVisible(false);
     * extra_infoY.setVisible(false);
     * }
     * 
     * public void showPatientData() {
     * patient_id.setCellValueFactory(cellData -> {
     * Double numero = cellData.getValue().getNum();
     * return new SimpleDoubleProperty(numero).asObject();
     * });
     * // String doubleString = Double.toString(doss1.getNum());
     * 
     * patient_fname.setCellValueFactory(
     * cellData -> new
     * SimpleStringProperty(cellData.getValue().getpatient().getprenom()));
     * patient_lname
     * .setCellValueFactory(cellData -> new
     * SimpleStringProperty(cellData.getValue().getpatient().getnom()));
     * 
     * // Create an observable list for the dossiers
     * dossierList = FXCollections.observableArrayList();
     * patientstab.setItems(dossierList);
     * Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
     * 
     * dossierList.clear(); // Clear existing data
     * dossierList.addAll(loggedInOrthophonist.getPatients().values()); // Add new
     * data
     * }
     * 
     * public void showDossierData() {
     * f.setText(doss1.getpatient().getnom() + " " +
     * doss1.getpatient().getprenom());
     * a.setText(doss1.getpatient().getadress());
     * l.setText(doss1.getpatient().getlieu());
     * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
     * String dateString = doss1.getpatient().getdate().format(formatter);
     * b.setText(dateString);
     * int age = doss1.getpatient().getAge(doss1.getpatient().getdate());
     * String y = Integer.toString(age);
     * System.out.println(y);
     * agepatient.setText(y);
     * 
     * }
     * 
     * private Patient patient;
     * Dossier doss1;
     * 
     * public void submission(ActionEvent event) {
     * String nom = patient_nom.getText();
     * String prenom = patient_prenom.getText();
     * LocalDate year = AGE.getValue();
     * String text = numdos.getText();
     * double id = Double.parseDouble(text);
     * 
     * ClasseDetude.getItems().setAll(ClasseEtude.values());
     * 
     * patient = new Patient(nom, prenom, year);
     * Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
     * 
     * if (loggedInOrthophonist.isPatient(patient)) {
     * patient_page.setVisible(true);
     * patient_form.setVisible(false);
     * dash_form.setVisible(false);
     * patients_form.setVisible(false);
     * app_form.setVisible(false);
     * patient_page.setVisible(true);
     * doss1 = loggedInOrthophonist.getPatient(id);
     * showDossierData();
     * 
     * System.out.println("siiiiiii");
     * 
     * } else {
     * System.out.println("hereeeee");
     * if (patient.isAdulte(year)) {
     * System.out.println("adulte");
     * extra_infoY.setVisible(false);
     * extra_infoA.setVisible(true);
     * } else {
     * System.out.println("young");
     * extra_infoY.setVisible(true);
     * extra_infoA.setVisible(false);
     * }
     * 
     * }
     * 
     * }
     * 
     * public void done(ActionEvent event) {
     * 
     * if (patient.getAdulte()) {
     * String Lieu = lieu.getText();
     * String adresse = adress.getText();
     * String proffession = profession.getText();
     * String telephone = tel.getText();
     * String diplom = diplome.getText();
     * patient.setadress(adresse);
     * patient.setlieu(Lieu);
     * Adulte adulte = new Adulte(patient, diplom, proffession, telephone);
     * doss1 = new Dossier(adulte);
     * 
     * } else {
     * String Lieu1 = lieu1.getText();
     * String adresse1 = adress1.getText();
     * String tel1 = telparent.getText();
     * ClasseEtude classe = ClasseDetude.getValue();
     * patient.setadress(adresse1);
     * patient.setlieu(Lieu1);
     * Enfant enfant = new Enfant(patient, classe, tel1);
     * doss1 = new Dossier(enfant);
     * 
     * }
     * 
     * Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
     * if (loggedInOrthophonist.isPatient(patient)) {
     * patient_page.setVisible(true);
     * patient_form.setVisible(false);
     * dash_form.setVisible(false);
     * patients_form.setVisible(false);
     * app_form.setVisible(false);
     * System.out.println("siiiiiii");
     * 
     * } else {
     * System.out.println("hereeeee");
     * loggedInOrthophonist.addPatient(doss1);
     * 
     * }
     * management.sauvegarderUtilisateurs();
     * showPatientData();
     * 
     * }
     */




    Management m = new Management();

    public void showAppDatainit() {
        ObservableList<RendezVous> listDatat = FXCollections.observableArrayList();
        ObservableList<RendezVous> listDatacons = FXCollections.observableArrayList();
        ObservableList<RendezVous> listData = FXCollections.observableArrayList();
        ObservableList<Patient> listPat = FXCollections.observableArrayList();

        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        patientstab.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() > 1) {
                onRowSelect();
            }
        });

        if (loggedInOrthophonist != null) {
            TreeSet<Suivi> suivi = loggedInOrthophonist.getSuivi();

            listData.addAll(suivi);

            tablesuivi.setItems(listData);
            namesuivitab.setCellValueFactory(new PropertyValueFactory<>("nom"));
            eopsuivitab.setCellValueFactory(new PropertyValueFactory<>("e"));

            TreeSet<Consultation> consultations = loggedInOrthophonist.getConsultations();

            listDatacons.addAll(consultations);

            tableConsultaion.setItems(listDatacons);
            namecontab.setCellValueFactory(new PropertyValueFactory<>("nom"));
            agecontab.setCellValueFactory(new PropertyValueFactory<>("age"));
            datecontab.setCellValueFactory(new PropertyValueFactory<>("date"));
            duationcontab.setCellValueFactory(new PropertyValueFactory<>("duree"));

            TreeSet<Atelier> ateliers = loggedInOrthophonist.getAtelier();

            listDatat.addAll(ateliers);
            tableAtelier.setItems(listDatat);
            namesateliertab.setCellValueFactory(new PropertyValueFactory<>("patientNames"));

            Set<Patient> patient = loggedInOrthophonist.getPatient();
            System.out.println(patient);
            listPat.addAll(patient);
            patientstab.setItems(listPat);
            patient_fname.setCellValueFactory(new PropertyValueFactory<>("nom"));

        }
        //
        // tableAtelier.setItems(listData);

        // patientstabb.setItems(appointmentListData);

        // Set up the nameSuivitab and enligneSuivitab columns for Suivi appointments

        // Set up other columns similarly, assuming these methods exist in RendezVous

    }

    private void onRowSelect() {
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        // ObservableList<HashMap<LocalDate,RendezVous>> listrdv =
        // FXCollections.observableArrayList();
        ObservableList<RendezVous> rendezVousList = FXCollections.observableArrayList(); // List to store rendez
        ObservableList<FicheSuivi> F = FXCollections.observableArrayList(); // List to store rendez
        Patient selectedPatient = patientstab.getSelectionModel().getSelectedItem();

        if (selectedPatient != null) {
            String selectedName = selectedPatient.getNom();
            System.out.println("Selected name: " + selectedName);
            patients_form.setVisible(false);
            patient_page.setVisible(true);
            f.setText(selectedPatient.getNom());
            System.out.println(selectedPatient.getClass().getName());

            // agepatient.setText(toString(selectedPatient.getAge()));
            if (selectedPatient.getClass().getName() == "cabinet_management.Adulte") {
                System.out.println("aaaaaaaaaaaaaaa");
                adult_info.setVisible(true);
                enfant_info.setVisible(false);

            } else {
                adult_info.setVisible(false);
                enfant_info.setVisible(true);
            }
            Double d = loggedInOrthophonist.getPP().get(selectedPatient.getNom());

            Dossier dd = loggedInOrthophonist.getPatient(d);
            this.ddi = dd;
            HashMap<LocalDate, RendezVous> rendezVousMap = dd.getRendezvous();
            // Convert the HashMap entries into a Set
            Set<Map.Entry<LocalDate, RendezVous>> entrySet = rendezVousMap.entrySet();

            // Iterate over the entry set
            for (Map.Entry<LocalDate, RendezVous> entry : entrySet) {
                RendezVous rendezVous = entry.getValue(); // Get the RendezVous object from the entry
                // Add the rendezvous to the list
                rendezVousList.add(rendezVous);
                apppat.setItems(rendezVousList);
                // Set the cell value factory to display desired attribute
                // For example, if you want to display the date attribute of RendezVous:
                patientstabbdate.setCellValueFactory(new PropertyValueFactory<>("date"));
                patientstabbtype.setCellValueFactory(new PropertyValueFactory<>("date"));
            }
            if (!dd.getFiche().isEmpty()) {
                System.out.println("not empty");
                Set<FicheSuivi> v = dd.getFiche();

                F.addAll(v);
                tabfichepatpage.setItems(F);
                numfiche.setCellValueFactory(new PropertyValueFactory<>("num"));
                et.setCellValueFactory(new PropertyValueFactory<>("atteint"));
                dt.setCellValueFactory(new PropertyValueFactory<>("d"));

                tabfichepatpage.setOnMouseClicked((MouseEvent event) -> {
                    if (event.getClickCount() > 1) {
                        onRowSelectt();
                    }
                });
                initialize3();

                // Set the ObservableList to the TableView

                /*
                 * List<Objectif> f = new ArrayList<Objectif>();
                 * ObservableList<Objectif> listPat = FXCollections.observableArrayList();
                 * listPat.addAll(f);
                 * tablefiche.setItems(listPat);
                 * colobj.setCellValueFactory(new PropertyValueFactory<>("nom"));
                 */
                /*
                 * tabfichepatpage.getSelectionModel().selectedItemProperty()
                 * .addListener((obs, oldSelection, newSelection) -> {
                 * // FicheSuivi newSelection =
                 * // tabfichepatpage.getSelectionModel().getSelectedItem();
                 * 
                 * System.out.println("dddddddddddddddddddddddd");
                 * // A row is selected, set the form accordingly
                 * patient_page.setVisible(false);
                 * fiche_form.setVisible(true);
                 * colobj.setCellValueFactory(new PropertyValueFactory<>("nom"));
                 * if (newSelection != null) {
                 * List<Objectif> objectifList = newSelection.getO(); // Initialize your list
                 * here
                 * 
                 * // Create an observable list from your objectifList
                 * ObservableList<Objectif> observableList = FXCollections
                 * .observableArrayList(objectifList);
                 * 
                 * // Set the items of the tableView to the observable list
                 * tablefiche.setItems(observableList);
                 * 
                 * }
                 * });
                 */

            } else {
                System.out.println("nullllllllllll");
            }
        }
    }

    public void onRowSelectt() {

        FicheSuivi selectedFicheSuivi = tabfichepatpage.getSelectionModel().getSelectedItem();
        fiche_form.setVisible(true);
        patient_page.setVisible(false);

        // Populate the new table with Objectifs from the selected FicheSuivi
        List<Objectif> objectifList = selectedFicheSuivi.getO();
        dataobj = FXCollections.observableArrayList(objectifList);
        tablefiche.setItems(dataobj);
        colobj.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colscore.setCellValueFactory(new PropertyValueFactory<>("note"));

    };

    public void saveChanges(ActionEvent e) {
        if (e.getSource() == mod) {
            // Update the selectedFicheSuivi with new values from the form controls
            // Example: selectedFicheSuivi.setNum(newNumValue);

            updateFicheSuiviFile();

            // refreshForm1();

            fiche_form.setVisible(false);
            patient_page.setVisible(true);
        }
    }

    public void updateFicheSuiviFile() {
        FicheSuivi selectedFicheSuivi = tabfichepatpage.getSelectionModel().getSelectedItem();
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        Set<FicheSuivi> ficheSuiviSet = loggedInOrthophonist.getPatient(ddi.getNum()).getFiche();
        ficheSuiviSet.remove(selectedFicheSuivi);
        List<Objectif> regularList = new ArrayList<>(dataobj);
        // Patient selectedPatient = patientstab.getSelectionModel().getSelectedItem();
        // Double d = loggedInOrthophonist.getPP().get(selectedPatient.getNom());

        FicheSuivi ff = new FicheSuivi(regularList, LocalDate.now(),
                loggedInOrthophonist.getPatient(ddi.getNum()).getFiche().size() + 1, att.isSelected());

        ficheSuiviSet.add(ff);
        loggedInOrthophonist.getPatient(ddi.getNum()).setFiche(ficheSuiviSet);

        // saveOrthophoniste(loggedInOrthophonist);
        management.sauvegarderUtilisateurs();
        tablefiche.getItems().clear();
        scoreText.clear();
        objarea.clear();

        // Refresh the table in form2
        onRowSelect();

    };

    public void updateSecondColumn(ActionEvent e) {
        AlertMessage alertMessage = new AlertMessage();
        if (e.getSource() == addBtnScore) {
            Objectif selectedObjectif = tablefiche.getSelectionModel().getSelectedItem();
            if (selectedObjectif != null) {
                String newContent = scoreText.getText();
                int newNote = Integer.parseInt(newContent);
                if (newNote >= 0 && newNote <= 5) {
                    selectedObjectif.setNote(newNote);
                    tablefiche.refresh(); // Refresh the table to reflect changes
                } else {
                    // Handle invalid range
                    alertMessage.errorMessg("Note should be between 0 and 5");
                    // You may display an error message to the user
                }
            }
        }
    }


    private Anam currentAnam= new Anam();
    private Map<String, QuestionA> questionMap;
    private Boinitial boin=new Boinitial(currentAnam, LocalDate.now());
    private Bo currentBo=new Bo(LocalDate.now());
    private Trouble trouble;
    private String projet;
    private String conclusion;
    private TestSimple questionnaire;

    Question reponseLibre4 = new ReponseLibre("Qu'ffffest-ce que la gravité ?", "Force qui attire les objets vers le centre de la Terre");


    private Map<Question, Integer> questionScores = new HashMap<>();

    private Question selectedQuestion;


    @FXML
    public void Enregistrer_Bo(ActionEvent event){
        currentBo.ajouterTrouble(trouble);
        currentBo.setProjetTherapeutique(projet);

        conclusion = Conclusion_test.getText();

        questionnaire.setConclusion(conclusion);

        //questionnaire.ajouterQuestion(reponseLibre4);


        currentBo.ajouterEpreuve(questionnaire);
        ddi.ajouterBo(currentBo);

        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        loggedInOrthophonist.updateDossier(ddi);
        management.sauvegarderUtilisateurs();
        BO.setVisible(false);
        maine.setVisible(true);
        loggedInOrthophonist.updateDossier(ddi);
        initialize3();
        System.out.println("doOOOOOOOOOOOe");
    }




    @FXML
    public void Add_bo(ActionEvent event ){
        boTableView.getItems().clear();

        maine.setVisible(false);
        BO.setVisible(false);
        bo_init.setVisible(false);
        initialize2();
        if (ddi.getBo().isEmpty()){
            bo_init.setVisible(true);
            System.out.println("emptyyyyyyyyyyy");
            if (ddi.getpatient() instanceof Adulte){
            currentAnam.initializeAdultAnam(); // or initializeAdultAnam based on context
        }
            else{
            currentAnam.initializeChildAnam(); // or initializeAdultAnam based on context
        }
            questionMap = new HashMap<>();
            for (Cat_Quest category : Cat_Quest.values()) {
                for (QuestionA question : currentAnam.getQuestionsForCategory(category)) {
                    questionMap.put(question.getQuestion(), question);
                }
            }
    
            ObservableList<String> questions = FXCollections.observableArrayList(questionMap.keySet());
            questionListView.setItems(questions);
    
            questionListView.setOnMouseClicked(mouseEvent -> handleQuestionSelection(mouseEvent));
        }

        else {
            BO.setVisible(true);
            ajouterQuest.setVisible(false);
            ajouterExo.setVisible(false);
            nom_quest.setVisible(false);
            okk.setVisible(false);

            System.out.println("fiiiiiiiiiiiiiiiiih");

        }
        

    }

    public void add_epreuve(){
        ajouterQuest.setVisible(true);
        ajouterExo.setVisible(true);
        nom_quest.setVisible(false);

    }

    public void new_quest(){
        nom_quest.setVisible(true);
        okk.setVisible(true);
    }
    
    @FXML
    public void ok_nom(){
        String testName = nom_quest.getText();

        questionnaire=new TestSimple(testName);
        questionnaire.initialiserTest();
        System.out.println("bieeeeen");
        displayTest();
        initialize();
        questionScores.clear();
        totalScoreLabel.setText("Total Score: 0");

    }


    private void displayTest() {
        form.getItems().clear();
        for (Question question : questionnaire.getQuestions()) {
            TextFlow questionFlow = new TextFlow();

            Text questionText = new Text(question.getEnonce() + "\n");
            questionFlow.getChildren().add(questionText);

            if (question instanceof QCU) {
                QCU qcu = (QCU) question;
                for (String proposition : qcu.getPropositions()) {
                    Text choiceText = new Text(proposition);
                    if (proposition.equals(qcu.getBonneReponse())) {
                        choiceText.setStyle("-fx-font-weight: bold");
                    }
                    questionFlow.getChildren().add(new Text("\n - "));
                    questionFlow.getChildren().add(choiceText);
                }
            } else if (question instanceof QCM) {
                QCM qcm = (QCM) question;
                for (String proposition : qcm.getPropositions()) {
                    Text choiceText = new Text(proposition);
                    if (qcm.getBonnesReponses().contains(proposition)) {
                        choiceText.setStyle("-fx-font-weight: bold");
                    }
                    questionFlow.getChildren().add(new Text("\n - "));
                    questionFlow.getChildren().add(choiceText);
                }
            } else if (question instanceof ReponseLibre) {
                ReponseLibre rl = (ReponseLibre) question;
                Text answerText = new Text("\n Réponse: " + rl.getBonneReponse());
                answerText.setStyle("-fx-font-weight: bold");
                questionFlow.getChildren().add(answerText);
            }

            form.getItems().add(questionFlow);


        }
    }


    @FXML
    public void initialize() {
        scoreComboBox.getItems().addAll(1, 2, 3,4,5,6,7,8,9,10);
        form.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                int index = form.getSelectionModel().getSelectedIndex();
                selectedQuestion = questionnaire.getQuestions().toArray(new Question[0])[index];
            }
        });


    }

    @FXML
    public void initialize2() {
        // Initialize the ComboBox with CategorieTrouble values
        categorieComboBox.setItems(FXCollections.observableArrayList(CategorieTrouble.values()));
        System.out.println("iissssss theeers");

        
    }

    @FXML
    public void handleSubmitScore() {
        if (selectedQuestion != null && scoreComboBox.getValue() != null) {
            selectedQuestion.setScore(scoreComboBox.getValue());
            updateTotalScore();
        }
    }

    private void updateTotalScore() {
        questionnaire.Calc_Score();
        totalScoreLabel.setText("Total Score: " + questionnaire.getScore());
    }

    @FXML
    private void handleAddTrouble() {
        String nom = troubleNameField.getText();
        CategorieTrouble categorie = categorieComboBox.getValue();
        System.out.println("whyyyyy");
        trouble = new Trouble(nom, categorie);
 
    }

    @FXML
    private void handleSubmitProjet() {
        projet = projetNameField.getText();
        System.out.println("donNNNNNNNNNe");

    }




    @FXML
    private void handleQuestionSelection(MouseEvent mouseEvent) {
        String selectedQuestion = questionListView.getSelectionModel().getSelectedItem();
        if (selectedQuestion != null) {
            QuestionA question = questionMap.get(selectedQuestion);
            answerTextField.setText(question.getReponse());
            System.out.println("ssssssssss");
            updateQuestionInAnamnese(question);

        }
    }

    
    @FXML
    private void handleSubmitAnswer() {
        ddi.ajouterBo(boin);
        System.out.println("addeeeeeed");
        bo_init.setVisible(false);
        maine.setVisible(true);
        if (ddi.getBo().isEmpty()){
            System.out.println("Always empty");
        }
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);

        loggedInOrthophonist.updateDossier(ddi);
        management.sauvegarderUtilisateurs();





    }

    private void updateQuestionInAnamnese(QuestionA updatedQuestion) {
        for (Map.Entry<Cat_Quest, List<QuestionA>> entry : currentAnam.getMap().entrySet()) {
            List<QuestionA> questions = entry.getValue();
            for (QuestionA question : questions) {
                if (question.equals(updatedQuestion)) {
                    question.setReponse(updatedQuestion.getReponse());
                    // Optionally, you can break out of the loop if you expect only one occurrence of the question
                    // break;
                }
            }
        }
    }


    @FXML
    private void handleBoTableClicked(MouseEvent event) {
        System.out.println("here we go again");

        Bo selectedBo = boTableView.getSelectionModel().getSelectedItem();
        System.out.println("here we go again");

        if (selectedBo != null) {
            // Affichez le Bo complet dans un autre TableView ou TextArea
            displayFullBo(selectedBo);

            System.out.println("here we go again");

        }
        else {
            System.out.println("here we gGGGGGGGGo again");
        }
    

}

private void displayFullBo(Bo bo) {
    affichage_Bo.setVisible(true);
    maine.setVisible(false);
    initialize4();
    setBoo(bo);
    
    
}


public void initialize4() {
    nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        conclusionColumn.setCellValueFactory(new PropertyValueFactory<>("conclusion"));
}

public void setBoo(Bo bo) {
    testTable.getItems().setAll(bo.getEpreuvesCliniques());
    
    if (bo instanceof Boinitial) {
        Boinitial boInitial = (Boinitial) bo;
        //anamArea.setText(boInitial.getAnam().toString());
       // anamArea.setVisible(true);
    } else {

        //anamArea.clear();
        //anamArea.setVisible(false);
        projetTherapeutiqueField.setText(bo.getProjetTherapeutique());
        afficherTroubles(bo);
        System.out.println("fff");
        afficherTest(bo);
        System.out.println("fff");


    }
}

public void afficherTest(Bo selectedBo) {
    if (selectedBo != null) {
        ObservableList<Test> tests = FXCollections.observableArrayList(selectedBo.getEpreuvesCliniques());
        testTable.setItems(tests);
    } else {
        testTable.getItems().clear();
    }
}

public void afficherTroubles(Bo bo) {
    if (bo != null) {
        StringBuilder troublesText = new StringBuilder();
        for (Trouble trouble1 : bo.getDiagnostic()) {
            String t =trouble1.getCategorie().toString();
            troublesText.append(t+" "+trouble1.getNom()).append("\n");
        }
        
        String textt=troublesText.toString();
        System.out.println(textt);
        troublesArea.setText(textt);
    } else {
        troublesArea.setText("Aucun Bo sélectionné.");
    }
}

@FXML
public void Retour(){
    affichage_Bo.setVisible(false);
    maine.setVisible(true);
}

@FXML
private void initialize3() {
    boTableView.getColumns().clear();

    if (boTableView == null) {
        System.err.println("boTableView is null");
        return;
    }

    if (ddi == null || ddi.getBo() == null) {
        System.err.println("doss1 or doss1.getBo() is null");
        return;
    }

    // Configure the TableView
    TableColumn<Bo, LocalDate> creationDateColumn = new TableColumn<>("Date de Création");
    creationDateColumn.setCellValueFactory(new PropertyValueFactory<>("crea"));
    boTableView.getColumns().add(creationDateColumn);

    // Add Bo objects to the TableView
    Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
    for (Bo bo : ddi.getBo()) {
        boTableView.getItems().add(bo);
    }


}



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // kkk
        displayName();
        Orthophoniste loggedInOrthophonist = management.getUtilisateur(Data.name);
        appointmentGenderList();
        appointmentStatusList();
        nametabatelier.setCellValueFactory(new PropertyValueFactory<>("name"));

        // Initialize the data list
        data = FXCollections.observableArrayList();
        dataobj = FXCollections.observableArrayList();
        tablefiche.setItems(dataobj);
        // Set the data list to the TableView
        tabnomatelier.setItems(data);
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        HashMap<Double, Dossier> patients = loggedInOrthophonist.getPatients();
        for (Double key : patients.keySet()) {
            Dossier dossier = patients.get(key);
            System.out.println("Dossier Key: " + key);
            System.out
                    .println("Patient Name: " + dossier.getpatient().getnom() + " " + dossier.getpatient().getprenom());
            System.out.println("Dossier Number: " + dossier.getNum());
            System.out.println("-------------------");
        }
        TreeSet<Atelier> AtelierSet = new TreeSet<>();
        for (Atelier a : AtelierSet) {
            System.out.println(a.getDate());
        }
        showAppDatainit();
        // loggedInOrthophonist.ajouterc(c);
        // management.sauvegarderUtilisateurs();
        // showAppData();
    }

    public static class Item {
        private final String name;

        public Item(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
