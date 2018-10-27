package transfer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    private BankAccountRepository bankAccountRepository;

    private List<BankAccount> bankAccounts = Arrays.asList
            (new BankAccount(1234, 10),
                    (new BankAccount(4567, 100)),
                    (new BankAccount(7890, 500)));

    protected List<BankAccount> getBankAccounts(){
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccountRepository.findAll()
                .forEach(bankAccounts::add);
        return bankAccounts;
    }

    protected BankAccount getBankAccount(int id){
        return bankAccounts.stream().filter(bankAccount -> bankAccount.getId() == id).findFirst().get();
    }
    public void addBankAccount(BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }

    public void updateBankAccount(int id, BankAccount bankAccount){
        bankAccountRepository.save(bankAccount);
    }
}
