package com.example.pokeapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//Этот класс представляет активити, которая отображает детали конкретного покемона.
//При создании активности он получает URL покемона из интента и вызывает метод fetchPokemonDetail для получения данных о покемоне.
//OkHttp для выполнения сетевого запроса и Jackson ObjectMapper для парсинга JSON в объект PokemonDetail.

public class PokemonDetailActivity extends AppCompatActivity {

    private TextView detailTextView;
    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        detailTextView = findViewById(R.id.detailTextView);

        String pokemonUrl = getIntent().getStringExtra("POKEMON_URL");

        if (pokemonUrl != null) {
            fetchPokemonDetail(pokemonUrl);
        } else {
            detailTextView.setText("No Pokemon URL provided");
        }
    }

    private void fetchPokemonDetail(String url) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(() -> Toast.makeText(PokemonDetailActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String jsonData = response.body().string();
                    PokemonDetail pokemonDetail = objectMapper.readValue(jsonData, PokemonDetail.class);

                    runOnUiThread(() -> {
                        String detailText = "ID: " + pokemonDetail.getId() + "\n" +
                                "name: " + pokemonDetail.getName() + "\n" +
                                "base_experience: " + pokemonDetail.getBase_experience() + "\n" +
                                "height: " + pokemonDetail.getHeight() + "\n" +
                                "weight: " + pokemonDetail.getWeight();
                        detailTextView.setText(detailText);
                    });
                } else {
                    runOnUiThread(() -> Toast.makeText(PokemonDetailActivity.this, "Failed to load data", Toast.LENGTH_SHORT).show());
                }
            }
        });
    }
}
