package transfer;

public class BankAccountAlreadyExistsException extends RuntimeException {

    BankAccountAlreadyExistsException() {
        super("Bank account already exists.");
    }
}
