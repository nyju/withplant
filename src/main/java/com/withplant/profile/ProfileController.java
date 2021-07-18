package com.withplant.profile;

import com.withplant.member.AuthUser;
import com.withplant.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String registerAlbum(@AuthUser Member member, Model model) {
        model.addAttribute(member);
        return "profile/menu";
    }

}
