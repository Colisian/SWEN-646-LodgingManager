package lodging;

public class DuplicateObjectException extends RuntimeException{

    private String message;

    public DuplicateObjectException(String fileType, String fileNumber){
        super( fileType + "with number" + fileNumber + "already exists");

        message = ( fileType + "with number" + fileNumber + "already exists");
    }


    @Override
    public String toString() {
        return message;
    }
}
