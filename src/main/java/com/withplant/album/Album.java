package com.withplant.album;

import com.withplant.attachment.Attachement;
import com.withplant.comment.Comment;
import com.withplant.member.Member;
import com.withplant.member.UserMember;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Lob
    private String content;

    private LocalDateTime rgstDate;

    private boolean isvisb;

    @ColumnDefault("0")
    private int opnCnt;

    @ColumnDefault("0")
    private int likeCnt;

    private int status;


    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Attachement> attachements = new HashSet<>();

    public void addAttachement(Attachement attachement) {
        attachement.setAlbum(this);
    }

    public void addOpnCnt() {
        this.opnCnt += 1;
    }

    public void deleteOpnCnt() {
        this.opnCnt -= 1;
    }

    public boolean isAuthUser(UserMember user) {
        return this.member.getId().equals(user.getMember().getId());
    }
}
