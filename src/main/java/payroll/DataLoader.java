package payroll;

import com.juan.movies.model.Actor;
import com.juan.movies.model.Movie;
import com.juan.movies.model.User;
import com.juan.movies.repository.MovieRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DataLoader {
    @Autowired
    private MovieRepository repository;

    @Bean
    InitializingBean initDatabase() {
        return () -> {
            Actor actor1 = new Actor();
            User user1 = new User();
            Movie movie = new Movie();

            actor1.setName("Ryan Gosling");

            user1.setName("Juan");

            movie.setTitle("Blade Runner");
            movie.setYear(2018);
            movie.setDescription("A sci-fi movie.");
            movie.setRate("PG-13");

            movie.setRegisteringUser(user1);
            movie.setUpdatingUser(user1);
            movie.getActors().add(actor1);
            repository.save(movie);
        };
    }
}