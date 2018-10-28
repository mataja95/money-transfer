package transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
class BankAccountService {

    @Autowired
    public BankAccountRepository bankAccountRepository;

    Iterable<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public void createBankAccount(int id,
                                  int amount) {
        BankAccount bankAccount = new BankAccount(id, amount);
        bankAccountRepository.save(bankAccount);
    }

    public void transferFunds(int fromId,
                              int toId,
                              float amount) {

        BankAccount fromAccount = this.getBankAccount(fromId);
        BankAccount toAccount = this.getBankAccount(toId);

        this.deductFundsFromAccount(fromAccount, amount);
        this.addFundsToAccount(toAccount, amount);
    }

    public BankAccount getBankAccount(@PathVariable int id) {
        return bankAccountRepository.findById(id).isPresent() ? bankAccountRepository.findById(id).get() : null;
    }

    private void deductFundsFromAccount(BankAccount bankAccount, float amount) {
        bankAccount.setAmount(bankAccount.getAmount() - amount);
        bankAccountRepository.save(bankAccount);
    }

    private void addFundsToAccount(BankAccount bankAccount, float amount) {
        bankAccount.setAmount(bankAccount.getAmount() + amount);
        bankAccountRepository.save(bankAccount);
    }
}
