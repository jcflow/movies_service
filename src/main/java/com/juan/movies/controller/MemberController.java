package com.juan.movies.controller;

import com.juan.movies.model.Member;
import com.juan.movies.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/member")
    public Member newEmployee(@RequestBody Member memberRequest) {
        // Not necessary to create a member request class.
        return memberRepository.save(memberRequest);
    }
}
