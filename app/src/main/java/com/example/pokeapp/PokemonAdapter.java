package com.example.pokeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Адаптер для RecyclerView, который управляет отображением списка покемонов.
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private final List<Pokemon> pokemonList;
    private final OnPokemonClickListener onPokemonClickListener;

    public PokemonAdapter(List<Pokemon> pokemonList, OnPokemonClickListener onPokemonClickListener) {
        this.pokemonList = pokemonList;
        this.onPokemonClickListener = onPokemonClickListener;
    }

    // Создание ViewHolder
    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    // Обновление ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.pokemonNameTextView.setText(pokemon.getName());
        holder.itemView.setOnClickListener(v -> onPokemonClickListener.onPokemonClick(pokemon));
    }
    //Возвращает количество элементов в списке данных
    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public interface OnPokemonClickListener {
        void onPokemonClick(Pokemon pokemon);
    }

    static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonNameTextView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
        }
    }
}