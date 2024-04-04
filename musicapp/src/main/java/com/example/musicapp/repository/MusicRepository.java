package com.example.musicapp.repository;

import com.example.musicapp.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
    Music findByArtistName(String artistName);
    Music findByTitle(String title);
    Music findByGenre(String genre);
    Music findByYearOfProd(int yearOfProd);
    Music findByAlbumName(String album);
}
