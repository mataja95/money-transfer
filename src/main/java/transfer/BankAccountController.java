package transfer;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BankAccountController {

    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping(path = "/add")
    public @ResponseBody
    String addBankAccount(@Valid @RequestParam Integer id,
                          @RequestParam(required = false) Float amount) {
        bankAccountService.existsBankAccount(id);

        if (amount != null) {
            bankAccountService.createBankAccount(id, amount);
        } else {
            bankAccountService.createBankAccount(id);
        }

        return "Bank account added.";
    }

    @RequestMapping("/{id}")
    public BankAccount getBankAccount(@PathVariable Integer id) {
        return bankAccountService.getBankAccount(id);
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestParam("from") Integer fromId,
                           @RequestParam("to") Integer toId,
                           @RequestParam("amount") Float amount) {

        bankAccountService.transferFunds(fromId, toId, amount);
        return "Transfer completed.";
    }
}

