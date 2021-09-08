package com.withplant.album;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByMemberId(Long id);

    List<Album> findTop5ByOrderByOpnCntDesc();

    @Modifying
    @Query("DELETE FROM Attachement WHERE album_id = ?1")
    void deleteAllAttachmentById(Long id);

}
