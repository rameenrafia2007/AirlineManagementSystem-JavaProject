package Model;
public class Flight {
    private String flightNumber;
    private String departure;
    private String arrival;
    private String time;
    private int capacity;
    private double fare;

    public Flight(String flightNumber, String departure, String arrival, String time, int capacity, double fare){
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.time = time;
        this.capacity = capacity;
        this.fare = fare;
    } public String getFlightNumber(){ 
        return flightNumber;
    } public String getDeparture(){
        return departure;
    } public String getArrival(){ 
        return arrival;
    } public String getTime(){
        return time;
    } public int getCapacity(){ 
        return capacity;
    } public double getFare(){ 
        return fare; 
    }
    @Override
    public String toString(){
        return flightNumber + "," + departure + "," + arrival + "," + time + "," + capacity + "," + fare;
    }
}