package transfer;

public class AccountNotFoundException extends RuntimeException {

    AccountNotFoundException(int id) {
        super("Could not find account number " + id);
    }
}
