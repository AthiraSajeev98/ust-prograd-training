package athira.sajeev.BookMyMovie.Repository;

import athira.sajeev.BookMyMovie.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
}
