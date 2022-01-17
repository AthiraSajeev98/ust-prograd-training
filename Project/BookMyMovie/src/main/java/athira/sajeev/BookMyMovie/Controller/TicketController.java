package athira.sajeev.BookMyMovie.Controller;

import athira.sajeev.BookMyMovie.Service.MovieService;
import athira.sajeev.BookMyMovie.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    @Autowired
    public TicketService ticketService;

    @Autowired
    public MovieService movieService;
}
