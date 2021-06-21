package com.withplant.album;

import com.withplant.attachment.Attachement;
import com.withplant.member.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue
    @Column(name = "album_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Lob
    private String content;

    private LocalDateTime rgstDate;

    private boolean isvisb;

    private int status;

    private int opnCnt;

    private int likeCnt;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Attachement> attachements = new HashSet<>();

    public void addAttachement(Attachement attachement) {
        attachement.setAlbum(this);
    }

}
