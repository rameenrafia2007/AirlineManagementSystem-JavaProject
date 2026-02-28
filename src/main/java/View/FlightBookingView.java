package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Model.Flight;
public class FlightBookingView extends JFrame {
    private JTable flightTable;
    private JButton bookButton;

    public FlightBookingView(){
        setTitle("Flight Booking");
        setSize(600,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Available Flights:");
        label.setBounds(20,10,200,25);
        add(label);

        flightTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setBounds(20,40,550,250);
        add(scrollPane);

        bookButton = new JButton("Book Selected Flight");
        bookButton.setBounds(200,310,200,30);
        add(bookButton);

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
    public JTable getFlightTable(){ return flightTable; }
    public JButton getBookButton(){ return bookButton; }
}
