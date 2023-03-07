package lodging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    public boolean reservationExists(String reservationNumber){
        for (Reservation reservation : reservationList){
            if (reservation.getReservationNumber().equals(reservationNumber)) {
                return true;
            }
        } return false;
    }
    public void addReservation(Reservation lodgingReservation){
        //check if reservation exists
        if(reservationExists(lodgingReservation.getReservationNumber())){
            throw new DuplicateObjectException("Reservation", lodgingReservation.getReservationNumber());
        }
        //add reservation
    }

    public CustomerAccount(String accountName, Address address, String accountNumber,
                           String phoneNumber, String emailAddress, String reservationNumber) throws JSONException, IOException {
        //validate parameters
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        newAccountNumber = String.valueOf(number);
        String newAccountPath = filePath + "A" + newAccountNumber;
        new File(newAccountPath).mkdir();

        JSONObject putInFile = new JSONObject();
        putInFile.put("address",address);
        putInFile.put("phoneNumber",phoneNumber);
        putInFile.put("emailAddress",emailAddress);

        File accountInfo = new File(newAccountPath + "-" + "accountInfo.json");
        accountInfo.createNewFile();
        BufferedWriter writer = new BufferedWriter( new FileWriter(accountInfo.getAbsolutePath()));
        writer.write(putInFile.toString());
        writer.close();
        System.out.println("New Account created: A" + newAccountNumber);

    }

    public CustomerAccount(String line){ //Overloading method

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
        return null;
    }
    // saves customer account info to file
    public void saveToFile(String filename){

    }

    //All parameters outside of reservation number and account number can be edited at any time.
    public void editAccount(String accountName, Address address, String phoneNumber, String emailAddress){

    }

    // adds the associated reservation that a customer has made to their account
    public void addToCustomerAccount(String reservationNumber, String accountNumber){

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
