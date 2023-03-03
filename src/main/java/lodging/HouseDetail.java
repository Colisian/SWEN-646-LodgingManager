package lodging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class HouseDetail extends RoomDetail {

    private int numberOfFloors; // amount of floors in the house

    private String generateReservationNumber;
    private Address address;


    public HouseDetail(int numberOfFloors, Address address, String reservationNumber, String accountNumber, int nights, Date checkIn, Date checkOut,
                       int bedCount, int squareFootage, double bathroomCount, int bedRoomCount,String roomStatus) throws IOException, JSONException {
        super(reservationNumber, accountNumber, nights, checkIn, checkOut,
                bedCount, squareFootage, bathroomCount, bedRoomCount,roomStatus);

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to House specific attributes

        Random random = new Random();
        int number = random.nextInt(99999999);
        generateReservationNumber = "HOU" + String.valueOf(number);

        String accountPath = "Local Drive (C:)" + accountNumber;
        JSONObject putInFile = new JSONObject();
        putInFile.put("reservationNumber",generateReservationNumber);
        putInFile.put("accountNumber",accountPath);
        putInFile.put("numberOfFloors",numberOfFloors);
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
        FileWriter writer = new FileWriter(accountInfo.getAbsolutePath());
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("House Reservation Number: " + generateReservationNumber);
    }


    public String toString(){

        //return house details in JSON format
        return "<House>" + "\n" +
                "<accountNumber>" + accountNumber + "</accountNumber>" + "\n" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" + "\n" +
                "<Address>" + address + "</Address>" + "\n" +
                "<checkIn>" + checkIn + "</checkIn>" + "\n" +
                "<checkOut>" + checkOut + "</checkOut>" + "\n" +
                "<bedCount>" + bedCount + "</bedCount>" + "\n" +
                "<sqFt>" + squareFootage + "</sqFt>" + "\n" +
                "<bathroomCount>" + bathroomCount + "</bathroomCount>" + "\n" +
                "<bedroomCount>" + bedRoomCount + "</bedroomCount>" + "\n" +
                "<containsKitchen>" + numberOfFloors + "</containsKitchen>" + "\n" +
                "<roomStatus>" + roomStatus + "</roomStatus>" + "\n" +
                "</House>";
    }

    //edit house reservation parameters
    public void updateHouse(int numberOfFloors, Address address){

    }
    // calculate the price of the house reservation
    public float calculatePrice(){
        return 0.0f;
    }

    //create and return a copy of the object
    public HouseDetail clone() throws CloneNotSupportedException{
        HouseDetail res = null;
        try {
            res = new HouseDetail(this.numberOfFloors, this.address, this.reservationNumber,
                    this.accountNumber, this.nights, (Date)this.checkIn.clone(), (Date)this.checkOut.clone(), this.bedCount, this.squareFootage, this.bathroomCount,
                    this.bedRoomCount, this.roomStatus);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }


    public int getNumberOfFloors() {return numberOfFloors;}
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getGenerateReservationNumber() {
        return generateReservationNumber;
    }

    public void setGenerateReservationNumber(String generateReservationNumber) {
        this.generateReservationNumber = generateReservationNumber;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
