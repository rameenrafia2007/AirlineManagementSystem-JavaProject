package Model;
import java.util.ArrayList;
public class Passenger extends User {
    private ArrayList<Flight> bookedFlights;

    public Passenger(String username, String password){
        super(username,password);
        bookedFlights = new ArrayList<>();
    }
    public ArrayList<Flight> getBookedFlights(){ return bookedFlights; }
    public void addFlight(Flight flight){
        bookedFlights.add(flight);
    }
    @Override
    public void displayInfo(){
        System.out.println("Passenger: " + getUsername());
    }
}
