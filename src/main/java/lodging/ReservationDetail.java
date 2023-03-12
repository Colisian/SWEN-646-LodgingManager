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
    protected String checkIn;

    protected String checkOut;

    protected int bedRoomCount;

    protected int bedCount;

    protected int squareFootage;

    protected String roomStatus = "Draft";

    protected String roomType;

    protected double bathroomCount;


    //Above parameters have set and get methods so the appropriate lodging that fits the criteria of the customer can be identified
    public ReservationDetail(Address logdingAddress, String accountNum, int numNights,
                             String checkInStart, String checkOutEnd, int bedNum, int sqFt, double bathroom, String roomStat, int bedRoomNum) {
        address = logdingAddress;
        accountNumber = accountNum;
        nights = numNights;
        checkIn = checkInStart;
        checkOut = checkOutEnd;
        bedCount = bedNum;
        squareFootage = sqFt;
        bedRoomCount = bedRoomNum;
        bathroomCount = bathroom;
        roomStatus = roomStat;

    }

    public ReservationDetail(String fileName) throws IllegalLoadException {
        String line;
        Scanner sc;
        try {
            sc= new Scanner(new File(fileName));
            line = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            throw new IllegalLoadException("Account: ", "reservation.txt" + fileName, "reservation number" + reservationNumber);
        }
        catch (Exception e){
            throw new IllegalLoadException("Reservation", fileName, reservationNumber);
        }
        String reservationNumberTag = line.substring(line.indexOf("<reservationNumber>") + 19, line.indexOf("</reservationNumber>"));
        String accountNumberTag = line.substring(line.indexOf("<accountNumber>") + 15, line.indexOf("</accountNumber>"));
        int nightsTag = Integer.parseInt(line.substring(line.indexOf("<nights>") + 7, line.indexOf("</nights>")));
        String checkInTag = line.substring(line.indexOf("<checkIn>") + 9, line.indexOf("</checkIn>"));
        String checkOutTag = line.substring(line.indexOf("<checkOut>") + 10, line.indexOf("</checkOut>"));
        int bedCountTag = Integer.parseInt(line.substring(line.indexOf("<bedCount>") + 10, line.indexOf("</bedCount>")));
        int squareFootageTag = Integer.parseInt(line.substring(line.indexOf("<sqFt>") + 6, line.indexOf("</sqFt>")));
        double bathroomCountTag = Double.parseDouble(line.substring(line.indexOf("<zip>") + 5, line.indexOf("</zip>")));
        String roomStatusTag = line.substring(line.indexOf("<roomStatus>") + 11, line.indexOf("</roomStatus>"));
        int bedRoomTag = Integer.parseInt(line.substring(line.indexOf("<bedRoomCount>") + 12, line.indexOf("</bedRoomCount")));

    }


    

    /*
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
 */


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
            basePrice += 15.00f;
        }
        return basePrice;
    }

    public float calculateTotalPrice() {
        return calculateBasePrice() * nights;
    }

    //updates the parameters of the room details that all rooms shares
    public void updateReservation(ReservationDetail lodgingReservation){
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
    public String getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public String getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(String checkOut) {
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






