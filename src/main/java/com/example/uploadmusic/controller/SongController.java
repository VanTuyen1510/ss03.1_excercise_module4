package com.example.uploadmusic.controller;

import com.example.uploadmusic.model.Song;
import com.example.uploadmusic.model.SongForm;
import com.example.uploadmusic.service.ISongService;
import com.example.uploadmusic.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {
    @Value("${file-upload}")
    private String fileUpload;
    private final ISongService songService = new SongServiceImpl();

    @GetMapping("")
    public String showList(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "/index";
    }

    List<String> getTypeList() {
        List<String> types = new ArrayList<>();
        types.add("rock");
        types.add("countryside");
        types.add("love");
        types.add("rap");
        return types;
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("songForm", new SongForm());
        model.addAttribute("types", getTypeList());
        return "/create";
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, Model model) {
        MultipartFile multipartFile = songForm.getSong();
        String fileName = multipartFile.getOriginalFilename();
        if(multipartFile.isEmpty()){
            model.addAttribute("message", "Vui lòng chọn file để upload");
            return "/create";
        }
        if (!fileName.endsWith(".mp3") && !fileName.endsWith(".wav") && !fileName.endsWith(".ogg") && !fileName.endsWith(".m4p")) {
            model.addAttribute("message", "File không hợp lệ. Vui lòng chọn file có đuôi .mp3, .wav, .ogg hoặc .m4p.");
            return "/create";
        }
        try {
            FileCopyUtils.copy(songForm.getSong().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getAuthorName(), songForm.getTypes(), fileName);
        songService.save(song);
        return "redirect:/song";
    }
}