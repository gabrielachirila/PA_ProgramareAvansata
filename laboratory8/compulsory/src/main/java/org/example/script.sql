CREATE TABLE albums (
  id SERIAL PRIMARY KEY,
  release_year INTEGER NOT NULL,
  title VARCHAR(100) NOT NULL,
  artist VARCHAR(100) NOT NULL,
  genre VARCHAR(100) NOT NULL
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
  id_album INTEGER,
  id_genre INTEGER,
  FOREIGN KEY (id_album) REFERENCES albums(id),
  FOREIGN KEY (id_genre) REFERENCES genres(id)
);