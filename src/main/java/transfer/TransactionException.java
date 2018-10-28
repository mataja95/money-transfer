package transfer;

public class TransactionException extends RuntimeException{
    TransactionException() {
        super("Could not complete transaction.");
    }
}
