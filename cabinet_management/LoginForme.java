package cabinet_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForme extends JFrame {

    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private Management management;

    public void initialize() {
        management = new Management();

        JLabel lbLoginForme = new JLabel("Login Form", SwingConstants.CENTER);

        JLabel lbEmail = new JLabel("Email");
        tfEmail = new JTextField();

        JLabel lbPassword = new JLabel("Password");
        pfPassword = new JPasswordField();

        JPanel formePanel = new JPanel();
        formePanel.setLayout(new GridLayout(0, 1, 10, 10));

        formePanel.add(lbLoginForme);
        formePanel.add(lbEmail);
        formePanel.add(tfEmail);
        formePanel.add(lbPassword);
        formePanel.add(pfPassword);

        add(formePanel, BorderLayout.NORTH);

        /************** Buttons Panel */
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = new String(pfPassword.getPassword());

                Orthophoniste authenticatedUser = management.authentifier(email); // Check if user exists

                if (authenticatedUser == null) { // User doesn't exist
                    // Create a new Orthophoniste object
                    Orthophoniste newOrthophoniste = new Orthophoniste(email);
                    management.ajouterUtilisateur(newOrthophoniste); // Add the new user
                    JOptionPane.showMessageDialog(LoginForme.this,
                            "New user added successfully.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    MainFrame mainframe = new MainFrame();
                    mainframe.initialize(newOrthophoniste);
                    dispose();

                } else { // User exists
                    JOptionPane.showMessageDialog(LoginForme.this,
                            "name or email already exists ",
                            "Try again ",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JButton btncancel = new JButton("cancel");
        btncancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btncancel);

        add(buttonsPanel, BorderLayout.SOUTH);

        /*************** Initialize the frame */

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
