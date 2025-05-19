package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)// подключили Mockito к тестовому классу
public class CatTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Cat cat = new Cat(felineMock);
        List<String> expectedFood = List.of("Мясо", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        assertEquals(expectedFood, cat.getFood());
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Cat cat = new Cat(felineMock);
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        cat.getFood();
    }
}