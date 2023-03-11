package lodging;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public abstract class ReservationDetail {

    protected String reservationNumber;
    protected String accountNumber;
    protected Address address;
    protected int nights;
    protected Date checkIn;

    protected Date checkOut;

    protected int bedRoomCount;

    protected int bedCount;

    protected int squareFootage;

    protected String roomStatus = "Draft";

    protected String roomType;

    protected double bathroomCount;


    //Above parameters have set and get methods so the appropriate lodging that fits the criteria of the customer can be identified
    public ReservationDetail(String reservationNumber, String accountNumber, int nights, Date checkIn, Date checkOut,
                      int bedCount, int squareFootage, double bathroomCount, int bedRoomCount, String roomStatus){

        //Calls from parent constructor in Reservation class
        //Assign values to attributes relating to common room details across all different lodging information
    }

    public static ReservationDetail loadFromFile(String fileName, String reservationNumber) throws IllegalLoadException {
        File file = new File(fileName);
        try {
            // code to load reservation from file
        } catch (RuntimeException e) {
            throw new IllegalLoadException("Account: ", "reservation.txt" + fileName, "reservation number" + reservationNumber);
        }
        return null;
    }

    public ReservationDetail(String fileName) { //Overloading
        String line;
        Scanner sc;
        try{
            sc = new Scanner(new File(fileName));
            line = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e){
            throw new IllegalLoadException("Reservation", fileName, accountNumber);
        }
    }



    //format and return object data in JSON
    public String toString(){

        return "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" +
                "<address>" + address + "</address>" +
                "<nights>" + nights + "</nights>" +
                "<checkIn>" + checkIn + "</checkIn>" +
                "<checkOut>" + checkOut + "</checkOut>" +
                "<bedRoomCount>" + bedRoomCount +"</bedRoomCount>" +
                "<bedCount>" + bedCount + "</bedCount>" +
                "<bathroomCount>" + bedRoomCount + "</bathroomCount>" +
                "<squareFootage>" + squareFootage + "</squareFootage>" +
                "<roomStatus>" + roomStatus + "</roomStatus>" ;

    };
    public float calculateBasePrice() { // Overrides in HotelDetail,HouseDetail, and CabinDetail
        //price is (120 * nights) + $15 if squareFootage is over 900 + specific calculation if it is cabin/hotel/house
        float basePrice = 120.00f;
        if(squareFootage > 900){
            basePrice += 20.00f;
        }
        return basePrice;
    }

    public float calculateTotalPrice() {
        return calculateBasePrice() * nights;
    }

    //updates the parameters of the room details that all rooms shares
    public void updateReservationDetail(ReservationDetail lodgingReservation){
        if(roomStatus.equals("draft")){
            this.accountNumber = lodgingReservation.accountNumber;
            this.reservationNumber = lodgingReservation.reservationNumber;
            this.address = lodgingReservation.address;
            this.checkIn = lodgingReservation.checkIn;
            this.checkOut = lodgingReservation.checkOut;
            this.nights = lodgingReservation.nights;
            this.bedCount = lodgingReservation.bedCount;
            this.bathroomCount = lodgingReservation.bathroomCount;
            this.squareFootage = lodgingReservation.squareFootage;
            this.roomStatus = lodgingReservation.roomStatus;

        }
    };

    //create and return copy of object

    //create and return copy of overloaded method
    public ReservationDetail clone(String line) throws CloneNotSupportedException {
        // return new lodging.RoomDetail(this.reservationNumber...)
        return (ReservationDetail) super.clone();
    }
    public int getNights() { //
        return nights;
    }
    public void setNights(int nights) {
        this.nights = nights;
        if(nights < 1){
            throw new IllegalArgumentException("Can not have less than one night");
        }
    }
    public void setCompleted(boolean b) {
    }

    public void cancelReservation() {
    }

    public void updateReservation(ReservationDetail reservation) {
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
    public Date getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }
    public Date getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
    public int getBedRoomCount() {
        return bedRoomCount;
    }
    public void setBedRoomCount(int bedRoomCount) {
        this.bedRoomCount = bedRoomCount;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public int getBedCount() {
        return bedCount;
    }
    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
        if(bedCount < 2){
            throw new IllegalArgumentException("Invalid bed value");
        }
    }
    public double getBathroomCount() {
        return bathroomCount;
    }
    public void setBathroomCount(double bathroomCount) {
        this.bathroomCount = bathroomCount;
        if (bathroomCount < 1){
            throw new IllegalArgumentException("Invalid bathroom value");
        }
    }
    public int getSquareFootage() {
        return squareFootage;
    }
    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }
    public String getRoomStatus() {
        return roomStatus;
    }
    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void saveToFile(String filename) {
    }
};






