package lodging;



import java.util.ArrayList;
import java.util.List;

public class LodgingManager {

    private List<CustomerAccount> customerAccounts = new ArrayList<>();

    private List<Reservation> lodgingReservations = new ArrayList<>();



    private Reservation lodgingReservation;

    private boolean finalized;

    private CustomerAccount customer;

    public LodgingManager(CustomerAccount customer, Reservation lodgingReservation) {

        //Validate parameters
        //assign a customerAccount to a reservation
        //create an instance of a reservation

    }
    public void addReservation(Reservation lodgingReservation) throws IllegalOperationException{

        //add reservation to the lodging manager
        //Call lodging.addReservation(reservation)

        if(reservationExists(lodgingReservation.getReservationNumber())){
            throw new DuplicateObjectException("Reservation", lodgingReservation.getReservationNumber());
        }
    }


    private boolean reservationExists(String reservationNumber) {
        for (Reservation lodgingReservation : lodgingReservations) {
            if(lodgingReservation.getReservationNumber().equals(reservationNumber)){
                return true;
            }
        }
        return false;
    }

    public void editReservation(Reservation lodgingReservation){
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
    public boolean accountExists(String accountNumber) {
        for (CustomerAccount customerAccount : customerAccounts) {
            if (customerAccount.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
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
    public CustomerAccount getCustomer() {
        return customer;
    }
    public void setCustomer(CustomerAccount customer) { // Set method to change
        this.customer = customer;
    }
}