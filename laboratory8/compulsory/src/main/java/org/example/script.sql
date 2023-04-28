CREATE TABLE albums (
    id INT PRIMARY KEY,
    release_year INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    artist VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL
);

CREATE TABLE artists (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
);

CREATE TABLE genres (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
);