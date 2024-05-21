package com.example.pokeapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


//Этот класс используется для парсинга ответа от API, возвращающего список покемонов.
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {
    @JsonProperty("results")
    private List<Pokemon> results;
    private int count;
    private String next;


    // Getters and setters
    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
