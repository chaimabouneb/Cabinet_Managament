package cabinet_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForme extends JFrame {

    private JTextField tfName;
    private JPasswordField pfPassword;
    private Management management;

    public void initialize() {
        management = new Management();

        JLabel lbLoginForme = new JLabel("Login Form", SwingConstants.CENTER);

        JLabel lbName = new JLabel("Name");
        tfName = new JTextField();

        JLabel lbPassword = new JLabel("Password");
        pfPassword = new JPasswordField();

        JPanel formePanel = new JPanel();
        formePanel.setLayout(new GridLayout(0, 1, 10, 10));

        formePanel.add(lbLoginForme);
        formePanel.add(lbName);
        formePanel.add(tfName);
        formePanel.add(lbPassword);
        formePanel.add(pfPassword);

        add(formePanel, BorderLayout.NORTH);

        /************** Buttons Panel */
        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser(); // Call the registerUser() method
            }
        });

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String password = new String(pfPassword.getPassword());

                Orthophoniste authenticatedUser = management.authentifier(name); // Check if user exists

                if (authenticatedUser == null) { // User doesn't exist
                    JOptionPane.showMessageDialog(LoginForme.this,
                            "Wrong information.",
                            "Try again ",
                            JOptionPane.ERROR_MESSAGE);
                } else { // User exists
                    JOptionPane.showMessageDialog(LoginForme.this,
                            "Welcome Back",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    MainFrame mainframe = new MainFrame();
                    mainframe.initialize(authenticatedUser);
                    dispose();
                }
            }
        });

        JButton btncancel = new JButton("cancel");
        btncancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.add(btnRegister);
        buttonsPanel.add(btncancel);

        add(buttonsPanel, BorderLayout.SOUTH);

        /*************** Initialize the frame */

        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to register a user
    private void registerUser() {
        String name = tfName.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(LoginForme.this,
                    "Field Empty",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Orthophoniste newOrthophoniste = new Orthophoniste(name);
        System.out.println(name);
        management.ajouterUtilisateur(newOrthophoniste); // Add the new user
    }
}
