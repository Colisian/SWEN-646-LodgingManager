package lodging;

import java.io.*;
import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

public class CustomerAccount {
    private String accountName;

    private Address address;

    private String accountNumber;

    private String newAccountNumber;

    private String phoneNumber;

    private String emailAddress;

    private String reservationNumber;

    private final  String filePath = "Local Disk (C:)";

    private List<Reservation> reservationList = new ArrayList<>();

    //Checks each reservation that is associated with the customer account


    public CustomerAccount(String accountName, String accountNumber, Address mailingAddress,
                           String phoneNumber, String email, String reservationNumber) throws JSONException, IOException {
        //validate parameters
        //Generate account number
        Random rnd = new Random();
        int number = rnd.nextInt(999999999);
        newAccountNumber = String.valueOf(number);
        String generateAccountNumber = filePath + "A" + newAccountNumber;
        new File(generateAccountNumber).mkdir();

        JSONObject putInFile = new JSONObject();
        putInFile.put("address",address);
        putInFile.put("phoneNumber",phoneNumber);
        putInFile.put("emailAddress",emailAddress);

        File accountInfo = new File(generateAccountNumber + "-" + "accountInfo.json");
        accountInfo.createNewFile();
        BufferedWriter writer = new BufferedWriter( new FileWriter(accountInfo.getAbsolutePath()));
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("New Account created: A" + newAccountNumber);

        this.accountNumber = accountNumber;
        this.address = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.emailAddress = email;
        this.reservationList = new Vector<Reservation>();

    }

    public CustomerAccount(String directoryPath){ //Overloading method
        try {
            reservationList = new ArrayList<Reservation>();
            File reservation;
            File dir = new File(directoryPath);
            String [] reservationFiles = null;
            String reservationFile;
            String reservationRoomType;
            File[] reservationDirectory = dir.listFiles();

            for(int i = 0; i < reservationDirectory.length; i++){
                dir = reservationDirectory[i];
                if(dir.isDirectory()){
                    reservation = dir;
                    reservationFiles = reservation.list();

                    for (int j = 0 ; j < reservationFiles.length; j++){
                        reservationFile = reservationFiles[j];
                        reservationRoomType = reservationFile.substring(0,3);
                        if(reservationRoomType.equals("HOU")){
                            reservationList.add((Reservation) new HouseDetail(reservationFile));
                        }
                        else if(reservationRoomType.equals("HOT")){
                            reservationList.add((Reservation) new HotelDetail(reservationFile));
                        }

                        else {
                            reservationList.add((Reservation) new CabinDetail(reservationFile));
                        }
                    }
                }
            }
            //String line;
           // Scanner sc = new Scanner(new File(directoryPath));
            //line = sc.nextLine();
            //sc.close();

            //int accountNameOpenTagPos = line.indexOf("<>")
        } catch (Exception e) {
            throw new IllegalLoadException(directoryPath, accountName, "Account ID");
        }

    }

    public static CustomerAccount loadFromFile(String fileName, String accountNumber) throws IllegalLoadException {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new IllegalLoadException("Account", "accounts.json", "account number");
        }
        return null;
    }

    public String toString(){
        return "<account>" +
                "<accountNumber>" + accountNumber + "</accountNumber>" +
                "<emailAddress>" + emailAddress + "</emailAddress>" +
                "<phoneNumber>" + phoneNumber + "</phoneNumber>" +
                "<Address>" + address + "</address>" +
                "</account>";
    }
    // saves customer account info to file
    public void saveToFile(String filename){
        PrintWriter save = null;
        try {
            save = new PrintWriter(filename + "acc-" +  accountNumber + ".json");

            save.println(toString());

            for (int i = 0; i<reservationList.size();i++){
                reservationList.get(i).saveToFile(filename);
            }
            save.close();
        } catch (Exception e){
            System.out.println(("Error saving"));
            if (save !=null) save.close();
        }
    }

    //All parameters outside of reservation number and account number can be edited at any time.
    public void editAccount(CustomerAccount customerAccount){
        this.accountName = customerAccount.accountName;
        this.emailAddress = customerAccount.emailAddress;
        this.address = customerAccount.address;
        this.reservationList = customerAccount.reservationList;

    }

    public boolean reservationExists(String reservationNumber){
        for (Reservation reservation : reservationList){
            if (reservation.getReservationNumber().equals(reservationNumber)) {
                return true;
            }
        } return false;
    }
    public void addReservation(Reservation lodgingReservation){
        //check if reservation exists
        for(int i = 0;i< reservationList.size(); i++)
            if(reservationExists(lodgingReservation.getReservationNumber())){
            throw new DuplicateObjectException("Reservation", lodgingReservation.getReservationNumber());
        }
        reservationList.add(lodgingReservation);
        //add reservation
    }

    // adds the associated reservation that a customer has made to their account
    public void completeReservation(String reservationNumber){
        boolean reservationFound = reservationExists(reservationNumber);
        if (reservationFound){

            for (Reservation reservation : reservationList){
                if (reservation.getReservationNumber().equals(reservationNumber)){
                    reservation.setCompleted(true);
                    System.out.println("Reservation" + reservationNumber + "Ha been Completed");
                }
            }
        }
        throw new IllegalArgumentException("Reservation " + reservationNumber + " has not been completed");
    }

    public void cancelReservation(String reservationNumber) throws IllegalOperationException {
        if (reservationExists(reservationNumber)) {
            for (int i = 0; i < reservationList.size(); i++)
                if (reservationList.get(i).getReservationNumber().equals(reservationNumber)) {
                    reservationList.get(i).cancelReservation();
                }
        } else{
            throw new IllegalArgumentException("Reservation with number: " + reservationNumber + "can not be cancelled");
        }
    }

    public Reservation getReservation(String reservationNumber) {
        Reservation res = null;

        for (int i = 0; i < reservationList.size(); i++) {
            if (reservationList.get(i).getReservationNumber().equals(reservationNumber)) {
                res = reservationList.get(i);
            } else return res;
        }
        return res;
    }

    public void updateReservation(Reservation reservation){
        if(reservationExists(reservationNumber)){
            for (int i = 0; i < reservationList.size(); i++) {
                if(reservationList.get(i).getReservationNumber().equals(reservation.getReservationNumber())){
                    reservationList.get(i).updateReservation(reservation);
                }

            }
        } else {
            throw new IllegalArgumentException("Can not Update Reservation: " + reservationNumber);
        }
    }

    public float calculateReservationsPrice(String reservationNumber){
        float price = Float.parseFloat(null);
        if(reservationExists(reservationNumber)){
            for (int i = 0; i < reservationList.size(); i++) {
                price = reservationList.get(i).calculateTotalPrice();

            }
        } else throw new IllegalArgumentException("Reservation Prices can not be calculated");
        return price;
    }

    public CustomerAccount clone() throws CloneNotSupportedException{
        //return copy of the object
        //lodging = new lodging.CustomerAccount(this.accountNumber...)
        return (CustomerAccount) super.clone();
    }
    public CustomerAccount clone(String line) throws CloneNotSupportedException{
        return (CustomerAccount) super.clone();
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {

        if(address == null)
            throw new IllegalArgumentException("Address can not be null");
        else
            this.address = address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress){
        if(emailAddress == null)
            throw new IllegalArgumentException("This can not be null");
        else
            this.emailAddress = emailAddress;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
    public String getReservationNumber() {
        return reservationNumber;
    }

    public String getNewAccountNumber() {
        return newAccountNumber;
    }
    public String getFilePath() {
        return filePath;
    }
    public List<Reservation> getReservationList() {
        return reservationList;
    }
    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
