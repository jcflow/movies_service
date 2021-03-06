package com.juan.movies.service;

import com.juan.movies.controller.exception.MemberNotFoundException;
import com.juan.movies.model.Member;
import com.juan.movies.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImplementation implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member findById(int memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (!member.isPresent()) {
            throw new MemberNotFoundException();
        }
        return member.get();
    }
}
