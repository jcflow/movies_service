package com.juan.movies.service;

import com.juan.movies.controller.exception.MemberNotFoundException;
import com.juan.movies.model.*;
import com.juan.movies.repository.MemberRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class MemberServiceTest {
    private MemberService memberService;

    @Test
    public void memberNotFound() throws Exception {
        // WORKAROUND: Due mockito and @TestConfiguration did not work.
        memberService = new MemberServiceImplementation();
        MemberRepository memberRepository = Mockito.mock(MemberRepository.class);
        when(memberRepository.findById(eq(-1))).thenReturn(Optional.empty());
        Field field = MemberServiceImplementation.class.getDeclaredField("memberRepository");
        field.setAccessible(true);
        field.set(memberService, memberRepository);

        Exception exception = assertThrows(MemberNotFoundException.class, () -> {
            Member member = memberService.findById(-1);
        });
    }
}
