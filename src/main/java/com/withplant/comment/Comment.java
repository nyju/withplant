package com.withplant.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withplant.album.Album;
import com.withplant.member.Member;
import com.withplant.member.UserMember;
import lombok.Getter;
import lombok.Setter;

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

    public boolean isAuthUser(UserMember user) {
        return this.member.getId().equals(user.getMember().getId());
    }

}
