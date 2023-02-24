package lodging;

import java.util.Date;

public class CabinDetail extends RoomDetail {

    private boolean containsKitchen; //Does the cabin contain a kitchen?

    private boolean containsLoft; //Does the cabin contain a Loft?
    private Address address;


    public CabinDetail(boolean containsKitchen, boolean containsLoft, Address address, String reservationNumber, String accountNumber, int nights, Date checkIn, Date checkOut,
                       int bedCount, int squareFootage, double bathroomCount, int bedRoomCount ,String roomStatus, String roomType){
        super(reservationNumber, accountNumber, nights, checkIn, checkOut,
                bedCount, squareFootage, bathroomCount, bedRoomCount,roomStatus, roomType);

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to attributes
    }

    public CabinDetail(String line){ //Overloading method
        super(line);
    }


    public String toString(){
        //Return cabin details in JSON format
        return null;
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
    public CabinDetail clone() throws CloneNotSupportedException{
        //new lodging.CabinReservation(this.containsKitchen, ...)
        return (CabinDetail) super.clone();
    }
    public CabinDetail clone(String line) throws CloneNotSupportedException{
        return (CabinDetail) super.clone(line);
    }

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
}
