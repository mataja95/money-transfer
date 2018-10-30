package transfer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Failed to complete transaction.")
public class TransactionException extends RuntimeException{
    public TransactionException() {
        super("Could not complete transaction.");
    }
}
