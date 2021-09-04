package com.withplant.album;

import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @PostMapping("/album/modify/{itemid}")
    public String modifyAlbumSubmit(@AuthUser Member member, @PathVariable Long itemid, AlbumForm albumForm) {

        albumService.updateAlbum(itemid, albumForm);

        return "redirect:/";
    }

    @GetMapping("/album/delete/{itemid}")
    public String deleteAlbum(@AuthUser Member member, @PathVariable Long itemid) {
        albumService.deleteAlbum(itemid);

        return "redirect:/";
    }



    @GetMapping("/album/user/{userid}")
    public String userAlbum(@AuthUser Member member, @PathVariable Long userid, Model model) {
      //  model.addAttribute(member);
        List<Album> items = albumRepository.findByMemberId(userid);
        model.addAttribute(member);
        model.addAttribute("albumList", items);
        System.out.println(userid);
        return "album/user";
    }


    @GetMapping("/album/view/{itemid}")
    public String viewAlbum(@AuthUser Member member, @PathVariable Long itemid, Model model) {

        Album album = albumService.viewAlbum(itemid);
        model.addAttribute("item", album);

        return "album/userModal";
    }
}
