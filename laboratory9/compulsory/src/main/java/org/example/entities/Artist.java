package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "artists")
@NamedQueries({
        @NamedQuery(name = "Artist.findAll",
                query = "select e from Artist e order by e.name"),
        @NamedQuery(name = "Artist.findByName",
                query = "SELECT id, name FROM artists WHERE (name = ?)"),
})

public class Artist implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
        @Column(name = "id")
        private Integer id;

        @Column(name = "name")
        private String name;

        public Artist() {
        }

        public Artist(String name) {
            this.name = name;
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Artist{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

