package lodging;



import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LodgingManager {


    private List<CustomerAccount> accounts = new ArrayList<>();

    //private Vector <CustomerAccount> accounts;

    private List<ReservationDetail> lodgingReservations = new ArrayList<>();

    private String filePath = "Local Drive (C:/swen-646_LodgingManager/accounts";

    private boolean finalized;


    public LodgingManager() {

        //Validate parameters
        //assign a customerAccount to a reservation
        //create an instance of a reservation
        accounts = new Vector<CustomerAccount>();
        File dir = new File(filePath);
        if(dir.isDirectory()){
            String[] list = dir.list();
            for (String line : list) {
                CustomerAccount a = new CustomerAccount(filePath + line);
            }

            } else dir.mkdir();
        }

    public void addReservation(String accountNumber, ReservationDetail lodgingReservation) throws IllegalOperationException{

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
        throw new IllegalArgumentException("Account not found");
    }


    private boolean reservationExists(String reservationNumber) {
        for (ReservationDetail lodgingReservation : lodgingReservations) {
            if(lodgingReservation.getReservationNumber().equals(reservationNumber)){
                return true;
            }
        }
        return false;
    }

    //iterates over a list of customer accounts and looks for any repeating account based by account number
    private boolean accountExists(String accountNumber){
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public void editReservation(ReservationDetail lodgingReservation){
        //identifies a reservation by its unique number and allows parameters to be adjusted
    }
    public void finalizeReservation( String reservationNumber, String accountNumber){
        if(finalized){
            //code to finalize reservation
        }
        // identifies a single reservation based off of unique reservation number and deletes them
        try {
            // code to finalize the reservation

            if (!finalized) {
                throw new IllegalOperationException("finalize reservation", accountNumber, reservationNumber,
                        "Reservation cannot be finalized due to violation detected");
            }
        } catch (IllegalOperationException e) {
            System.out.println(e.toString());
        }
        finalized = true;
    }


    //iterates over a list of customer accounts and looks for any repeating account based by account number
    /*
    public boolean accountExists2(String accountNumber) {
        for (CustomerAccount customerAccount : accounts) {
            if (customerAccount.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
     */
    public void addAccount(CustomerAccount customer){
        // identifies a new customer account and adds it to the manager.
        //if account already exists exception is thrown
        if (accountExists(customer.getAccountNumber())){
            throw new DuplicateObjectException("Account",customer.getAccountNumber());
        }
    }


    public void saveToFile(String filename){

        //create or overwrite a file
        //iterate through each reservation made

    }

    public void openFile(String filename) throws IllegalLoadException {
        //lodging = new lodging.Reservation(filename)
        try {
            //code to open a new file
        } catch (RuntimeException e) {
            throw new IllegalLoadException("Reservation", filename, "Reservation Number");
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


    public CustomerAccount getAccount(String accountNumber){
        CustomerAccount temp = null;
        for (CustomerAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber))
                temp = account;

        }
        return temp;
    }


}