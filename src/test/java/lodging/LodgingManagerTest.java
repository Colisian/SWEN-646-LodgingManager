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


    public void testReservationClass() throws ParseException, IOException {
        testHotelRes();
        testHotelFile();
        testCabRes2();
        testCabinFile();
        testHOURes3();
        testHouFilename();


    }



    public void testHotelRes() throws ParseException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/yyyy");

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
        System.out.println(HotelTest2.toString());
        System.out.println(HotelTest3.toString());

    }
    public void testHotelFile(){
        System.out.println("Setting up Path");
        HotelDetail HotelFilename = new HotelDetail("res-"+testReservationNum1+".txt");
        System.out.println(HotelFilename.toString());
    }

    public void testCabRes2() throws ParseException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/yyyy");

        System.out.println("Hotel Reservation Test");
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
        System.out.println(CabinTest2.toString());
        System.out.println(CabinTest3.toString());


    }
    public void testCabinFile(){
        System.out.println("Setting up Path");
        CabinDetail CabinFilename = new CabinDetail("res-"+testReservationNum7+".txt");
        System.out.println(CabinFilename.toString());
    }

    public void testHOURes3() throws ParseException, IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/yyyy");

        System.out.println("Hotel Reservation Test");
        HouseDetail HouseTest = new HouseDetail(testFloors, testAddress1, testReservationNum4, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed, testSqFt, testBathRoom,
                testBedroom, "draft");
        HouseDetail HouseTest2 = new HouseDetail(testFloors, testAddress1, testReservationNum5, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed, testSqFt, testBathRoom,
                testBedroom, "draft");
        HouseDetail HouseTest3 = new HouseDetail(testFloors, testAddress1, testReservationNum6, testAccountNum1,
                testNights, formatter.parse("01/05/2022"), formatter.parse("01/09/2022"),testBed, testSqFt, testBathRoom,
                testBedroom, "draft");

        System.out.println(HouseTest.toString());
        System.out.println(HouseTest2.toString());
        System.out.println(HouseTest3.toString());

    }

    public void testHouFilename(){
        System.out.println("Setting up Path");
        HouseDetail HouseFilename = new HouseDetail("res-" +testReservationNum4+".txt" );
        System.out.println(HouseFilename.toString());

    }

    public void testAccountClass() throws IOException {
        testAccount1();
        testAccount2();
        testAccount3();
        testSaveAccountToFile();

    }
    private void testAccount1() throws IOException {
        System.out.println("Test Account Constructor");
        CustomerAccount testAccount1 = new CustomerAccount(testAccountNum1, testAddress1, "443-543-5634", "abc@gmail.com");
        System.out.println(testAccount1.toString());
    }
    private void testAccount2() {
        System.out.println("IllegalLoadException Test");
        try{
            CustomerAccount testAccount = new CustomerAccount("No file");
            testAccount.toString();
        }
        catch (IllegalLoadException e){
            System.out.println("IllegalLoadException Occured:" + e.toString());
        }

    }

    private void testAccount3() {
    }

    private void testSaveAccountToFile() throws IOException {
        System.out.println("Save Account to File");
        CustomerAccount testAccount = new CustomerAccount(testAccountNum2, testAddress2, "443-850-3332", "oji@aol.com");
        testAccount.saveToFile("");
        System.out.println("Account file saved to directory");
    }


    public void testManager(){
        testManagerAddAccount();
    }

    private void testManagerAddAccount() {
        LodgingManager manage = new LodgingManager();
        manage.addAccount(new CustomerAccount("acc-" + testAccountNum1 + ".txt"));
        CustomerAccount temp = manage.getAccount(testAccountNum1);
        temp.toString();
    }

    public static void main(String[] args) throws IOException, ParseException {
        
        
    }





}