package com.withplant.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withplant.album.Album;
import com.withplant.member.auth.OAuthUser;
import com.withplant.member.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comt_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIgnore
    private Album album;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime rgstDate;

    private String content;

    public boolean isAuthUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!principal.equals("anonymousUser")) {
            OAuthUser user = (OAuthUser) principal;
            return this.member.getId().equals(user.getMember().getId());
        }
        return false;
    }

}
