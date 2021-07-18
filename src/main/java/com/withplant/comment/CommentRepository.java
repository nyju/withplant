package com.withplant.comment;

import com.withplant.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByAlbum(Optional<Album> itemId);

    List<Comment> findAllByAlbumId(Long itemId);
}
