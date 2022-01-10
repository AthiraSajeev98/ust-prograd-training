package athira.ABCBank.Repository;

import athira.ABCBank.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByAccountNumber(String accountNumber);
}