package transfer;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(path = "/bank-accounts")
    public @ResponseBody
    Iterable<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping(path = "/bank-accounts/add")
    public @ResponseBody
    String addBankAccount(@Valid @RequestParam int id,
                          @RequestParam(required = false) Integer amount) {
        bankAccountService.existsBankAccount(id);

        if (amount != null) {
            bankAccountService.createBankAccount(id, amount);
        } else {
            bankAccountService.createBankAccount(id);
        }

        return "Bank account added.";
    }

    @RequestMapping("/bank-accounts/{id}")
    public BankAccount getBankAccount(@PathVariable int id) {
        return bankAccountService.getBankAccount(id);
    }

    @RequestMapping("/bank-accounts/transfer")
    public String transfer(@RequestParam("from") int fromId,
                           @RequestParam("to") int toId,
                           @RequestParam("amount") float amount) {

        bankAccountService.transferFunds(fromId, toId, amount);
        return "Transfer completed.";
    }
}

