package athira.sajeev.BookMyMovie.Service;

import athira.sajeev.BookMyMovie.Entity.Movies;
import athira.sajeev.BookMyMovie.Repository.MovieRepository;
import athira.sajeev.BookMyMovie.Repository.UserRepository;
import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired()
    public MovieRepository movieRepository;

    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movies save(Movies movies) {
        return movieRepository.save(movies);
    }

    public Movies getMovieById(String movieId) {
        return movieRepository.findById(movieId).get();
    }

    public List<Movies> getMoviesByName(String movie) {
        return movieRepository.findByMovieName(movie);

    }

}
