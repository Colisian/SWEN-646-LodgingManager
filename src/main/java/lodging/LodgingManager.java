package lodging;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static com.sun.tools.javac.code.Lint.LintCategory.PATH;

public class LodgingManager {


    private List<CustomerAccount> accounts = new ArrayList<>();

    //private Vector <CustomerAccount> accounts;

    private List<ReservationDetail> lodgingReservations = new ArrayList<>();

    private String filePath = "Local Drive C:/swen-646_LodgingManager/accounts";

    private boolean finalized;


    public LodgingManager() {

        //Validate parameters
        //assign a customerAccount to a reservation
        //create an instance of a reservation
        accounts = new ArrayList<CustomerAccount>();
        File dir = new File(filePath);
        if(dir.isDirectory()){
            String[] list = dir.list();
            assert list != null;
            for (String line : list) {
                CustomerAccount a = new CustomerAccount(filePath + line);
            }

            } else dir.mkdir();
        }

    public void addReservation(String accountNumber, ReservationDetail lodgingReservation) throws IllegalOperationException{
        if(!accountExists(accountNumber)){
            throw new IllegalArgumentException("Account not found");
        }
        //add reservation to the lodging manager
        //Call lodging.addReservation(reservation)
        for (CustomerAccount account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.hasReservation(lodgingReservation.getReservationNumber())) {
                    throw new DuplicateObjectException("Reservation", lodgingReservation.getReservationNumber());

                } else {
                    account.addReservation(lodgingReservation);
                }
                return;
                }
            }
    }

    //iterates over a list of customer accounts and looks for any repeating account based by account number
    private boolean reservationExists(String reservationNumber) {
        for (ReservationDetail lodgingReservation : lodgingReservations) {
            if(lodgingReservation.getReservationNumber().equals(reservationNumber)){
                return true;
            }
        }
        return false;
    }


//Checks if the specific account number exists throughout the list of available numbers
//Used enhanced for loop sense design constraints had no mention of maximizing preformance

    public void updateReservation(String accountNumber, ReservationDetail lodgingReservation){
        boolean accountFound = accountExists(accountNumber);
        //identifies a reservation by its unique number and allows parameters to be adjusted
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.updateReservation(lodgingReservation);
                return;
            }

        }
        if (!accountFound)
            throw new IllegalArgumentException("Account number:" + accountNumber + " does not exist");
    }


    public void finalizeReservation( String accountNumber, ReservationDetail lodgingReservation){
        //Loop through reservations in array of CustomerAccount objects.
        // When finds a matching account
        boolean accountFound = accountExists(accountNumber);
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                account.finalizeReservation(lodgingReservation.getReservationNumber());
            accountFound = true;
        } if(!accountFound)
            throw new IllegalArgumentException("Can not finalize this reservation for account " + accountNumber);

    }

    private boolean accountExists(String accountNumber){
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public CustomerAccount getAccount(String accountNumber){
        CustomerAccount acc = null;
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                acc = account;

        }
        return acc;
    }

    public void addAccount(CustomerAccount account){
        // identifies a new customer account and adds it to the manager.
        //if account already exists exception is thrown
        for (CustomerAccount customerAccount : accounts) {
            if (customerAccount.getAccountNumber().equals(account.getAccountNumber())) {
                throw new DuplicateObjectException("Manager", account.getAccountNumber());
            }
        }
        accounts.add(account);
    }

    public float calculateBasePrice(String accountNumber, String reservationNumber){
        float price = 0.0f;
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                price = account.calculateReservationsPrice(reservationNumber);

        }
        return price;
    }

    public float calculateAllReservationsPrice(String accountNumber, String reservationNumber){
        float price = 0.0f;
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))

                price = account.calculateAllReservationPrice(reservationNumber);

        }
        return price;
    }


    public void saveToFile(String accountNumber){

        //create or overwrite a file
        //iterate through each reservation made
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.saveToFile(PATH + "\\" + accountNumber);

                File file = new File(PATH + "\\" + accountNumber);
                if (!file.isDirectory())
                    file.mkdir();
            }
            if (!accountExists(accountNumber)) {
                throw new IllegalArgumentException("Can not find an account with number: " + accountNumber);
            }
        }

    }


    public LodgingManager(String filename){ //Overloading method to call parameters relating to file management

    }
    public boolean getFinalized() {return finalized;}

    public void setFinalized(boolean finalized) {this.finalized = finalized;}

    public List<CustomerAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CustomerAccount> accounts) {
        this.accounts = accounts;
    }





}