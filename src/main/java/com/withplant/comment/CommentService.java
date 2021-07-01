package com.withplant.comment;


import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void saveComment(Member member, CommentForm commentForm, Long itemId) {

        Comment comment = new Comment();
        comment.setContent(commentForm.getContent());
        comment.setMember(member);
        comment.setRgstDate(LocalDateTime.now());
        comment.setId(itemId);

        commentRepository.save(comment);

    }


}
