package com.withplant.album;

import com.withplant.attachment.Attachement;
import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import com.withplant.member.UserMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class AlbumController {

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

        Album album = new Album();
        album.setAttachements(albumForm.getAttachements());
        for (Attachement att : albumForm.getAttachements()) {
            album.addAttachement(att);
        }
        album.setContent(albumForm.getContent());
        album.setMember(member);
        album.setRgstDate(LocalDateTime.now());


        Album newAlbum = albumRepository.save(album);

        return "redirect:";
    }
}
