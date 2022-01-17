package athira.sajeev.BookMyMovie.Repository;

import athira.sajeev.BookMyMovie.Entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movies,String> {
    List<Movies> findByMovieName(String movie);
}
