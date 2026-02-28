# Airline Management System-OOP Project

A desktop-based **Airline Management System** developed in **JAVA** using **Object-Oriented Programming (OOP)** principles and the **Model-View-Controller (MVC)** architecture. This system allows Admins and Passengers to manage flights, bookings, and schedules in a clean, modular, and maintainable way.

## **Features**

- **Admin Functionalities**
  - Sign up and login
  - Add new flight schedules
  - View all flights
  - Manage flight details

- **Passenger Functionalities**
  - Sign up and login
  - View available flights
  - Book flights
  - View booked flights
  - Cancel bookings

- **User Interface**
  - Developed using **Java Swing**
  - Clean and simple GUI
  - Input validation for all fields
  - Interactive dashboards for Admin and Passenger

- **Business Logic**
  - Fare calculation for each flight
  - Capacity check before booking
  - Duplicate username check for signup
  - Centralized data management in Model classes


## **Project Architecture**

- **Model**
  - Handles all data storage and business logic
  - Classes: `AirlineModel`, `Admin`, `Passenger`, `Flight`, `Booking`
  - Responsible for signup, login, flight management, and booking logic

- **View**
  - Provides GUI to interact with the system
  - Classes: `HomeView`, `AdminLoginView`, `PassengerLoginView`, `AdminDashboardView`, `UserDashboardView`, `FlightScheduleView`, `FlightBookingView`
  - Displays dashboards, forms, tables, and buttons

- **Controller**
  - Handles user events and connects Model and View
  - Class: `AirlineController`
  - Listens to button clicks, calls model methods, updates GUI accordingly

- **Main Class**
  - Class: `AirlineManagementSystem`
  - Initializes Model, View, and Controller
  - Entry point of the application


## **OOP Concepts Used**

- **Encapsulation** – All class attributes are private and accessed via getters/setters
- **Abstraction** – Business logic is hidden from GUI
- **Association** – Passenger objects linked with Flight objects via Booking
- **Polymorphism** – ActionListeners used to handle multiple button events
- **Classes & Objects** – All major components are modular classes
  

## **Technologies Used**

- **Java** – Programming language
- **Java Swing** – For graphical user interface
- **NetBeans IDE** – Development environment
- **MVC Architecture** – To separate concerns and improve maintainability


## **Project Limitations**

- No database integration – data is temporary and stored in memory
- Basic GUI design (can be enhanced further)
- Does not include real-time payment or airline APIs


## **Future Enhancements**

- Integrate a database (MySQL, SQLite) for persistent storage
- Improve GUI aesthetics with modern frameworks
- Add payment gateway integration
- Enable flight search and advanced filters
- Implement email notifications for bookings and cancellations


## **How to Run the Project**

1. Clone this repository:
   ```bash
   git clone <repository_url>
