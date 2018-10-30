package transfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import transfer.bank.BankAccount;
import transfer.repository.BankAccountRepository;
import transfer.exceptions.BankAccountAlreadyExistsException;
import transfer.exceptions.BankAccountNotFoundException;
import transfer.exceptions.TransactionException;

@Service
public class BankAccountService {

    @Autowired
    public BankAccountRepository bankAccountRepository;

    public Iterable<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public void createBankAccount(Integer id, Float amount) {
        BankAccount bankAccount = new BankAccount(id, amount);
        bankAccountRepository.save(bankAccount);
    }

    public void createBankAccount(Integer id) {
        BankAccount bankAccount = new BankAccount(id);
        bankAccountRepository.save(bankAccount);
    }

    public void existsBankAccount(Integer id) throws BankAccountAlreadyExistsException {
        if (bankAccountRepository.findById(id).isPresent()) {
            throw new BankAccountAlreadyExistsException();
        }
    }

    public void transferFunds(Integer fromId, Integer toId, Float amount) throws BankAccountNotFoundException {
        BankAccount fromAccount = this.getBankAccount(fromId);
        BankAccount toAccount = this.getBankAccount(toId);

        if (!fromId.equals(toId) && amount > 0 && fundsAvailable(fromAccount, amount)) {
            this.withdrawFromAccount(fromAccount, amount);
            this.depositToAccount(toAccount, amount);
        } else {
            throw new TransactionException();
        }
    }

    public boolean fundsAvailable(BankAccount bankAccount, Float amount) {
        return bankAccount.getAmount() >= amount;
    }

    public BankAccount getBankAccount(@PathVariable int id) throws BankAccountNotFoundException {

        return bankAccountRepository.findById(id).orElseThrow(() -> new BankAccountNotFoundException(id));
    }

    private void withdrawFromAccount(BankAccount bankAccount, Float amount) {
        bankAccount.setAmount(bankAccount.getAmount() - amount);
        bankAccountRepository.save(bankAccount);
    }

    private void depositToAccount(BankAccount bankAccount, Float amount) {
        bankAccount.setAmount(bankAccount.getAmount() + amount);
        bankAccountRepository.save(bankAccount);
    }
}
