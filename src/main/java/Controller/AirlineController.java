package Controller;
import Model.*;
import View.*;
import javax.swing.*;
import java.awt.event.*;

public class AirlineController {
    private AirlineModel model;

    // Views
    private HomeView homeView;
    private AdminLoginView adminLoginView;
    private PassengerLoginView passengerLoginView;
    private AdminDashboardView adminDashboardView;
    private UserDashboardView userDashboardView;
    private FlightScheduleView flightScheduleView;
    private FlightBookingView flightBookingView;
  
    // Logged in users
    private Admin currentAdmin;
    private Passenger currentPassenger;
    public AirlineController(AirlineModel model,
                             HomeView homeView,
                             AdminLoginView adminLoginView,
                             PassengerLoginView passengerLoginView,
                             AdminDashboardView adminDashboardView,
                             UserDashboardView userDashboardView,
                             FlightScheduleView flightScheduleView,
                             FlightBookingView flightBookingView) {

        this.model = model;
        this.homeView = homeView;
        this.adminLoginView = adminLoginView;
        this.passengerLoginView = passengerLoginView;
        this.adminDashboardView = adminDashboardView;
        this.userDashboardView = userDashboardView;
        this.flightScheduleView = flightScheduleView;
        this.flightBookingView = flightBookingView;
       
        // Home page buttons
        homeView.adminButton.addActionListener(e -> {
            adminLoginView.setVisible(true);
            homeView.setVisible(false);
        });
        homeView.userButton.addActionListener(e -> {
            passengerLoginView.setVisible(true);
            homeView.setVisible(false);
        });
        homeView.aboutButton.addActionListener(e -> JOptionPane.showMessageDialog(null,
                "Airline Management System\nDeveloped in Java Swing"));
        homeView.exitButton.addActionListener(e -> System.exit(0));

        // Admin Login/Signup
        adminLoginView.getLoginButton().addActionListener(e -> loginAdmin());
        adminLoginView.getSignupButton().addActionListener(e -> signupAdmin());

        // Passenger Login/Signup
        passengerLoginView.getLoginButton().addActionListener(e -> loginPassenger());
        passengerLoginView.getSignupButton().addActionListener(e -> signupPassenger());

        // Admin Dashboard buttons
        adminDashboardView.flightScheduleButton.addActionListener(e -> {
            flightScheduleView.loadFlights(model.getFlights());
            flightScheduleView.setVisible(true);
        });
        adminDashboardView.logoutButton.addActionListener(e -> {
            adminDashboardView.setVisible(false);
            currentAdmin = null;
            homeView.setVisible(true);
        });

        // User Dashboard buttons
        userDashboardView.bookFlightButton.addActionListener(e -> {
            flightBookingView.loadFlights(model.getFlights());
            flightBookingView.setVisible(true);
        });
        userDashboardView.logoutButton.addActionListener(e -> {
            userDashboardView.setVisible(false);
            currentPassenger = null;
            homeView.setVisible(true);
        });

        // Flight schedule add button
        flightScheduleView.getAddButton().addActionListener(e -> addFlight());

        // Flight booking button
        flightBookingView.getBookButton().addActionListener(e -> bookFlight());
    }
    
    // ======================== ADMIN METHODS ========================
    private void loginAdmin() {
        String user = adminLoginView.getUsername();
        String pass = adminLoginView.getPassword();
        Admin a = model.loginAdmin(user, pass);
        if(a != null){
            JOptionPane.showMessageDialog(null,"Admin Login Successful!");
            System.out.println("[INFO] Admin Logged In: " + user);
            currentAdmin = a;
            adminDashboardView.welcomeLabel.setText("Welcome, " + user);
            adminDashboardView.setVisible(true);
            adminLoginView.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null,"Invalid Credentials!");
            System.out.println("[WARN] Admin Login Failed: " + user);
        }
    }

    private void signupAdmin() {
        String user = adminLoginView.getUsername();
        String pass = adminLoginView.getPassword();
        if(model.signupAdmin(user, pass)){
            JOptionPane.showMessageDialog(null,"Admin Signup Successful!");
            System.out.println("[INFO] Admin Signed Up: " + user);
        } else {
            JOptionPane.showMessageDialog(null,"Username already exists!");
            System.out.println("[WARN] Admin Signup Failed: " + user);
        }
    }

    // ======================== PASSENGER METHODS ========================
    private void loginPassenger() {
        String user = passengerLoginView.getUsername();
        String pass = passengerLoginView.getPassword();
        Passenger p = model.loginPassenger(user, pass);
        if(p != null){
            JOptionPane.showMessageDialog(null,"Passenger Login Successful!");
            System.out.println("[INFO] Passenger Logged In: " + user);
            currentPassenger = p;
            userDashboardView.welcomeLabel.setText("Welcome, " + user);
            userDashboardView.setVisible(true);
            passengerLoginView.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null,"Invalid Credentials!");
            System.out.println("[WARN] Passenger Login Failed: " + user);
        }
    }

    private void signupPassenger() {
        String user = passengerLoginView.getUsername();
        String pass = passengerLoginView.getPassword();
        if(model.signupPassenger(user, pass)){
            JOptionPane.showMessageDialog(null,"Passenger Signup Successful!");
            System.out.println("[INFO] Passenger Signed Up: " + user);
        } else {
            JOptionPane.showMessageDialog(null,"Username already exists!");
            System.out.println("[WARN] Passenger Signup Failed: " + user);
        }
    }

    // ======================== FLIGHT METHODS ========================
    private void addFlight() {
        try {
            String fn = flightScheduleView.getFlightNumber();
            String dep = flightScheduleView.getDeparture();
            String arr = flightScheduleView.getArrival();
            String time = flightScheduleView.getTime();
            int cap = flightScheduleView.getCapacity();
            double fare = flightScheduleView.getFare();

            Flight f = new Flight(fn, dep, arr, time, cap, fare);
            model.addFlight(f);
            flightScheduleView.loadFlights(model.getFlights());

            JOptionPane.showMessageDialog(null,"Flight Added Successfully!");
            System.out.println("[INFO] Flight Added: " + fn + ", " + dep + " -> " + arr
                    + ", Time: " + time + ", Capacity: " + cap + ", Fare: " + fare);
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Invalid input! Check all fields.");
        }
    }

    private void bookFlight() {
        int row = flightBookingView.getFlightTable().getSelectedRow();
        if(row >= 0 && currentPassenger != null){
            Flight f = model.getFlights().get(row);
            if(f.getCapacity() > 0){
                currentPassenger.addFlight(f);
                JOptionPane.showMessageDialog(null,"Flight Booked Successfully!");
                System.out.println("[INFO] " + currentPassenger.getUsername() + " booked flight: " + f.getFlightNumber());
            } else {
                JOptionPane.showMessageDialog(null,"Flight is full!");
                System.out.println("[WARN] Flight full: " + f.getFlightNumber());
            }
        } else {
            JOptionPane.showMessageDialog(null,"Select a flight first!");
        }
    }
}