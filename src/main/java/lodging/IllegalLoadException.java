package lodging;

public class IllegalLoadException extends RuntimeException{

    private String message;
    public IllegalLoadException(String fileName, String accountID, String error){
        super("Account# " + accountID + ": The file " + fileName + " could not be parsed. There was an issue with the " + error + " file.");;
        message = "Account# " + accountID + ": The file " + fileName + " could not be parsed. There was an issue with the " + error + " file.";
    }


    public String toString(){
        return "Illegal Load Exception, " + message;
    }
}
