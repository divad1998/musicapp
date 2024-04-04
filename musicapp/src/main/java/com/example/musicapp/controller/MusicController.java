package com.example.musicapp.controller;

import com.example.musicapp.model.Music;
import com.example.musicapp.service.MusicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/allMusic")
    public ResponseEntity<List<Music>> getAllMusic(){
        return musicService.getAllMusic();
    }

    @GetMapping("/single/{id}")
    public ResponseEntity<Music> getMusicById(@PathVariable int id){
        return musicService.getMusicById(id);
    }

    @PostMapping("/single")
    public ResponseEntity<Music> addNewMusic(@RequestBody @Valid Music music){
        return musicService.addNewMusic(music);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Music> updateMusic(@PathVariable int id, @Valid @RequestBody Music music){
        return musicService.updateMusic(id, music);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Music> deleteMusic(@PathVariable int id){
        return musicService.deleteMusic(id);
    }

    @GetMapping
    public ResponseEntity<Music> getByArtistName(@RequestParam String artistName) {
        Music music = musicService.getByArtistName(artistName);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Music> getByTitle(@RequestParam String title) {
        Music music = musicService.getByTitle(title);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Music> getByGenre(@RequestParam String genre) {
        Music music = musicService.getByGenre(genre);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Music> getByYearOfProd(@RequestParam int yearOfProd) {
        Music music = musicService.getByYearOfProd(yearOfProd);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Music> getByAlbumName(@RequestParam String albumName) {
        Music music = musicService.getByAlbumName(albumName);
        return new ResponseEntity<>(music, HttpStatus.OK);
    }
}
