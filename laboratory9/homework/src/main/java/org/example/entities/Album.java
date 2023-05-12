package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
        @NamedQuery(name = "Album.findById",
                query = "SELECT e FROM Album e WHERE e.id = ?1"),
        @NamedQuery(name = "Album.findByName",
                query = "SELECT e FROM Album e WHERE e.title LIKE ?1"),
        @NamedQuery(name = "Album.findByArtist",
                query = "select e from Album e where e.artist = ?1")
})

public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlbumGenre> albumGenres = new HashSet<>();

    public Album() {
    }

    public Album(Integer releaseYear, String title) {
        this.releaseYear = releaseYear;
        this.title = title;
    }

    // getters and setters


    public Integer getId() {
        return id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Set<AlbumGenre> getGenres() {
        return albumGenres;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

//    public void setGenres(Set<Genre> genres) {
//        this.albumGenres = genres;
//    }

//    public void addGenre(Genre genre) {
//        albumGenres.add(genre);
//        genre.getAlbums().add(this);
//    }

    public void addArtist(Artist artist) {
        this.artist = artist;
        artist.getAlbums().add(this);
    }
}