package com.withplant.album;

import com.withplant.attachment.Attachement;
import com.withplant.comment.CommentService;
import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;
    private final AlbumRepository albumRepository;

    @GetMapping("/regeisterAlbum")
    public String registerAlbum(@AuthUser Member member, Model model) {
        model.addAttribute(member);
        model.addAttribute(new AlbumForm());
        return "album/write";
    }

    @PostMapping("/regeister")
    @ResponseBody
    public String registerAlbum(@AuthUser Member member, AlbumForm albumForm) {

        albumService.registerAlbum(albumForm, member);

        return "redirect:/";
    }

    @GetMapping("/album/modify/{itemid}")
    public String modifyAlbum(@AuthUser Member member, @PathVariable Long itemid, Model model) {

        AlbumForm albumForm = albumService.getAlbum(itemid);
        model.addAttribute("item", albumForm);

        return "album/modify";
    }

    @GetMapping("/album/delete/{itemid}")
    public String deleteAlbum(@AuthUser Member member, @PathVariable Long itemid, Model model) {

        albumService.deleteAlbum(itemid);

        return "redirect:/";
    }
}
