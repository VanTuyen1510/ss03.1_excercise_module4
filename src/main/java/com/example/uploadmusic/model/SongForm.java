package com.example.uploadmusic.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class SongForm {
    private int id;
    private String name;
    private String authorName;
    private List<String> types;
    private MultipartFile song;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public MultipartFile getSong() {
        return song;
    }

    public void setSong(MultipartFile song) {
        this.song = song;
    }

    public SongForm(int id, String name, String authorName, List<String> types, MultipartFile song) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.types = types;
        this.song = song;
    }

    public SongForm() {
    }
}
