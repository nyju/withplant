package com.withplant.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByMemberId(Long id);
}
