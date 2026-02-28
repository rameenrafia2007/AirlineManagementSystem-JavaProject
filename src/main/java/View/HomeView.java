package View;
import javax.swing.*;
import java.awt.*;
public class HomeView extends JFrame {
    public JButton adminButton, userButton, aboutButton, exitButton;

    public HomeView(){
        setTitle("Welcome to Airline Management");
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 239, 245)); // Light pastel pink

        JLabel welcomeLabel = new JLabel("Welcome to Airline Management System");
        welcomeLabel.setBounds(50,50,400,50);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel);

        adminButton = new JButton("Admin");
        adminButton.setBounds(100, 150, 120, 40);
        adminButton.setBackground(new Color(255, 182, 193)); // Light pink
        add(adminButton);

        userButton = new JButton("User");
        userButton.setBounds(260, 150, 120, 40);
        userButton.setBackground(new Color(173, 216, 230)); // Light blue
        add(userButton);

        aboutButton = new JButton("About");
        aboutButton.setBounds(100, 220, 120, 40);
        aboutButton.setBackground(new Color(144, 238, 144)); // Light green
        add(aboutButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(260, 220, 120, 40);
        exitButton.setBackground(new Color(255, 160, 122)); // Light orange
        add(exitButton);

        setVisible(true);    }}