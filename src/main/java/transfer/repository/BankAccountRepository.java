package transfer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import transfer.bank.BankAccount;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
