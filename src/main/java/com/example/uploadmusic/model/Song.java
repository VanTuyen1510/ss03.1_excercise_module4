package com.example.uploadmusic.model;

import java.util.List;

public class Song {
    private int id;
    private String name;
    private String authorName;
    private List<String> types;
    private String songURL;

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

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }

    public Song(int id, String name, String authorName, List<String> types, String songURL) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.types = types;
        this.songURL = songURL;
    }

    public Song() {
    }

    public String displaySong(){
        if (types == null){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        boolean flag = true;
        for (String type: types){
            if (flag){
                flag = false;
            }else{
                builder.append(", ");
            }
            builder.append(type);
        }
        return builder.toString();
    }
}
