package com.juan.movies.service;

import com.juan.movies.model.Member;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MemberService {
    Member save(Member member);

    Member findById(int memberId);
}
