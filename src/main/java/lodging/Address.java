package lodging;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode){
        //Assign values to attributes
    }


    //Create and return a copy of the object
    public Address clone() throws CloneNotSupportedException{
        Address add = new Address(this.street, this.city, this.state,this.zipCode);
        return add;
        //return new lodging.Address(this.street, this.city, this.state, this.zipCode)
        //return (Address) super.clone();
    }
    public Address(String line) throws CloneNotSupportedException{ //Creates and returns copy of object with line parameter
        street = line.substring(line.indexOf("<street>") + 8, line.indexOf("</street>"));
        city = line.substring(line.indexOf("<city>") + 6, line.indexOf("</city"));
        state = line.substring(line.indexOf("<state>") + 7, line.indexOf("</state>"));
        zipCode = line.substring(line.indexOf("<zip>") + 8, line.indexOf("</zip>"));

    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {return state;}
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString(){
        //return
        return "<address>" +
                "<street>" + street + "</street>" +
                "<city>" + city + "</city>" +
                "<state>" + state + "</state>" +
                "<zip>" + zipCode + "</zip>" +
                "</address>";
    }
}
