package lodging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HouseDetail extends ReservationDetail {

    private int numberOfFloors; // amount of floors in the house

    private Address address;


    public HouseDetail(int numFloors, Address logdingAddress, String generateReservationNumber,String accountNum, int numNights, Date checkInStart, Date checkOutEnd,
                       int bedNum, int sqFt, double bathroom, int bedRoomNum,String roomStat) throws IOException, JSONException {
        super(logdingAddress, accountNum, numNights, checkInStart, checkOutEnd, bedNum,
                sqFt, bathroom ,roomStat, bedRoomNum);

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to House specific attributes

        //Random random = new Random();
        //int resNumber = random.nextInt(99999999);
        //generateReservationNumber = "HOU" + String.valueOf(resNumber);

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
        numberOfFloors = numFloors;

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

        //File accountInfo = new File(accountPath + "|" + generateReservationNumber + ".json");
        //accountInfo.createNewFile();
        //BufferedWriter writer = new BufferedWriter( new FileWriter(accountInfo.getAbsolutePath()));
        //writer.write(putInFile.toString());
        //writer.close();
        //System.out.println("House Reservation Number: " + generateReservationNumber);
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
       int numberOfFloorsTag = Integer.parseInt(line.substring(line.indexOf("<numberOfFloors>")+ 16, line.indexOf("</numberOfFloors>")));

    }


    public String toString(){

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        //return house details in JSON format
        return "<House>" +
                "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" +
                "<Address>" + address + "</Address>" +
                "<checkIn>" + formatter.format(checkIn) + "</checkIn>" +
                "<checkOut>" + formatter.format(checkOut) + "</checkOut>" +
                "<bedCount>" + bedCount + "</bedCount>" +
                "<sqFt>" + squareFootage + "</sqFt>" +
                "<bathroomCount>" + bathroomCount + "</bathroomCount>" +
                "<bedroomCount>" + bedRoomCount + "</bedroomCount>" +
                "<containsKitchen>" + numberOfFloors + "</containsKitchen>" +
                "<roomStatus>" + roomStatus + "</roomStatus>" +
                "</House>";
    }

    //edit house reservation parameters
    public void updateReservation(HouseDetail lodgingReservation){
        super.updateReservation(lodgingReservation);
        this.numberOfFloors = lodgingReservation.numberOfFloors;

    }
    // calculate the price of the house reservation
    public float calculateBasePrice(){
        return super.calculateBasePrice();
    }

    //create and return a copy of the object
    public HouseDetail clone(){
        HouseDetail res = null;
        try {
            res = new HouseDetail(this.numberOfFloors, this.address, this.reservationNumber,
                    this.accountNumber, this.nights, this.checkIn, this.checkOut, this.bedCount, this.squareFootage, this.bathroomCount,
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


    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
