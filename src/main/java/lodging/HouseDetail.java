package lodging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HouseDetail extends ReservationDetail {

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
        int resNumber = random.nextInt(99999999);
        generateReservationNumber = "HOU" + String.valueOf(resNumber);

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
        BufferedWriter writer = new BufferedWriter( new FileWriter(accountInfo.getAbsolutePath()));
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("House Reservation Number: " + generateReservationNumber);
    }

    public HouseDetail(String fileName) {
        super(fileName);

        String line;
        Scanner sc;
        try{
            sc = new Scanner(new File(fileName));
            line = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e){
            throw new IllegalLoadException("House Reservation", fileName, accountNumber);
        }
        numberOfFloors = Integer.parseInt(line.substring(line.indexOf("<numberOfFloors>")+ 16, line.indexOf("</numberOfFloors>")));

    }


    public String toString(){

        //return house details in JSON format
        return "<House>" +
                "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" +
                "<Address>" + address + "</Address>" +
                "<checkIn>" + checkIn + "</checkIn>" +
                "<checkOut>" + checkOut + "</checkOut>" +
                "<bedCount>" + bedCount + "</bedCount>" +
                "<sqFt>" + squareFootage + "</sqFt>" +
                "<bathroomCount>" + bathroomCount + "</bathroomCount>" +
                "<bedroomCount>" + bedRoomCount + "</bedroomCount>" +
                "<containsKitchen>" + numberOfFloors + "</containsKitchen>" +
                "<roomStatus>" + roomStatus + "</roomStatus>" +
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
    public void setNumberOfFloors(int floors) {
        if(numberOfFloors == Integer.parseInt(null))
            throw new IllegalArgumentException("Number of floors can not be null");
        if (roomStatus.equals("draft"))
            numberOfFloors = floors;
        else
            throw new IllegalStateException("Reservation is in draft status");
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
