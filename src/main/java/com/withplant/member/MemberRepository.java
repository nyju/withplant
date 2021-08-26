package com.withplant.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface MemberRepository extends JpaRepository<Member, Long> {
    
    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    // Member findByEmail(String email);

    Optional<Member> findByEmail(String email);

}
