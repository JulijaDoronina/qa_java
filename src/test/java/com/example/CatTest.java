package com.example;

import org.junit.Before;
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
    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }
    @Test
    public void testGetSound() {
        Cat testcat  = new Cat(new Feline());
        assertEquals("Метод getSound() должен возвращать 'Мяу'",
                "Мяу", testcat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();

        assertEquals("Метод getFood() должен возвращать список еды для хищников",
                expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Cat cat = new Cat(felineMock);
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));
        cat.getFood();
    }
}