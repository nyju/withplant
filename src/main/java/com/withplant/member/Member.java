package com.withplant.member;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
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


}
