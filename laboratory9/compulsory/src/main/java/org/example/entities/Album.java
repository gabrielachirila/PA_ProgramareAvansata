package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.title"),
})

public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "title")
    private String title;
    @Column(name = "artist")
    private String artist;

    @Column(name = "genre")
    private String genre;

    public Album() {
    }

    public Album(int releaseYear, String title, String artist, String genre) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Album{");
        sb.append("id=").append(id);
        sb.append(", releaseYear=").append(releaseYear);
        sb.append(", title='").append(title).append('\'');
        sb.append(", artist='").append(artist).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
