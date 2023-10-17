package com.example.uploadmusic.service;


import com.example.uploadmusic.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);
}
