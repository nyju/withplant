package com.withplant.comment;


import com.withplant.album.Album;
import com.withplant.album.AlbumRepository;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final AlbumRepository albumRepository;

    public void saveComment(Member member, CommentForm commentForm, Long itemId) {

        Comment comment = new Comment();
        comment.setContent(commentForm.getContent());
        comment.setMember(member);
        comment.setRgstDate(LocalDateTime.now());

        Optional<Album> album = albumRepository.findById(itemId);
        comment.setAlbum(album.get());
        album.get().addOpnCnt();


        commentRepository.save(comment);

    }

    //댓글 리스트
    @Transactional(readOnly = true)
    public List<Comment> Listcomment(Long itemId) {
        System.out.println("ListComment");

        Optional<Album> album = albumRepository.findById(itemId);
        List<Comment> comments = commentRepository.findAllByAlbum(album);
        return comments;
    }


    public void deletecomment(Long itemId, Long commentId) {
        commentRepository.deleteById(commentId);
        Optional<Album> album = albumRepository.findById(itemId);
        album.get().deleteOpnCnt();

    }
}
