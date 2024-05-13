package cabinet_management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    private Management management;
    @FXML
    private Button login_btn;

    @FXML
    private AnchorPane login_form;

    @FXML
    private TextField login_name;

    @FXML
    private PasswordField login_password;

    @FXML
    private Hyperlink login_switch;

    @FXML
    private AnchorPane main_login_form;

    @FXML
    private TextField register_adress;

    @FXML
    private Button register_btn;

    @FXML
    private AnchorPane register_form;

    @FXML
    private TextField register_lastname;

    @FXML
    private TextField register_mail;

    @FXML
    private TextField register_name;

    @FXML
    private TextField register_num;

    @FXML
    private PasswordField register_password;

    @FXML
    private Hyperlink register_switch;
    private AlertMessage alert = new AlertMessage();

    public void registerClear() {
        register_adress.clear();
        register_name.clear();
        register_num.clear();
        register_lastname.clear();
        register_mail.clear();
        register_password.clear();

    }

    public void registerAccount() throws IOException {
        management = new Management();
        if (register_adress.getText().isEmpty() ||
                register_lastname.getText().isEmpty() ||
                register_name.getText().isEmpty() ||
                register_num.getText().isEmpty() ||

                register_mail.getText().isEmpty()

        ) {
            alert.errorMessg("all fields must be filled");
        } else {
            String name = register_name.getText();
            System.out.println(name);
            Orthophoniste authenticatedUser = management.getUser(name); // Check if user exists
            System.out.println("he");
            if (authenticatedUser != null) { // User exists

                alert.errorMessg(name + "already exists");
            } else { // User doesnt exists create a new user
                System.out.println("here");
                Orthophoniste newOrthophoniste = new Orthophoniste(name, register_lastname.getText(),
                        register_adress.getText(), register_num.getText(), register_mail.getText());
                System.out.println(name);
                management.ajouterUtilisateur(newOrthophoniste); // Add the new user
                alert.succesMessage(name + "added successfully!");
                Data.name = name;
                Data.orthophoniste = authenticatedUser;
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Clinic Management System");
                stage.setScene(new Scene(root));

                stage.show();
                register_btn.getScene().getWindow().hide();

            }
        }
    }

    public void loginAccount() throws IOException {
        management = new Management();
        if (login_name.getText().isEmpty()

        ) {
            alert.errorMessg("all fields must be filled");
        } else {
            String name = login_name.getText();
            System.out.println(name);
            Orthophoniste authenticatedUser = management.getUser(name); // Check if user exists
            System.out.println("he");
            if (authenticatedUser == null) { // User not exist

                alert.errorMessg(name + " doesn't exist");
            } else { // User exists
                System.out.println("here");

                alert.confirmationMsg(name + " Login Successful !");
                Data.name = name;
                Data.orthophoniste = authenticatedUser;
                Data.ConsultationSet = authenticatedUser.getConsultations();
                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Clinic Management System");
                stage.setScene(new Scene(root));

                stage.show();
                login_btn.getScene().getWindow().hide();

            }
        }
    }

    public void switchPage() {

    }

    public void switchForm(ActionEvent event) {
        System.out.println("ff");
        if (event.getSource() == register_switch) {
            System.err.println("e");
            login_form.setVisible(false);
            register_form.setVisible(true);
        } else {
            if (event.getSource() == login_switch) {
                System.err.println("v");

                login_form.setVisible(true);
                register_form.setVisible(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }

}
