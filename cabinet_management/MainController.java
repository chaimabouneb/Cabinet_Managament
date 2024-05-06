package cabinet_management;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {
    @FXML
    private Button app_btn;

    @FXML
    private TableColumn<?, ?> app_date;

    @FXML
    private TableColumn<?, ?> app_dure;

    @FXML
    private AnchorPane app_form;

    @FXML
    private TableColumn<?, ?> app_patient;

    @FXML
    private AnchorPane dash_form;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Label nav_name;

    @FXML
    private TableColumn<?, ?> patient_id;

    @FXML
    private TableColumn<?, ?> patient_name;

    @FXML
    private Button patients_btn;

    @FXML
    private AnchorPane patients_form;

    @FXML
    private Button profil_btn;

    @FXML
    private Label window_name;

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
                    patients_form.setVisible(false);
                    app_form.setVisible(true);
                }
            }
        }
    }

    public void displayName() {
        String name = Data.name;
        nav_name.setText(name);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // kkk
        displayName();
    }
}
