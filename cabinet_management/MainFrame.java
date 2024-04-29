package cabinet_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public void initialize(Orthophoniste o) {
        /* Info Panel */

        JPanel InfoPanel = new JPanel();
        InfoPanel.setLayout(new GridLayout(0, 2, 5, 5));
        InfoPanel.add(new JLabel("Name"));
        InfoPanel.add(new JLabel(o.getNom()));

        InfoPanel.add(new JLabel("Family Name"));
        InfoPanel.add(new JLabel(o.getNom()));

        add(InfoPanel, BorderLayout.NORTH);

        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
