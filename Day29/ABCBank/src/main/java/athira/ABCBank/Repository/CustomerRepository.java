package athira.ABCBank.Repository;

import athira.ABCBank.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customers,String> {
    Customers findByAccountNumber(Long accountNumber);

}
