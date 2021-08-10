package com.withplant.profile;

import com.withplant.album.Album;
import com.withplant.album.AlbumRepository;
import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfileController {

    private final AlbumRepository albumRepository;

    @GetMapping("/profile")
    public String registerAlbum(@AuthUser Member member, Model model) {
        model.addAttribute(member);
        List<Album> items = albumRepository.findByMemberId(member.getId());
        model.addAttribute("albumList", items);

        return "profile/menu";
    }



}
