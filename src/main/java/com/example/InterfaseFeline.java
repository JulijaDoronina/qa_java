package com.example;

import java.util.List;

// Интерфейс для работы с семейством кошачьих
public interface InterfaseFeline {

    int getKittens();

    int getKittens(int kittensCount);

    List<String> getFood(String animalKind) throws Exception;
}
