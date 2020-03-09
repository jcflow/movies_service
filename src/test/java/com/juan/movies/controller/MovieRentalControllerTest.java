package com.juan.movies.controller;

import com.juan.movies.helper.JsonMapper;
import com.juan.movies.model.*;
import com.juan.movies.service.MemberService;
import com.juan.movies.service.MovieRentalService;
import com.juan.movies.service.MovieService;
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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieRentalController.class)
public class MovieRentalControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieRentalService movieRentalService;
    @MockBean
    private MemberService memberService;
    @MockBean
    private MovieService movieService;

    @Test
    public void createMovieRentalWithValidData() throws Exception {
        Member member = new Member();
        member.setUsername("juan");
        member.setName("Juan");
        member.setTelephone("1234567");
        when(memberService.findById(eq(123))).thenReturn(member);

        Movie movie = new Movie();
        movie.setTitle("Blade RunnerBlade RunnerBlade RunnerBlade RunnerBlade Runner");
        movie.setYear(new Date(1997, 4, 15));
        movie.setDescription("A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.A classic sci-fi movie.");

        when(movieService.findById(eq(456))).thenReturn(movie);

        Object args = new Object() {
            public int memberId = 123;
            public int movieId = 456;
            public String date = "1997-04-15";
        };
        String uri = "/api/rental";
        String inputJson = JsonMapper.mapToJson(args);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(200, status);

        ArgumentCaptor<MovieRental> argument = ArgumentCaptor.forClass(MovieRental.class);
        verify(movieRentalService).save(argument.capture());

        assertEquals("Juan", argument.getValue().getMember().getName());
        assertEquals("Blade RunnerBlade RunnerBlade RunnerBlade RunnerBlade Runner", argument.getValue().getMovie().getTitle());
        assertEquals(97, argument.getValue().getDate().getYear());
    }
}
