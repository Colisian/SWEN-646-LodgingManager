package lodging;

public class IllegalOperationException extends RuntimeException{
    private String operation;
    private String accountNumber;
    private String reservationNumber;

    public IllegalOperationException(String operation, String accountId, String reservationNumber, String message) {
        super(message);
        this.operation = operation;
        this.accountNumber = accountNumber;
        this.reservationNumber = reservationNumber;
    }

    @Override
    public String toString() {
        return "IllegalOperationException{" +
                "operation='" + operation +
                ", accountId='" + accountNumber +
                ", reservationNumber='" + reservationNumber +
                ", message='" + getMessage() +
                '}';
    }

    public String getOperation() {
        return operation;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }
}

