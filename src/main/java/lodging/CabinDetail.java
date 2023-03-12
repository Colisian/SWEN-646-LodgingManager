package lodging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CabinDetail extends ReservationDetail {

    private boolean containsKitchen; //Does the cabin contain a kitchen?
    private boolean containsLoft; //Does the cabin contain a Loft?
    public static String generateReservationNum;
    private Address address;


    public CabinDetail(boolean kitchen, boolean loft, Address logdingAddress, String reservationNum, String accountNum, int numNights, Date checkInStart, Date checkOutEnd,
                       int bedNum, int sqFt, double bathroom, int bedRoomNum ,String roomStat) throws IOException, JSONException {
        super(logdingAddress, accountNum, numNights, checkInStart, checkOutEnd, bedNum,
                sqFt, bathroom ,roomStat, bedRoomNum);

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to attributes
        Random random = new Random();
        int resNumber = random.nextInt(99999999);
        generateReservationNum = "CAB" + String.valueOf(resNumber);

        reservationNumber = generateReservationNum;
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
        containsKitchen = kitchen;
        containsLoft = loft;

        String accountPath = "Local Drive (C:)" + accountNumber;
        JSONObject putInFile = new JSONObject();
        putInFile.put("containsKitchen",containsKitchen);
        putInFile.put("containsLoft",containsLoft);
        putInFile.put("address",logdingAddress);
        putInFile.put("reservationNumber",generateReservationNum);
        putInFile.put("accountNumber",accountPath);
        putInFile.put("nights",nights);
        putInFile.put("checkIn",checkIn);
        putInFile.put("checkOut",checkOut);
        putInFile.put("bedCount",bedCount);
        putInFile.put("squareFootage",squareFootage);
        putInFile.put("bathroomCount",bathroomCount);
        putInFile.put("bedroomCount",bedRoomCount);
        putInFile.put("roomStatus",roomStatus);

        File accountInfo = new File(accountPath + "|" + generateReservationNum + ".json");
        accountInfo.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(accountInfo.getAbsolutePath()));
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("Cabin Reservation: " + generateReservationNum);

    }

    public CabinDetail clone(){
        CabinDetail res = null;
        try {
            res = new CabinDetail(this.containsKitchen, this.containsLoft, this.address, this.reservationNumber,
                    this.accountNumber, this.nights, this.checkIn, this.checkOut, this.bedCount, this.squareFootage, this.bathroomCount,
                    this.bedRoomCount, this.roomStatus);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public CabinDetail(String filename){ //Overloading method
        super(filename);

        String line;
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            line = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e){
            throw new IllegalLoadException("Cabin Reservation", filename, accountNumber);
        }
    }


    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        //Return cabin details in JSON format
        return "<Cabin>" + "\n" +
                "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" +
                "<Address>" + address + "</Address>" +
                "<checkIn>" + formatter.format(checkIn) + "</checkIn>" +
                "<checkOut>" + formatter.format(checkOut) + "</checkOut>" +
                "<bedCount>" + bedCount + "</bedCount>" +
                "<sqFt>" + squareFootage + "</sqFt>" +
                "<bathroomCount>" + bathroomCount + "</bathroomCount>" +
                "<bedroomCount>" + bedRoomCount + "</bedroomCount>" +
                "<containsKitchen>" + containsKitchen + "</containsKitchen>" +
                "<containsLoft>" + containsLoft + "</containsLoft>" +
                "<roomStatus>" + roomStatus + "</roomStatus>" +
                "</Cabin>";
    }

    //make changes to the cabin reservation
    public void updateReservation(CabinDetail lodgingReservation){
        super.updateReservation(lodgingReservation);

        this.containsLoft = lodgingReservation.containsLoft;
        this.containsKitchen = lodgingReservation.containsKitchen;
        //validate parameters
        //Assign values to attributes
    }

    public float calculateTotalPrice(){ //Override calculatePrice will take place here if customer chooses a cabin as their default lodging
        //Additional fee of 20 if containsKitchen is true + bathroomCount * 5
        float basePrice = super.calculateBasePrice();
        float pricePerBath = 5.0f;
        if (containsKitchen){
            basePrice += 15.0f;
        }
        if(bathroomCount > 1){
            basePrice = (float) (basePrice + bathroomCount * pricePerBath);
        }
        return basePrice;
    }
    // create and return a copy of the object


    public boolean getContainsLoft(){
        return containsLoft;
    }
    public void setContainsLoft(boolean loft) {
        if(roomStatus.equals("draft"));
        containsLoft = loft;
    }

    public boolean getContainsKitchen(){
        return containsKitchen;
    }
    public void setContainsKitchen(boolean kitchen) {
        if(roomStatus.equals("draft"));
        containsKitchen = kitchen;
    }
    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public static String getGenerateReservationNum() {
        return generateReservationNum;
    }
    public static void setGenerateReservationNum(String generateReservationNum) {
        CabinDetail.generateReservationNum = generateReservationNum;
    }
}
