package lodging;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CabinDetail extends ReservationDetail {

    private boolean containsKitchen; //Does the cabin contain a kitchen?
    private boolean containsLoft; //Does the cabin contain a Loft?

    public static String generateReservationNum;
    private Address address;


    public CabinDetail(boolean containsKitchen, boolean containsLoft, Address lodgingAddress, String reservationNumber, String accountNumber, int nights, Date checkIn, Date checkOut,
                       int bedCount, int squareFootage, double bathroomCount, int bedRoomCount ,String roomStatus) throws IOException, JSONException {
        super(reservationNumber, accountNumber, nights, checkIn, checkOut,
                bedCount, squareFootage, bathroomCount, bedRoomCount,roomStatus);

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to attributes
        Random random = new Random();
        int resNumber = random.nextInt(99999999);
        generateReservationNum = "CAB" + String.valueOf(resNumber);

        String accountPath = "Local Drive (C:)" + accountNumber;
        JSONObject putInFile = new JSONObject();
        putInFile.put("containsKitchen",containsKitchen);
        putInFile.put("containsLoft",containsLoft);
        putInFile.put("address",lodgingAddress);
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
        FileWriter writer = new FileWriter(accountInfo.getAbsolutePath());
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("Cabin Reservation: " + generateReservationNum);

    }

    public CabinDetail clone(){
        CabinDetail res = null;
        try {
            res = new CabinDetail(this.containsKitchen, this.containsLoft, this.address, this.reservationNumber,
                    this.accountNumber, this.nights, (Date)this.checkIn.clone(), (Date)this.checkOut.clone(), this.bedCount, this.squareFootage, this.bathroomCount,
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
        //Return cabin details in JSON format
        return "<Cabin>" + "\n" +
                "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<reservationNumber>" + reservationNumber + "</reservationNumber>" +
                "<Address>" + address + "</Address>" +
                "<checkIn>" + checkIn + "</checkIn>" +
                "<checkOut>" + checkOut + "</checkOut>" +
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
    public void updateCabin(boolean containsKitchen, boolean containsLoft, Address address){
        //validate parameters
        //Assign values to attributes
    }

    public float calculatePrice(){ //Override calculatePrice will take place here if customer chooses a cabin as their default lodging
        //Additional fee of 20 if containsKitchen is true + bathroomCount * 5
        return 0.0f;
    }
    // create and return a copy of the object


    public boolean getContainsLoft(){
        return containsLoft;
    }
    public void setContainsLoft(boolean containsLoft) {
        this.containsLoft = containsLoft;
    }

    public boolean getContainsKitchen(){
        return containsKitchen;
    }
    public void setContainsKitchen(boolean containsKitchen) {
        this.containsKitchen = containsKitchen;
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
