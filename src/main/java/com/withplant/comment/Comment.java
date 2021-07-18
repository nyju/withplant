package com.withplant.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.withplant.album.Album;
import com.withplant.member.Member;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime rgstDate;

    private String content;



}
