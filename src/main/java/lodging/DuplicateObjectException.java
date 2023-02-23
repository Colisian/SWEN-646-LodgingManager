package lodging;

public class DuplicateObjectException extends RuntimeException{
    private String fileType;
    private String fileNumber;
    public DuplicateObjectException(String fileType, String fileNumber){
        super( fileType + "with number" + fileNumber + "already exist");
        this.fileType = fileType;
        this.fileNumber = fileNumber;

    }

    public String getFileType(){
        return fileType;
    }
    public String getFileNumber() {
        return fileNumber;
    }
    @Override
    public String toString() {
        return "DuplicateObjectException{" + "file type= " + fileType + ", file number" + fileNumber + "}";
    }
}
