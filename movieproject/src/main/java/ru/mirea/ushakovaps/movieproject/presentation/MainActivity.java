package ru.mirea.ushakovaps.movieproject.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.mirea.ushakovaps.movieproject.R;
import ru.mirea.ushakovaps.movieproject.data.repository.MovieRepositoryImpl;
import ru.mirea.ushakovaps.movieproject.domain.repository.MovieRepository;
import ru.mirea.ushakovaps.movieproject.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.ushakovaps.movieproject.domain.usecases.SaveFilmToFavoriteUseCase;
import ru.mirea.ushakovaps.movieproject.domain.models.Movie;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text = findViewById(R.id.editTextMovie);
        MovieRepository movieRepository = new MovieRepositoryImpl(this);

        TextView textView = findViewById(R.id.textViewMovie);
        Movie moview = new GetFavoriteFilmUseCase(movieRepository).execute();
        textView.setText(String.format("Save result %s", moview.getName()));

        Button saveButton =  findViewById(R.id.buttonSaveMovie);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(new Movie(2, text.getText().toString()));
                textView.setText(String.format("Save result %s", result));
            }
        });

        Button getButton =  findViewById(R.id.buttonGetMovie);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie moview = new GetFavoriteFilmUseCase(movieRepository).execute();
                textView.setText(String.format("Save result %s", moview.getName()));
            }
        });

    }
}
