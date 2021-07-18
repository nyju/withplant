package com.withplant.comment;

import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/write/{itemId}")
    public ResponseEntity<List<Comment>> writeComment(@AuthUser Member member, @PathVariable Long itemId, @RequestBody CommentForm commentForm) {
        commentService.saveComment(member, commentForm, itemId);

       // System.out.println(new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED));

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }

    // READ
    @GetMapping("/list/{itemId}")
    public ResponseEntity<List<Comment>> addComment(@PathVariable Long itemId) {
        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }
}
