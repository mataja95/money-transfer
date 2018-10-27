package transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping("/transfer")
    public BankAccount account(@RequestParam(value="from", defaultValue="1234") int fromAccount,
                               @RequestParam(value="to", defaultValue="4567") int toAccount,
                               @RequestParam(value="amount", defaultValue="100") float amount) {
        return new BankAccount(fromAccount, amount);
    }

    @RequestMapping("/bank-accounts")
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getBankAccounts();
    }

    @RequestMapping("/bank-accounts/{number}")
    public BankAccount getBankAccount(@PathVariable int id) {
        return bankAccountService.getBankAccount(id);
    }
}

