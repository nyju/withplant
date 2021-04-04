package com.withplant.member;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;


@Getter // 시큐리티에서 다루는 유저정보와 도메인에서 다루는 유저정보 사이의 갭을 위한 클래스
public class UserMember extends User { // UserDetails를 구현하는 User 클래스를 상속

    private Member member;

    public UserMember(Member member) {
        super(member.getNickname(), member.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.member = member;
    }
}
