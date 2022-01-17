package athira.sajeev.BookMyMovie.Repository;

import athira.sajeev.BookMyMovie.Entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Tickets,Long> {
    List<Tickets> findByUserId(String userID);

    Tickets findByTicketId(String ticketID);

    List<Tickets> findByMovieId(String movieID);


    boolean existsByTicketId(String ticketID);

    List<Tickets> findByMovieIdAndUserId(String movieID, String userID);
}
