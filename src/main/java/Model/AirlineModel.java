package Model;
import java.util.*;
import java.io.*;

interface FlightOperations {
    void addFlight(Flight flight);
    void removeFlight(String flightNumber);
}
public class AirlineModel implements FlightOperations {
    private ArrayList<Passenger> passengers;
    private ArrayList<Admin> admins;
    private ArrayList<Flight> flights;

    public AirlineModel(){
        passengers = new ArrayList<>();
        admins = new ArrayList<>();
        flights = new ArrayList<>();
        loadFlights();
    }
    private void loadFlights(){
        try{
            File f = new File("flights.txt");
            if(!f.exists()) f.createNewFile();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null) {

    String[] parts = line.split(",");

    if (parts.length == 6) {

        Flight flight = new Flight(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                Integer.parseInt(parts[4]),
                Double.parseDouble(parts[5])
        );

        flights.add(flight);
    }
}
            br.close();
        }catch(Exception e){ e.printStackTrace(); }
    }

    private void saveFlights(){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("flights.txt"));
            for(Flight f : flights){
                bw.write(f.toString());
                bw.newLine();
            }
            bw.close();
        }catch(Exception e){ e.printStackTrace(); }
    }
    @Override
    public void addFlight(Flight flight){
        flights.add(flight);
        saveFlights();
    }
    @Override
    public void removeFlight(String flightNumber){
        Iterator<Flight> iterator = flights.iterator();
        while (iterator.hasNext()) {
            Flight f = iterator.next();
    if (f.getFlightNumber().equals(flightNumber)) {
        iterator.remove();
    }
}
        saveFlights();
    }
    public ArrayList<Flight> getFlights(){ 
        return flights; }

    public boolean signupPassenger(String username, String password){
        for (int i = 0; i < passengers.size(); i++) {
        Passenger p = passengers.get(i);
        if (p.getUsername().equals(username)) {
            return false;
        }
    }
        passengers.add(new Passenger(username,password));
        return true;
    }
    public boolean signupAdmin(String username, String password){
        for (int i = 0; i < admins.size(); i++) {
            Admin a = admins.get(i);
            if (a.getUsername().equals(username)) {
                return false;
    }
}
        admins.add(new Admin(username,password));
        return true;
    }

    public Passenger loginPassenger(String username, String password){
        for (int i = 0; i < passengers.size(); i++) {
        Passenger p = passengers.get(i);
        if (p.getUsername().equals(username)
                && p.getPassword().equals(password)) {
            return p;
        }
    }
        return null;
    }
    public Admin loginAdmin(String username, String password){
        for (int i = 0; i < admins.size(); i++) {
        Admin a = admins.get(i);
        if (a.getUsername().equals(username)
                && a.getPassword().equals(password)) {
            return a;
        }
    }
        return null;
    }
}