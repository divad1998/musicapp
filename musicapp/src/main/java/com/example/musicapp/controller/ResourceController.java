package com.example.musicapp.controller;

//import com.Davidson.MusicApp.model.Music;
import com.example.musicapp.model.Music;
import com.example.musicapp.model.MusicResource;
//import com.Davidson.MusicApp.service.MusicService;
import com.example.musicapp.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/{id}")
    public ResponseEntity<MusicResource> getMusicResource(@PathVariable int id){
        Music musicToSend = musicService.getMusicById(id).getBody();
        MusicResource musicResource = new MusicResource();
        musicResource.setMusic(musicToSend);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getMusicById(id)).withSelfRel();
        Link delete = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).deleteMusic(id)).withRel("delete");
        Link update = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).updateMusic(id, musicToSend)).withRel("update");
        Link allMusic = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(MusicController.class).getAllMusic()).withRel("allMusic");
        musicResource.add(selfLink, delete, update, allMusic);

        return new ResponseEntity<>(musicResource, HttpStatus.OK);
    }
}
