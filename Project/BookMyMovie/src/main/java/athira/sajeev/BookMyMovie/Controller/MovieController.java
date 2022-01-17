package athira.sajeev.BookMyMovie.Controller;

import athira.sajeev.BookMyMovie.Entity.Movies;
import athira.sajeev.BookMyMovie.Entity.Tickets;
import athira.sajeev.BookMyMovie.Entity.Users;
import athira.sajeev.BookMyMovie.Service.MovieService;
import athira.sajeev.BookMyMovie.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Controller
public class MovieController  {
    String movieID;

    @Autowired
    public MovieService movieService;

    @Autowired
    public TicketService ticketService;
    @RequestMapping("/viewMoviesInHome")
    public String viewMoviesInHome() {
        return "/viewMoviesInHome";
    }

    @RequestMapping("/addMovies")
    public String addMovies() {
        return "/addMovies";
    }

    @PostMapping("/addMovies")
    public String addingMovies(Model model, HttpServletRequest request) {
        String movieId = request.getParameter("movieId");
        String movieName = request.getParameter("movieName");
        Time showMovieTime =Time.valueOf(request.getParameter("showMovieTime")+":00") ;
        Date showMovieDate = Date.valueOf(request.getParameter("showMovieDate"));
        String venue = request.getParameter("venue");

       Movies movies =new Movies(movieId,movieName,showMovieTime,showMovieDate,venue);
       movieService.save(movies);

        model.addAttribute("successMessage", "Successfully added Movie");
        return "addMovies";
    }





}
