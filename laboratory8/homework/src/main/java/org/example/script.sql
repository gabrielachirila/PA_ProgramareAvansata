CREATE TABLE albums (
  id SERIAL PRIMARY KEY,
  release_year INTEGER NOT NULL,
  title VARCHAR(100) NOT NULL,
  artist VARCHAR(100) NOT NULL,
  genre VARCHAR(100) 
);

CREATE TABLE artists (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE genres (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE album_genres (
  id_album INTEGER NOT NULL REFERENCES albums(id),
  id_genre INTEGER NOT NULL REFERENCES genres(id),
  PRIMARY KEY (id_album, id_genre)
);
