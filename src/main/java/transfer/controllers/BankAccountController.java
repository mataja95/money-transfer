package transfer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import transfer.bank.BankAccount;
import transfer.bank.BankTransferModel;
import transfer.service.BankAccountService;
import transfer.exceptions.BankAccountAlreadyExistsException;
import transfer.exceptions.BankAccountNotFoundException;
import transfer.exceptions.TransactionException;

import javax.validation.Valid;

@RestController
public class BankAccountController {

   @Autowired
    private BankAccountService bankAccountService;

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<BankAccount> getAllBankAccounts() {
        return (Iterable<BankAccount>) bankAccountService.getAllBankAccounts();
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addBankAccount(@Valid @RequestParam Integer id,
                          @RequestParam(required = false) Float amount) throws BankAccountAlreadyExistsException {
        bankAccountService.existsBankAccount(id);

        if (amount != null) {
            bankAccountService.createBankAccount(id, amount);
        } else {
            bankAccountService.createBankAccount(id);
        }

        return "Bank account added.";
    }

    @GetMapping("/account/{id}")
    public BankAccount getBankAccount(@PathVariable Integer id) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(id);
    }

    @PutMapping(path = "/transfer",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    public String transfer(@RequestBody BankTransferModel bankTransferModel) throws TransactionException, BankAccountNotFoundException {

        bankAccountService.transferFunds(bankTransferModel.getFromAccountId(), bankTransferModel.getToAccountId(), bankTransferModel.getAmount());
        return "Transfer completed.";
    }
}

