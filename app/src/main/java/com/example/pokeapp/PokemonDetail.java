package com.example.pokeapp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Этот класс используется для хранения деталей покемона.
//Он соответствует структуре JSON, который возвращает API, за исключением неизвестных полей

//В случаях, когда не все поля известны или интересны, можно использовать аннотацию
//@JsonIgnoreProperties(ignoreUnknown = true), чтобы игнорировать неизвестные поля.
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDetail {
    private int id;
    private String name;
    private int base_experience;
    private int height;
    private int weight;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(int base_experience) {
        this.base_experience = base_experience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}