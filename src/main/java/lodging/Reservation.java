package lodging;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public abstract class Reservation implements Cloneable {

    public Reservation(String line) { //Overloading

    }
    protected String reservationNumber;
    protected String accountNumber;

    protected float basePrice = 120.00f;

    public Reservation(String reservationNumber, String accountNumber){

    }

    public Reservation() {

    }

    //format and return object's data in JSON format
    public String toString(){

        return null;
    }

    //calculate and return total price of the reservation
    public float calculateBasePrice(){
        return 0.0f;
    }

    public static Reservation loadFromFile(String fileName, String reservationNumber) throws IllegalLoadException {
        File file = new File(fileName);
        try {
            // code to load reservation from file
        } catch (RuntimeException e) {
            throw new IllegalLoadException("Account: ", "reservation.txt" + fileName, "reservation number" + reservationNumber);
        }
        return null;
    }

    // save reservation number and associated account number to a file.
    public void saveToFile(String fileName){

    }

    //adds the reservation details to the associated customer account
    public void addToCustomerAccount(String reservationNumber, String accountNumber){

    }

    public void addRoomDetails(RoomDetail roomDetail){

    }

    // find matching room details and edit their parameters
    public void updateRoomDetails(RoomDetail roomDetails){

    }
    public Reservation clone() throws CloneNotSupportedException{ //overrides in subclasses
        return (Reservation) super.clone();
    }
    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCompleted(boolean b) {
    }

    public void cancelReservation() {
    }

    public void updateReservation(Reservation reservation) {
    }

    public float calculateTotalPrice() {
        return 0.0f;
    }
}
