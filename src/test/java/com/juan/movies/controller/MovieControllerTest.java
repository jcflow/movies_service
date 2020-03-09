package com.juan.movies.controller;

import com.juan.movies.helper.JsonMapper;
import com.juan.movies.model.Actor;
import com.juan.movies.model.Movie;
import com.juan.movies.model.User;
import com.juan.movies.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;
    @MockBean
    private MovieCatalogService movieCatalogService;
    @MockBean
    private MovieRentalService movieRentalService;
    @MockBean
    private UserService userService;
    @MockBean
    private ActorService actorService;

    @Test
    public void getMoviesListEmpty() throws Exception {
        String uri = "/api/movies";
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Movie[] moviesList = JsonMapper.mapFromJson(content, Movie[].class);
        assertEquals(0, moviesList.length);
    }

    @Test
    public void createMovieWithValidData() throws Exception {
        User user = new User();
        user.setName("juan");
        when(userService.findByUserName(eq("juan"))).thenReturn(user);

        Actor actor1 = new Actor();
        actor1.setName("Ryan Gosling");

        Actor actor2 = new Actor();
        actor2.setName("Harrison Ford");
        when(actorService.findActorsByIds(Matchers.anyList())).thenReturn(Arrays.asList(actor1, actor2));

        Object movie = new Object() {
            public String title = "Blade RunnerBlade RunnerBlade RunnerBlade RunnerBlade Runner";
            public String year = "1997-04-15";
            public String description = "A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.";
            public String rate = "PG-13";
            public String registeringUser = "juan";
            public List<Integer> actors = Arrays.asList(1,2);
        };
        String uri = "/api/movie";
        String inputJson = JsonMapper.mapToJson(movie);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(200, status);

        ArgumentCaptor<Movie> argument = ArgumentCaptor.forClass(Movie.class);
        verify(movieService).save(argument.capture());

        assertEquals("Blade RunnerBlade RunnerBlade RunnerBlade RunnerBlade Runner", argument.getValue().getTitle());
        assertEquals(97, argument.getValue().getYear().getYear());
        assertEquals("A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.", argument.getValue().getDescription());
        assertEquals("PG-13", argument.getValue().getRate());
        assertEquals("juan", argument.getValue().getRegisteringUser().getName());
        assertEquals(2, argument.getValue().getActors().size());
    }
}