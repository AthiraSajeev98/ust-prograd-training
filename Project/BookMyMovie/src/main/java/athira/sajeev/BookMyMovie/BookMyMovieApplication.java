package athira.sajeev.BookMyMovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyMovieApplication.class, args);
		System.out.println("BookMyMovieApplication Running...!");
	}

}

//- Login/Logout/Register
//- Movies timings. date/time of available shows
//- show seat map for booking (already booked seats should be unavailable for selection)
//- appropriate final amount calculation
//- success screen
//- list of bookings made