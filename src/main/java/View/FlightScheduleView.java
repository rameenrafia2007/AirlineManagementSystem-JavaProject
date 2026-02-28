package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Model.Flight;

public class FlightScheduleView extends JFrame {
    private JTextField flightNumberField, departureField, arrivalField, timeField, capacityField, fareField;
    private JButton addButton;
    private JTable flightTable;

    public FlightScheduleView(){
        setTitle("Flight Schedule (Admin)");
        setSize(700,450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel fnLabel = new JLabel("Flight No:");
        fnLabel.setBounds(20,10,80,25);
        add(fnLabel);
        flightNumberField = new JTextField();
        flightNumberField.setBounds(100,10,100,25);
        add(flightNumberField);

        JLabel depLabel = new JLabel("Departure:");
        depLabel.setBounds(220,10,80,25);
        add(depLabel);
        departureField = new JTextField();
        departureField.setBounds(300,10,100,25);
        add(departureField);

        JLabel arrLabel = new JLabel("Arrival:");
        arrLabel.setBounds(420,10,80,25);
        add(arrLabel);
        arrivalField = new JTextField();
        arrivalField.setBounds(500,10,100,25);
        add(arrivalField);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(20,45,80,25);
        add(timeLabel);
        timeField = new JTextField();
        timeField.setBounds(100,45,100,25);
        add(timeField);

        JLabel capLabel = new JLabel("Capacity:");
        capLabel.setBounds(220,45,80,25);
        add(capLabel);
        capacityField = new JTextField();
        capacityField.setBounds(300,45,100,25);
        add(capacityField);

        JLabel fareLabel = new JLabel("Fare:");
        fareLabel.setBounds(420,45,80,25);
        add(fareLabel);
        fareField = new JTextField();
        fareField.setBounds(500,45,100,25);
        add(fareField);

        addButton = new JButton("Add Flight");
        addButton.setBounds(250,80,150,30);
        add(addButton);

        flightTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(20,130,650,250);
        add(scrollPane);

        setVisible(false);
    }

    public void loadFlights(ArrayList<Flight> flights){
        String[] columns = {"Flight No","Departure","Arrival","Time","Capacity","Fare"};
        DefaultTableModel model = new DefaultTableModel(columns,0);

        for(Flight f: flights){
            Object[] row = {f.getFlightNumber(), f.getDeparture(), f.getArrival(),
                            f.getTime(), f.getCapacity(), f.getFare()};
            model.addRow(row);
        }
        flightTable.setModel(model);
    }

    public String getFlightNumber(){ 
        return flightNumberField.getText(); 
    } public String getDeparture(){ 
        return departureField.getText();
    } public String getArrival(){ 
        return arrivalField.getText();
    } public String getTime(){
        return timeField.getText();
    } public int getCapacity(){
        return Integer.parseInt(capacityField.getText());
    } public double getFare(){
        return Double.parseDouble(fareField.getText());
    } public JButton getAddButton(){ return addButton; }
}