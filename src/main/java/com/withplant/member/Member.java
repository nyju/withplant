package com.withplant.member;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.withplant.album.Album;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"password", "email", "joinDate", "albums"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String nickname; // 닉네임

    @Column(unique = true)
    private String email; // 이메일

    private String password; // 비밀번호

    private LocalDateTime joinDate; // 가입일

    @Lob
    @Basic(fetch = FetchType.EAGER) // varchar255사이즈보다 커질수 있기 때문에 Lob으로 설정
    private String profileImage;

    @OneToMany(mappedBy = "member")
    private List<Album> albums = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public Member(String name, String email, String password, Role role) {
        this.nickname = name;
        this.email = email;
        this.joinDate = LocalDateTime.now();
        this.password = password;
        this.role = role;
    }

    public Member update(String name, String picture) {
        this.nickname = name;
        this.profileImage = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
/*    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();*/

}
