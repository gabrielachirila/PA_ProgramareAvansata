package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name="Genre.findAll",
                query = "select e from Genre e order by e.name"),
        @NamedQuery(name="Genre.findByName",
                query = "select e from Genre e where e.name = ?1")
})
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlbumGenre> albumGenres = new HashSet<>();

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }
    public Set<Album> getAlbums() {
        Set<Album> albums = new HashSet<>();
        for (AlbumGenre albumGenre : albumGenres) {
            albums.add(albumGenre.getAlbum());
        }
        return albums;
    }

    public void addAlbumGenre(AlbumGenre albumGenre) {
        this.albumGenres.add(albumGenre);
        albumGenre.setGenre(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
