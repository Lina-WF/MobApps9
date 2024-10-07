package ru.mirea.ushakovaps.movieproject.domain.repository;

import ru.mirea.ushakovaps.movieproject.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}