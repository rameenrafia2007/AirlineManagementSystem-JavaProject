package View;
import javax.swing.*;
import java.awt.*;
public class UserDashboardView extends JFrame {
    public JButton bookFlightButton, myBookingsButton, logoutButton;
    public JLabel welcomeLabel;
    public JButton getMyBookingsButton() {
        return myBookingsButton;
    } 
    public UserDashboardView(String username){
        setTitle("User Dashboard");
        setSize(500,400);
        setLayout(null);
        getContentPane().setBackground(new Color(224, 255, 255)); // Light cyan
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        welcomeLabel = new JLabel("Welcome, " + username);
        welcomeLabel.setBounds(150,30,300,30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(welcomeLabel);

        bookFlightButton = new JButton("Book a Flight");
        bookFlightButton.setBounds(150,100,180,40);
        bookFlightButton.setBackground(new Color(173, 216, 230));
        add(bookFlightButton);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(150,220,180,40);
        logoutButton.setBackground(new Color(255, 160, 122));
        add(logoutButton);

        setVisible(false);
    }}