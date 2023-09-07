-- +goose Up
CREATE TABLE genre (
  id INTEGER PRIMARY KEY,
  "name" VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE movie (
  id INTEGER PRIMARY KEY,
  title TEXT NOT NULL UNIQUE,
  "year" SMALLINT NOT NULL, 
  price NUMERIC(10, 2),
  quantity SMALLINT NOT NULL,
  t_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE movie_genre (
  movie_id INTEGER NOT NULL,
  genre_id INTEGER NOT NULL,
  PRIMARY KEY (movie_id, genre_id),
  FOREIGN KEY (movie_id) REFERENCES movie(id),
  FOREIGN KEY (genre_id) REFERENCES genre(id)
);

CREATE INDEX IF NOT EXISTS movie_idx_title
ON movie (title)
WHERE t_active IS TRUE;

CREATE INDEX IF NOT EXISTS movie_idx_year
ON movie ("year")
WHERE t_active IS TRUE;

CREATE TABLE user (
  id INTEGER PRIMARY KEY,
  "name" VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE,
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  t_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE INDEX IF NOT EXISTS user_idx_name
ON user ("name")
WHERE t_active IS TRUE;

CREATE INDEX IF NOT EXISTS user_idx_email
ON user (email)
WHERE t_active IS TRUE;

CREATE TABLE rental (
  id INTEGER PRIMARY KEY,
  user_id INTEGER NOT NULL,
  movie_id INTEGER NOT NULL,
  rent_date TIMESTAMP NOT NULL,
  due_date TIMESTAMP NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES movie(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE INDEX IF NOT EXISTS rental_idx_user_id
ON rental (user_id);

CREATE INDEX IF NOT EXISTS rental_idx_movie_id
ON rental (movie_id);

CREATE INDEX IF NOT EXISTS rental_idx_rent_date
ON rental (rent_date);
