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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @ResponseBody
    @RequestMapping(value= "/write/{itemId}", method = {RequestMethod.POST})
    public ResponseEntity<List<Comment>> writeComment(@AuthUser Member member, Model model, @PathVariable Long itemId, @RequestBody CommentForm commentForm) {
        commentService.saveComment(member, commentForm, itemId);

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }

    // READ
   // @ResponseBody
    @RequestMapping(value= "/list/{itemId}", method = {RequestMethod.GET})
    public String addComment(@PathVariable Long itemId, Model model) {

        Album item = new Album();
        item.setComments(commentService.Listcomment(itemId));

        model.addAttribute("item", item);
        //model.addAttribute("item.comments", commentService.Listcomment(itemId));

       // return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);

        return "modal :: comTable";
    }

    //DELETE
    @RequestMapping(value= "/delete/{itemId}/{commentId}", method = {RequestMethod.POST})
    public ResponseEntity<List<Comment>> addComment(@AuthUser Member member, @PathVariable Long itemId, @PathVariable Long commentId) {
        commentService.deletecomment(itemId, commentId);
       // return new ResponseEntity<>(this.commentService.Deletecomments(commentsNo,postNo),HttpStatus.CREATED);

        return new ResponseEntity<>(commentService.Listcomment(itemId), HttpStatus.CREATED);
    }
}
