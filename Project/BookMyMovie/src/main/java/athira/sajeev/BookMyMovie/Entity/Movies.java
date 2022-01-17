package athira.sajeev.BookMyMovie.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
public class Movies {

    @Id
    @Column(nullable = false, unique = true)
    private String movieId;
    @Column(nullable = false)
    private String movieName;
    @Column(nullable = false)
    private Time showMovieTime;
    @Column(nullable = false)
    private Date showMovieDate;
    @Column(nullable = false)
    private String venue;

    @JsonIgnore
    @OneToMany(mappedBy = "movies")
    private List<Tickets> tickets;

    public Movies() {
    }

    public Movies(String movieId, String movieName, Time showMovieTime, Date showMovieDate, String venue) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showMovieTime = showMovieTime;
        this.showMovieDate = showMovieDate;
        this.venue = venue;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Time getShowMovieTime() {
        return showMovieTime;
    }

    public void setShowMovieTime(Time showMovieTime) {
        this.showMovieTime = showMovieTime;
    }

    public Date getShowMovieDate() {
        return showMovieDate;
    }

    public void setShowMovieDate(Date showMovieDate) {
        this.showMovieDate = showMovieDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Tickets> getTickets() {
        return tickets;
    }

    public void setTickets(List<Tickets> tickets) {
        this.tickets = tickets;
    }

    public void addTickets(Tickets tickets) {
        this.tickets.add(tickets);
    }
}
