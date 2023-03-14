package lodging;

public class IllegalLoadException extends RuntimeException{
    private String fileType;
    private String fileName;
    private String idNumber;
    private String message;
    public IllegalLoadException(String fileType, String fileName, String idNumber){
        super("Error loading: " + fileType + " ,File: " + fileName + "for account" + idNumber);
        this.fileType = fileType;
        this.fileName = fileName;
        this.idNumber = idNumber;

        message = "Error loading: " + fileType + " ,File: " + fileName + "for account" + idNumber;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String toString(){
        return "Illegal Load Exception, " + message;
    }
}
