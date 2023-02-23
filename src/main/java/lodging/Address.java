package lodging;

public class Address {
    private String street;
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    private String city;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    private String zipCode;
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address(String street, String city, String state, String zipCode){
        //Assign values to attributes
    }

    //format and return object's data in JSON format
    public String toString(){
        //return
        return null;
    }

    //Create and return a copy of the object
    public Address clone() throws CloneNotSupportedException{
        //return new lodging.Address(this.street, this.city, this.state, this.zipCode)
        return (Address) super.clone();
    }
    public Address clone(String line) throws CloneNotSupportedException{ //Creates and returns copy of object with line parameter
        return (Address) super.clone();
    }
}
