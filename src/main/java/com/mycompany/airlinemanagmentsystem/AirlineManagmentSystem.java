package com.mycompany.airlinemanagmentsystem;

import Model.*;
import View.*;
import Controller.*;

public class AirlineManagmentSystem {
    public static void main(String[] args) {
        // ======= MODEL =======
        AirlineModel model = new AirlineModel();

        // ======= VIEWS =======
        HomeView homeView = new HomeView();
        AdminLoginView adminLoginView = new AdminLoginView();
        PassengerLoginView passengerLoginView = new PassengerLoginView();
        AdminDashboardView adminDashboardView = new AdminDashboardView("");
        UserDashboardView userDashboardView = new UserDashboardView("");
        FlightScheduleView flightScheduleView = new FlightScheduleView();
        FlightBookingView flightBookingView = new FlightBookingView();

        // ======= CONTROLLER =======
        new AirlineController(model, homeView, adminLoginView, passengerLoginView,
                adminDashboardView, userDashboardView, flightScheduleView, flightBookingView);

        // ======= SHOW HOME VIEW =======
        homeView.setVisible(true);
    }
}