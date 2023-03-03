package lodging;

import java.util.Date;

public class HotelDetail extends RoomDetail{

    private boolean containsKitchenette; // True or false on if the BHotel room has a kitchenette

    private Address address;


    public HotelDetail(boolean containsKitchenette, Address address, String reservationNumber, String accountNumber, int nights, Date checkIn, Date checkOut,
                       int bedCount, int squareFootage, double bathroomCount,String roomStatus, String roomType, int bedRoomCount){
        super(reservationNumber, accountNumber, nights, checkIn, checkOut,
                bedCount, squareFootage, bathroomCount, bedRoomCount ,roomStatus);

        if(bedRoomCount > 1 || bathroomCount > 1 || bedCount != 2){
            throw new IllegalArgumentException("Hotels only have single bedrooom, single bathroom and two bed options");
        }

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to House specific attributes
    }

    public HotelDetail(String line){ //Overloading to parse and extract separate parameters from above constructor
        super(line);

    }

    public String toString(){
        //return Hotel details in JSON format
        return null;
    }

    public float calculatePrice(){ //This method will Override the calculatePrice in RoomDetail if customer chooses a hotel lodging
        //Price for hotel is addition $50 from overall price with additional $10 if kitchenette is true
        return 0.0f;
    }

    //Allows changes to be made to the values passed in HotelDetails
    public void updateHotel(boolean containsKitchenette, Address address){

    }
    //create and return a copy of the object
    public HotelDetail clone() throws CloneNotSupportedException {

        // lodging = new lodging.HotelDetail(this.containsKitchenette...)
        return (HotelDetail) super.clone();
    }
    public HotelDetail clone(String line) throws CloneNotSupportedException{
        return (HotelDetail) super.clone();
    }
    public boolean getContainsKitchenette(){
        return containsKitchenette;
    }
    public void setContainsKitchenette(boolean containsKitchenette) {
        this.containsKitchenette = containsKitchenette;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
