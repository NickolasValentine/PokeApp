package com.example.pokeapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//Это класс, который используется для хранения основной информации о покемоне (имя и URL).
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

