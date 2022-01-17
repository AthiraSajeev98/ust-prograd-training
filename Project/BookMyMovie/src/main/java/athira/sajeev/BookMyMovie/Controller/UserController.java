package athira.sajeev.BookMyMovie.Controller;

import athira.sajeev.BookMyMovie.Entity.Movies;
import athira.sajeev.BookMyMovie.Entity.Tickets;
import athira.sajeev.BookMyMovie.Entity.Users;
import athira.sajeev.BookMyMovie.Service.MovieService;
import athira.sajeev.BookMyMovie.Service.TicketService;
import athira.sajeev.BookMyMovie.Service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    public TicketService ticketService;

    @Autowired
    public MovieService movieService;


    String userID;
    String movieID;

    @RequestMapping("/home")
    public String home() {
        return "/home";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/register")
    public String register() {
        return "/register";
    }

    @RequestMapping("/userProfile")
    public String userProfile() {
        return "/userProfile";
    }

    @PostMapping("/login")
    public String postLogin(Model model, HttpServletRequest request) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userService.existById(username)) {
            if (Objects.equals(userService.getUserById(username).getPassword(), password)) {
                model.addAttribute("username", userService.getUserById(username).getUserName());
                model.addAttribute("customerName", userService.getUserById(username).getName());
                model.addAttribute("age", userService.getUserById(username).getAge());
                model.addAttribute("gender", userService.getUserById(username).getGender());
                model.addAttribute("emailId", userService.getUserById(username).getEmailID());
                model.addAttribute("phoneNumber", userService.getUserById(username).getPhoneNo());
                model.addAttribute("address", userService.getUserById(username).getAddress());
                //                model.addAttribute("successMessage", "Successfully logged in");
                userID = username;
            } else {
                model.addAttribute("errorMessage", "Invalid Credentials...! Status code : 404");
                return "login";
            }
        } else {
            model.addAttribute("errorMessage", "Invalid Credentials...! Status code : 404");
            return "login";
        }
        return "userProfile";
    }

    @RequestMapping("userProfile/{userId}")
    public String displayUserById(@PathVariable String userId, Model model) {
        model.addAttribute("username", userService.getUserById(userId).getUserName());
        model.addAttribute("customerName", userService.getUserById(userId).getName());
        model.addAttribute("age", userService.getUserById(userId).getAge());
        model.addAttribute("gender", userService.getUserById(userId).getGender());
        model.addAttribute("emailId", userService.getUserById(userId).getEmailID());
        model.addAttribute("phoneNumber", userService.getUserById(userId).getPhoneNo());
        model.addAttribute("address", userService.getUserById(userId).getAddress());

        return "userProfile";
    }

    @PostMapping("/register")

    public String postRegister(Model model, HttpServletRequest request) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String customerName = request.getParameter("customerName");
        String address = request.getParameter("address");
        Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
        String emailId = request.getParameter("emailId");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");

        Users user = new Users(username, password, customerName, age, gender, emailId, address, phoneNumber);
        userService.save(user);

        model.addAttribute("successMessage", "Successfully Registered User");
        return "register";
    }

    //MovieController
    @RequestMapping("/viewMovies")
    public String viewMovies(Model model) {
        model.addAttribute("username", userID);
        return "/viewMovies";
    }

    @PostMapping("/viewMovies")
    public String viewBooking(Model model, HttpServletRequest request) {
        String movie = request.getParameter("Movie");
        List<Movies> moviesList = movieService.getMoviesByName(movie);
        model.addAttribute("moviesList", moviesList);
        model.addAttribute("username", userID);
        return "/movieSlots";
    }

    @RequestMapping("/movieSlots")
    public String movieSlots(Model model) {
        model.addAttribute("username", userID);
        System.out.println(userID);
        return "/movieSlots";
    }


    @RequestMapping("/selectSeat")
    public String selectSeat(Model model) {
        model.addAttribute("username", userID);
        model.addAttribute("availableSeats", 30 - ticketService.getTicketByMovieId(movieID).size());
        return "/selectSeat";
    }

    @PostMapping("/selectSeat")
    public String seatMapping(HttpServletRequest request, Model model) {
        model.addAttribute("username", userID);
        movieID = request.getParameter("movieId");
        model.addAttribute("availableSeats", 30 - ticketService.getTicketByMovieId(movieID).size() + " Seats available");
        return "/selectSeat";
    }

    int numberOfSeats = 0;
    String[] seatsBooked;
    String bookedSeats;


    @PostMapping("/saveTicket")
    public String saveTicket(HttpServletRequest request, Model model) {
        bookedSeats = request.getParameter("bookedSeats");
        seatsBooked = bookedSeats.split(" ");
        numberOfSeats = seatsBooked.length;
        for (String ticketID : seatsBooked) {
            if (ticketService.getTicketByTicketId(ticketID) == null
                    || !Objects.equals(ticketService.getTicketByTicketId(ticketID).getMovieId(), movieID)
                    || ticketService.getTicketByTicketId(ticketID).getMovieId() == null
                    || ((Objects.equals(ticketService.getTicketByTicketId(ticketID).getTicketId(), ticketID))
                    && (!Objects.equals(ticketService.getTicketByTicketId(ticketID).getMovieId(), movieID)))) {
                {

                }
            } else {
                model.addAttribute("availableSeats", 30 - ticketService.getTicketByMovieId(movieID).size() + " Seats available");
                model.addAttribute("errorMessage", ticketID + " is already booked ");
                return "selectSeat";
            }
        }

        model.addAttribute("numberOfSeats", numberOfSeats);
        model.addAttribute("totalAmount", numberOfSeats * 200);
        model.addAttribute("name", userService.getUserById(userID).getName());
        model.addAttribute("username", userID);
        return "/saveTicket";
    }

    @RequestMapping("/saveTicket")
    public String payment(HttpServletRequest request, Model model) {
        model.addAttribute("username", userID);
        return "/saveTicket";
    }

    @RequestMapping("/wallet")
    public String wallet(Model model) {
        model.addAttribute("username", userID);
        model.addAttribute("name", userService.getUserById(userID).getName());
        model.addAttribute("balance", userService.getUserById(userID).getWalletAccountBalance());

        return "/wallet";
    }

    @PostMapping("/wallet")
    public String walletPayment(HttpServletRequest request, Model model) {
        model.addAttribute("username", userID);
        Double addAmount = Double.parseDouble(request.getParameter("amount"));
        Users user = userService.getUserById(userID);
        user.setWalletAccountBalance(user.getWalletAccountBalance() + addAmount);
        userService.save(user);
        model.addAttribute("name", userService.getUserById(userID).getName());
        model.addAttribute("balance", userService.getUserById(userID).getWalletAccountBalance());
        return "/wallet";
    }

    @RequestMapping("/")
    public String payMovieAmount(HttpServletRequest request, Model model) {
        Double payAmount = Double.parseDouble(request.getParameter("payAmount"));
        Users user = userService.getUserById(userID);
        List<Tickets> ticket;
        if (payAmount == numberOfSeats * 200) {
            if (user.getWalletAccountBalance() >= payAmount) {

                user.setWalletAccountBalance(user.getWalletAccountBalance() - payAmount);
                userService.save(user);
                numberOfSeats = seatsBooked.length;
                for (String ticketID : seatsBooked) {
                    Tickets tickets = new Tickets(ticketID, movieID, userID);
                    Movies movie = movieService.getMovieById(movieID);
                    tickets.setMovies(movie);
                    tickets.setUsers(user);
                    ticketService.save(tickets);
                }
                ticket = (ticketService.getTicketByMovieIdAndUserId(movieID, userID));
                model.addAttribute("tickets", ticket);
                model.addAttribute("username", userID);
                model.addAttribute("message", "Payment complete, seats booked successfully");
                return "/ticketsBooked";
            } else {
                for (String ticketID : seatsBooked) {
                    Long deleteTicket = ticketService.getTicketByTicketId(ticketID).getId();
                    ticketService.deleteTicketById(deleteTicket);
                }
                model.addAttribute("errorMessage", "Insufficient Balance, add wallet balance and try again");
                model.addAttribute("username", userID);
                model.addAttribute("totalAmount", numberOfSeats * 200);
                model.addAttribute("name", userService.getUserById(userID).getName());
                return "/saveTicket";
            }
        } else {
            model.addAttribute("errorMessage", "Invalid Amount please enter the correct amount");
            model.addAttribute("username", userID);
            model.addAttribute("totalAmount", numberOfSeats * 200);
            model.addAttribute("name", userService.getUserById(userID).getName());
            return "/saveTicket";
        }
    }


    @RequestMapping("/previousBookings")
    public String previousBookings(Model model) {
        model.addAttribute("username", userID);
        List<Tickets> ticket = ticketService.getTicketsByUserId(userID);
        model.addAttribute("tickets", ticket);
        return "previousBookings";
    }

    @RequestMapping("/ticketsBooked")
    public String ticketsBooked(Model model) {
        model.addAttribute("username", userID);
        List<Tickets> ticket = ticketService.getTicketsByUserId(userID);
        model.addAttribute("tickets", ticket);
        return "ticketsBooked";
    }
}




