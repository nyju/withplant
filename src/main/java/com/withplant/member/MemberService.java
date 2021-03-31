package com.withplant.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public Member registerMember(@Valid SignUpForm signUpForm){
        System.out.println("registerMember");
        Member member = new Member();
        member.setEmail(signUpForm.getEmail());
        member.setNickname(signUpForm.getNickname());
        member.setPassword(passwordEncoder.encode(signUpForm.getPassword()));

        return memberRepository.save(member);
    }

}
