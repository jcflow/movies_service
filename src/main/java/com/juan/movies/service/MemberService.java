package com.juan.movies.service;

import com.juan.movies.model.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    Member save(Member member);
}
