package com.withplant.comment;

import com.withplant.album.Album;
import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    // CREATE
    @PostMapping("/write/{itemId}")
    public ResponseEntity<List<Comment>> writeComment(@AuthUser Member member, @PathVariable Long itemId, @RequestBody CommentForm commentForm) {
        commentService.saveComment(member, commentForm, itemId);

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }

    // READ
    @RequestMapping(value = "/list/{itemId}", method = {RequestMethod.GET})
    public ResponseEntity<List<Comment>> listComment(@PathVariable Long itemId, Model model) {
        Album item = new Album();
        item.setComments(commentService.Listcomment(itemId));

        model.addAttribute("item", item);

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);

       // return "modal :: comTable";
    }

    //UPDATE
    @PutMapping("/update/{itemId}/{commentId}")
    public ResponseEntity<List<Comment>> modifyComment(@AuthUser Member member, @PathVariable Long itemId, @PathVariable Long commentId) {

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }

    //DELETE
    @RequestMapping(value = "/delete/{itemId}/{commentId}", method = {RequestMethod.POST})
    public ResponseEntity<List<Comment>> addComment(@AuthUser Member member, @PathVariable Long itemId, @PathVariable Long commentId) {
        commentService.deletecomment(itemId, commentId);

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }
}
