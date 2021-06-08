package com.withplant.config;

import com.withplant.album.Album;
import com.withplant.album.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainConfig{

    private final AlbumRepository albumRepository;

    @GetMapping("/")
    public String home(Model model){
        System.out.println("Index");
        List<Album> items = albumRepository.findAll();
        model.addAttribute("albumList", items);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
