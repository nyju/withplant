package com.withplant.album;

import com.withplant.member.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AlbumController {

    @GetMapping("/regeisterAlbum")
    public String registerAlbum(Model model) {
        model.addAttribute(new SignUpForm());
        return "album/write";
    }

}
