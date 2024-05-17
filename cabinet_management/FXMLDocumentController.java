package cabinet_management;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private Management management = new Management();

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
        if (register_adress.getText().isEmpty() || register_lastname.getText().isEmpty() ||
                register_name.getText().isEmpty() || register_num.getText().isEmpty() ||
                register_password.getText().isEmpty() || register_mail.getText().isEmpty()) {
            alert.errorMessg("All fields must be filled.");
        } else {
            String name = register_name.getText();
            String pass = register_password.getText();

            if (management.getUtilisateur(name) != null) {
                alert.errorMessg(name + " already exists.");
            } else {
                Orthophoniste newOrthophoniste = new Orthophoniste(name, register_lastname.getText(),
                        register_adress.getText(), register_num.getText(), register_mail.getText(), pass);

                management.ajouterUtilisateur(newOrthophoniste);
                alert.succesMessage(name + " added successfully!");

                Data.name = name;
                Data.orthophoniste = newOrthophoniste;

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
        if (login_name.getText().isEmpty() || login_password.getText().isEmpty()) {
            alert.errorMessg("All fields must be filled.");
        } else {
            try {
                Orthophoniste authOrth = management.authentifier(login_name.getText(), login_password.getText());
                alert.confirmationMsg(authOrth.getNom() + " Login Successful!");
                Data.name = authOrth.getNom();
                Data.orthophoniste = authOrth;

                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Clinic Management System");
                stage.setScene(new Scene(root));
                stage.show();
                login_btn.getScene().getWindow().hide();
            } catch (Management.PassIncorrectException | Orthophoniste.PassIncorrectException e) {
                alert.errorMessg(e.getMessage());
            }
        }
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == register_switch) {
            login_form.setVisible(false);
            register_form.setVisible(true);
        } else if (event.getSource() == login_switch) {
            login_form.setVisible(true);
            register_form.setVisible(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Any initialization if needed
    }
}
