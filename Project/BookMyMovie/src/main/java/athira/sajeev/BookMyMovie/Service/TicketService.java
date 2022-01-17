package athira.sajeev.BookMyMovie.Service;

import athira.sajeev.BookMyMovie.Entity.Tickets;
import athira.sajeev.BookMyMovie.Repository.TicketRepository;
import athira.sajeev.BookMyMovie.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Tickets> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Tickets save(Tickets tickets) {
        return ticketRepository.save(tickets);
    }

    public List<Tickets> getTicketsByUserId(String userID) {
        return ticketRepository.findByUserId(userID);
    }

    public Tickets getTicketByTicketId(String ticketID) {
        return ticketRepository.findByTicketId(ticketID);
    }

    public List<Tickets> getTicketByMovieId(String movieID) {

        return ticketRepository.findByMovieId(movieID);
    }

    public boolean ticketExistByTicketId(String ticketID) {
        return ticketRepository.existsByTicketId(ticketID);
    }

    public void deleteTicketById(Long deleteTicket) {
        ticketRepository.deleteById(deleteTicket);
    }

    public List<Tickets> getTicketByMovieIdAndUserId(String movieID, String userID) {
        return ticketRepository.findByMovieIdAndUserId(movieID,userID);
    }
}
