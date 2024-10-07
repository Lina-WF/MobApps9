package ru.mirea.ushakovaps.movieproject.data.repository;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.ushakovaps.movieproject.domain.models.Movie;
import ru.mirea.ushakovaps.movieproject.domain.repository.MovieRepository;
import ru.mirea.ushakovaps.movieproject.presentation.MainActivity;

public class MovieRepositoryImpl implements MovieRepository {
    private Context context;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    public MovieRepositoryImpl(Context context) {
        this.context = context;
        sharedPref = this.context.getSharedPreferences("mirea_settings", context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    @Override
    public boolean saveMovie(Movie movie){
        editor.putString("movie", movie.getName());
        editor.apply();
        return true;
    }
    @Override
    public Movie getMovie(){
        String movie = sharedPref.getString("movie", "Нет данных.");
        return new Movie(1, movie);
    }
}