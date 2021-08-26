package com.withplant.config.auth;

import com.withplant.member.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class OAuthUser extends User implements OAuth2User { // UserDetails를 구현하는 User 클래스를 상속

    private Map<String, Object> attributes;
    private Member member;

    public OAuthUser(Member member) {
        super(member.getNickname(), member.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.member = member;
    }

    public OAuthUser(Member member, Map<String, Object> attributes) {

        super(member.getNickname(), member.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.member = member;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
            this.attributes.put("name", this.getName());
        }
        return attributes;
    }

    @Override
    public String getName() {
        return member.getNickname();
    }
}