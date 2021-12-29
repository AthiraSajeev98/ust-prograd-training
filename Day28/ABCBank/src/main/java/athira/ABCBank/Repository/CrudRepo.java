package athira.ABCBank.Repository;

import athira.ABCBank.Entity.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudRepo extends CrudRepository<Customers, Long> {
    List<Customers> findByUsernameAndPassword(String username, String password);

}
