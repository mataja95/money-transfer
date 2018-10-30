package transfer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Bank account not found.")
public class BankAccountNotFoundException extends Exception {

    public BankAccountNotFoundException(int id) {
        super("Could not find account number " + id);
    }
}
