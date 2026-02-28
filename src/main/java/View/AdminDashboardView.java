package View;
import javax.swing.*;
import java.awt.*;
public class AdminDashboardView extends JFrame {
    public JButton flightScheduleButton, logoutButton;
    public JLabel welcomeLabel;
    
    public AdminDashboardView(String username){
        setTitle("Admin Dashboard");
        setSize(500,300);
        setLayout(null);
        getContentPane().setBackground(new Color(255, 250, 205)); // Light yellow
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setBounds(150,30,300,30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel);

        flightScheduleButton = new JButton("Flight Schedule");
        flightScheduleButton.setBounds(150,100,180,40);
        flightScheduleButton.setBackground(new Color(173, 216, 230));
        add(flightScheduleButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(150,160,180,40);
        logoutButton.setBackground(new Color(255, 160, 122));
        add(logoutButton);

        setVisible(false); }}