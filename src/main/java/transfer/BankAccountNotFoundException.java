package transfer;

public class BankAccountNotFoundException extends RuntimeException {

    BankAccountNotFoundException(int id) {
        super("Could not find account number " + id);
    }
}
