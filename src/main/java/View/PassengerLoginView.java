package View;
import javax.swing.*;
public class PassengerLoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signupButton;

    public PassengerLoginView(){
        setTitle("Passenger Login/Signup");
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel uLabel = new JLabel("Username:");
        uLabel.setBounds(50,30,80,25);
        add(uLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150,30,150,25);
        add(usernameField);

        JLabel pLabel = new JLabel("Password:");
        pLabel.setBounds(50,70,80,25);
        add(pLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(50,120,100,25);
        add(loginButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(200,120,100,25);
        add(signupButton);

        setVisible(true);
    }

    public String getUsername(){
        return usernameField.getText(); }
    public String getPassword(){ 
        return new String(passwordField.getPassword()); }
    public JButton getLoginButton(){ 
        return loginButton; }
    public JButton getSignupButton(){ 
        return signupButton; }
}