package lodging;

import org.json.JSONObject;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HotelDetail extends ReservationDetail{

    private boolean containsKitchenette; // True or false on if the BHotel room has a kitchenette

    private String generateReservationNumber;
    private Address address;


    public HotelDetail(boolean kitchenette, Address logdingAddress, String reservationNum, String accountNum, int numNights, String checkInStart, String checkOutEnd,
                       int bedNum, int sqFt, double bathroom,String roomStat, int bedRoomNum) throws IOException {
        super(logdingAddress, accountNum, numNights, checkInStart, checkOutEnd, bedNum,
                sqFt, bathroom ,roomStat, bedRoomNum);

        if(bedRoomCount > 1 || bathroomCount > 1 || bedCount != 2 ){
            throw new IllegalArgumentException("Hotels only have single bedrooom, single bathroom and two bed options");
        }

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to House specific attributes
        Random random = new Random();
        int resNumber = random.nextInt(99999999);
        generateReservationNumber = "HOT" + String.valueOf(resNumber);

        reservationNumber = generateReservationNumber;
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

        containsKitchenette = kitchenette;

        String accountPath = "Local Drive (C:\\\\swen-646_LodgingManager\\accounts" + accountNumber;
        JSONObject putInFile = new JSONObject();
        putInFile.put("reservationNumber", generateReservationNumber);
        putInFile.put("accountNumber",accountPath);
        putInFile.put("numberOfFloors",containsKitchenette);
        putInFile.put("nights",nights);
        putInFile.put("checkIn",checkIn);
        putInFile.put("checkOut",checkOut);
        putInFile.put("bedCount",bedCount);
        putInFile.put("squareFootage",squareFootage);
        putInFile.put("bathroomCount",bathroomCount);
        putInFile.put("bedroomCount",bedRoomCount);
        putInFile.put("roomStatus",roomStatus);

        File accountInfo = new File(accountPath + "|" + generateReservationNumber + ".json");
        accountInfo.createNewFile();
        BufferedWriter writer = new BufferedWriter( new FileWriter(accountInfo.getAbsolutePath()));
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("Hotel Reservation Number: " + generateReservationNumber);
    }

    public HotelDetail(String fileName){ //Overloading to parse and extract separate parameters from above constructor
        super(fileName);

        String line;
        Scanner sc;
        try {
            sc = new Scanner(new File(fileName));
            line = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            throw new IllegalLoadException(fileName, accountNumber, "Hotel Reservation");
        }
        containsKitchenette = Boolean.parseBoolean(line.substring(line.indexOf("<containsKitchenette>") + 21, line.indexOf("</containsKitchenette>")));

    }

    public String toString(){
        //return Hotel details in JSON format
        return "<Hotel>" + "\n" +
                "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" +
                "<Address>" + address + "</Address>" +
                "<checkIn>" + checkIn + "</checkIn>" +
                "<checkOut>" + checkOut + "</checkOut>" +
                "<bedCount>" + bedCount + "</bedCount>" +
                "<sqFt>" + squareFootage + "</sqFt>" +
                "<bathroomCount>" + bathroomCount + "</bathroomCount>" +
                "<bedroomCount>" + bedRoomCount + "</bedroomCount>" +
                "<containsKitchenette>" + containsKitchenette + "</containsKitchenette>" +
                "<roomStatus>" + roomStatus + "</roomStatus>" +
                "</Hotel>";
    }

    public float calculatePrice(){ //This method will Override the calculatePrice in RoomDetail if customer chooses a hotel lodging
        //Price for hotel is addition $50 from overall price with additional $10 if kitchenette is true
        return 0.0f;
    }

    //Allows changes to be made to the values passed in HotelDetails
    public void updateReservation(HotelDetail lodgingReservation){
        super.updateReservation(lodgingReservation);
            this.containsKitchenette = lodgingReservation.containsKitchenette;

    }
    //create and return a copy of the object
    public HotelDetail clone() throws CloneNotSupportedException {

        // lodging = new lodging.HotelDetail(this.containsKitchenette...)
        return (HotelDetail) super.clone();
    }
    public HotelDetail clone(String line) throws CloneNotSupportedException{
        return (HotelDetail) super.clone();
    }
    public boolean getContainsKitchenette(){
        return containsKitchenette;
    }
    public void setContainsKitchenette(boolean kitchenette) {
        if(roomStatus.equals("draft"))
            containsKitchenette = kitchenette;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
