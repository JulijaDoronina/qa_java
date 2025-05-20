package com.example;

import java.util.List;

public class AlexLion extends Lion{
    public AlexLion(String sex, Feline feline) throws Exception {
        super("Самец", feline);
    }

    // список друзей
    public List<String> getFriends() {
        return List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    }
    // место, где он живет
    public String getPlaceOfLiving(){
        return "Нью-Йоркский зоопарк";
    }
    // переопределяем метод
    @Override
    public int getKittens() {
        return 0; // нет львят
    }
}
