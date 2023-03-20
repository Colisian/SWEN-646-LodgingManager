package lodging;

public class IllegalLoadException extends RuntimeException{

    private String message;
    public IllegalLoadException(String fileType, String fileName, String idNumber){
        super("Error loading: " + fileType + " ,File: " + fileName + " for account " + idNumber);
        message = "Error loading: " + fileType + " ,File: " + fileName + " for account " + idNumber;
    }


    public String toString(){
        return "Illegal Load Exception, " + message;
    }
}
