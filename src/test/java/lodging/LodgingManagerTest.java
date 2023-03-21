package lodging;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LodgingManagerTest {
    Address testAddress1 = new Address("8045 Newelll St", "Silver Spring", "Maryland", "20910");
    Address testAddress2 = new Address("11420 Old Frederick Rd", "Marriottsville", "Maryland", "21104");
    Address testAddress3 = new Address("8 Edmonson Ridge Rd", "Baltimore County", "Maryland", "21420");

    String testAccountNum1 = "348392830";
    String testAccountNum2 = "284039284";
    String testAccountNum3 = "390482045";
    String testReservationNum1 = "HOT73940389";
    String testReservationNum2 = "HOT660848235";
    String testReservationNum3 = "HOT680848131";
    String testReservationNum4 = "HOU367549765";
    String testReservationNum5 = "HOU660848235";
    String testReservationNum6 = "HOU680848131";
    String testReservationNum7 = "CAB367549765";
    String testReservationNum8 = "CAB660848235";
    String testReservationNum9 = "CAB680848131";
    int testNights = 4;
    int testNights2 = 3;
    int testNights3 = 8;
    int testNights4 = 2;

    int testBed = 3;
    int testBed2 = 2;
    int testBed3 = 4;
    int testBedroom = 4;
    int testBedroom2 = 3;
    int testBedroom3 = 2;

    int testSqFt = 500;
    int testSqFt2 = 1250;
    int testSqFt3 = 870;

    double testBathRoom = 3;
    double testBathRoom2 = 2;
    double testBathRoom3 = 2.5;

    Boolean testKitchenette = true;
    Boolean testKitchenette2 = false;
    Boolean testKitchen = true;
    Boolean testLoft = true;
    int testFloors = 2;
    int testFloors2 = 3;
    int testFloors3 = 5;


    public void testAddressMethod(){
        System.out.println("Data parsing");
        System.out.println(testAddress1.toString());
        System.out.println(testAddress2.toString());
        System.out.println(testAddress3.toString());
        System.out.println("");

    }


    public void testHotelResClass() throws ParseException, IOException {
        testHotelRes();
       // testHotelFile();


    }
    public void testCabinResClass() throws ParseException, IOException {
        testCabRes2();
       // testCabinFile();
    }

    public void testHouResClass() throws ParseException, IOException {

        testHOURes3();
      //  testHouFile();

    }



    public void testHotelRes() throws ParseException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println("Hotel Reservation Test");
        HotelDetail HotelTest = new HotelDetail(testKitchenette, testAddress1, testReservationNum1, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed, testSqFt, testBathRoom,
                "draft", testBedroom);
        HotelDetail HotelTest2 = new HotelDetail(!testKitchenette, testAddress2, testReservationNum2, testAccountNum2,
                testNights2, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed2, testSqFt2, testBathRoom2,
                "draft", testBedroom2);
        HotelDetail HotelTest3 = new HotelDetail(!testKitchenette, testAddress3, testReservationNum3, testAccountNum3,
                testNights3, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed3, testSqFt3, testBathRoom3,
                "draft", testBedroom3);
        System.out.println(HotelTest.toString());
        System.out.println("The price for this Hotel Reservation is $" + HotelTest.calculateTotalPrice());
        System.out.println("");

        System.out.println(HotelTest2.toString());
        System.out.println("The price for this Hotel Reservation is $" + HotelTest2.calculateTotalPrice());
        System.out.println("");


        System.out.println(HotelTest3.toString());
        System.out.println("The price for this Hotel Reservation is $" + HotelTest3.calculateTotalPrice());
        System.out.println("");


    }

    public void testHotelFile(){
        System.out.println("Setting up Hotel Path");
        HotelDetail HotelFilename = new HotelDetail("res-"+ testReservationNum1+".txt");
        System.out.println(HotelFilename.toString());
    }



    public void testCabRes2() throws ParseException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println("Cabin Reservation Test");
        CabinDetail CabinTest = new CabinDetail(testKitchen, testLoft,testAddress1, testReservationNum7, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed, testSqFt, testBathRoom,
                testBedroom, "draft");
        CabinDetail CabinTest2 = new CabinDetail(!testKitchen, !testLoft,testAddress2, testReservationNum8, testAccountNum2,
                testNights2, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed2, testSqFt2, testBathRoom2,
                testBedroom2, "draft");
        CabinDetail CabinTest3 = new CabinDetail(testKitchen, !testLoft,testAddress3, testReservationNum9, testAccountNum3,
                testNights2, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed2, testSqFt3, testBathRoom3,
                testBedroom3, "draft");

        System.out.println(CabinTest.toString());
        System.out.println("The price per night for this Cabin Reservation is $" + CabinTest.calculateTotalPrice());
        System.out.println("");

        System.out.println(CabinTest2.toString());
        System.out.println("The price per night for this Cabin Reservation is $" + CabinTest2.calculateTotalPrice());
        System.out.println("");


        System.out.println(CabinTest3.toString());
        System.out.println("The price per night for this Cabin Reservation is $" + CabinTest3.calculateTotalPrice());
        System.out.println("");


    }

    public void testCabinFile(){
        System.out.println("Setting up Cabin Path");
        CabinDetail CabinFilename = new CabinDetail("res-"+testReservationNum7+".txt");
        System.out.println(CabinFilename.toString());
    }



    public void testHOURes3() throws ParseException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/yyyy");

        System.out.println("House Reservation Test");
        HouseDetail HouseTest = new HouseDetail(testFloors, testAddress1, testReservationNum4, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed, testSqFt, testBathRoom,
                testBedroom, "draft");
        HouseDetail HouseTest2 = new HouseDetail(testFloors2, testAddress1, testReservationNum5, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed2, testSqFt2, testBathRoom2,
                testBedroom2, "draft");
        HouseDetail HouseTest3 = new HouseDetail(testFloors3, testAddress1, testReservationNum6, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed2, testSqFt3, testBathRoom3,
                testBedroom3, "draft");

        System.out.println(HouseTest.toString());
        System.out.println("The price per night for a House reservation that has "+ HouseTest.getNumberOfFloors()+ " floors, and is " + HouseTest.getSquareFootage() + "sqft" + " with " + HouseTest.getBedCount() + " beds is $" + HouseTest.calculateTotalPrice());
        System.out.println("");

        System.out.println(HouseTest2.toString());
        System.out.println("The price per night for a House reservation that has "+ HouseTest2.getNumberOfFloors()+ " floors, and is " + HouseTest2.getSquareFootage() + "sqft" + " with " + HouseTest2.getBedCount() + " beds is $" + HouseTest2.calculateTotalPrice());
        System.out.println("");


        System.out.println(HouseTest3.toString());
        System.out.println("The price per night for a House reservation that has "+ HouseTest3.getNumberOfFloors()+ " floors, and is " + HouseTest3.getSquareFootage() + "sqft" + " with " + HouseTest3.getBedCount() + " beds is $" + HouseTest3.calculateTotalPrice());
        System.out.println("");




    }

    public void testHouFile(){
        System.out.println("Setting up Path");
        HouseDetail HouseFilename = new HouseDetail("res-" +testReservationNum4+".txt" );
        System.out.println(HouseFilename.toString());

    }

    public void testAccountClass() throws IOException {
        testAccount1();
        testAccount2();
      //  testSaveAccountToFile();

    }
    private void testAccount1() throws IOException {
        System.out.println("Test Account Constructor");
        CustomerAccount testAccount1 = new CustomerAccount(testAccountNum1, testAddress1, "443-543-5634", "abc@gmail.com");
        System.out.println(testAccount1.toString());
        System.out.println("");
    }


    private void testAccount2() {
        System.out.println("IllegalLoadException Test");
        try{
            CustomerAccount testAccount = new CustomerAccount("No file");
            testAccount.toString();
        }
        catch (IllegalLoadException e){
            System.out.println("Correct IllegalLoadException Occurred:" + e.toString());
            System.out.println("");
        }
System.out.println("");
    }


    public static void main(String[] args) throws IOException, ParseException {
        LodgingManagerTest driver = new LodgingManagerTest();
        driver.testAccountClass();
        driver.testAddressMethod();;
        driver.testHotelResClass();
        driver.testHouResClass();
        driver.testCabinResClass();

        
    }





}