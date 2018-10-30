package transfer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Bank account already exists.")
public class BankAccountAlreadyExistsException extends Exception {

    public BankAccountAlreadyExistsException() {
        super("Bank account already exists.");
    }
}
