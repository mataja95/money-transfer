package transfer;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BankAccountService {

    List<BankAccount> bankAccounts = Arrays.asList
            (new BankAccount(1234, 10),
                    (new BankAccount(4567, 100)),
                    (new BankAccount(7890, 500)));

    public List<BankAccount> getBankAccounts(){
        return bankAccounts;
    }

    public BankAccount getBankAccount(int number){
        return bankAccounts.stream().filter(bankAccount -> bankAccount.getNumber()==number).findFirst().get();
    }
}
