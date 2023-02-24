package lodging;

import java.util.Date;

public class HouseDetail extends RoomDetail {

    private int numberOfFloors; // amount of floors in the house
    private Address address;


    public HouseDetail(int numberOfFloors, Address address, String reservationNumber, String accountNumber, int nights, Date checkIn, Date checkOut,
                       int bedCount, int squareFootage, double bathroomCount, int bedRoomCount,String roomStatus, String roomType){
        super(reservationNumber, accountNumber, nights, checkIn, checkOut,
                bedCount, squareFootage, bathroomCount, bedRoomCount,roomStatus, roomType);

        //call parent constructor from RoomDetail
        //Validate parameters
        //Assign values to House specific attributes
    }

    public HouseDetail(String line){ //Overload method
        super(line);

    }

    public String toString(){

        //return house details in JSON format
        return null;
    }

    //edit house reservation parameters
    public void updateHouse(int numberOfFloors, Address address){

    }
    // calculate the price of the house reservation
    public float calculatePrice(){
        return 0.0f;
    }

    //create and return a copy of the object
    public HouseDetail clone() throws CloneNotSupportedException{
        //lodging = new lodging.HouseDetail(this.numberOfFloors...)
        return (HouseDetail) super.clone();
    }
    public HouseDetail clone(String line) throws CloneNotSupportedException{
        return (HouseDetail) super.clone(line);
    }

    public int getNumberOfFloors() {return numberOfFloors;}
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
