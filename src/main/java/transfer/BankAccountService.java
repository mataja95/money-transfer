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

    public void createBankAccount(int id, int amount) {
        BankAccount bankAccount = new BankAccount(id, amount);
        bankAccountRepository.save(bankAccount);
    }

    public void createBankAccount(int id) {
        BankAccount bankAccount = new BankAccount(id);
        bankAccountRepository.save(bankAccount);
    }

    public void existsBankAccount(int id) {
        if (bankAccountRepository.findById(id).isPresent()) {
            throw new BankAccountAlreadyExistsException();
        }
    }

    public void transferFunds(int fromId, int toId, float amount) {
        BankAccount fromAccount = this.getBankAccount(fromId);
        BankAccount toAccount = this.getBankAccount(toId);

        if (amount > 0 && fundsAvailable(fromAccount, amount)) {
            this.withdrawFromAccount(fromAccount, amount);
            this.depositToAccount(toAccount, amount);
        } else {
            throw new TransactionException();
        }
    }

    public boolean fundsAvailable(BankAccount bankAccount, float amount) {
        return bankAccount.getAmount() >= amount;
    }

    public BankAccount getBankAccount(@PathVariable int id) {

        return bankAccountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

    private void withdrawFromAccount(BankAccount bankAccount, float amount) {
        bankAccount.setAmount(bankAccount.getAmount() - amount);
        bankAccountRepository.save(bankAccount);
    }

    private void depositToAccount(BankAccount bankAccount, float amount) {
        bankAccount.setAmount(bankAccount.getAmount() + amount);
        bankAccountRepository.save(bankAccount);
    }
}
