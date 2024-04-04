package com.example.musicapp.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class MusicResource extends RepresentationModel<MusicResource> {

    private Music music;

}
