package com.withplant.comment;

import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/write/{itemId}")
    public ResponseEntity<List<Comment>> writeComment(@AuthUser Member member, @PathVariable Long itemId, @RequestBody CommentForm commentForm) {

        System.out.println(commentForm.getContent());
        System.out.println(itemId);

        commentService.saveComment(member, commentForm, itemId);

       return null;
    }
}
