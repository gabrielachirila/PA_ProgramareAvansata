package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "album_genres")
public class AlbumGenre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    public AlbumGenre() {
    }

    public AlbumGenre(Album album, Genre genre) {
        this.album = album;
        this.genre = genre;
    }

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
