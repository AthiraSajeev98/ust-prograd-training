package athira.sajeev.BookMyMovie.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Tickets {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue
    private Long id;
    private String ticketId;
    private String movieId;
    private String userId;
    private Integer availableTicket = 30;
    private double price=200;


    @ManyToOne
    private Movies movies;


    @ManyToOne
    private Users users;

    public Tickets() {
    }

    public Tickets(String ticketId, String movieId, String userId) {
        this.ticketId = ticketId;
        this.movieId = movieId;
        this.userId = userId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAvailableTicket() {
        return availableTicket;
    }

    public void setAvailableTicket(Integer availableTicket) {
        this.availableTicket = availableTicket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
