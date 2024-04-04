package com.example.musicapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "music", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "year_of_prod"}))//LoveMe 2022
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
//    @Column(unique = true)
    private String title;
    @NotBlank
    @Length(min = 3, max = 25)
    private String artistName;
    @NotBlank
    @Length(min = 6, max = 25)
    private String albumName;
    @Range(min = 1, max = 6)
    private double musicDuration;
    @NotBlank
    @Length(min = 3)
    private String genre;
    @Min(1900)
    @Max(2024)
    private int yearOfProd;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setMusicDuration(double musicDuration) {
        this.musicDuration = musicDuration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProd = yearOfProduction;
    }
}
