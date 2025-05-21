package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testDoesHaveManeMale() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }
    @Test
    public void testDoesHaveManeFemale() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }
    @Test(expected = Exception.class)
    public void testInvalidSexException() throws Exception {
        new Lion("Неизвестный пол животного", felineMock);
    }
    @Test
    public void testGetKittens() throws Exception {
        when(felineMock.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals("Лев должен возвращать 1 котенка по умолчанию",
                1, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", felineMock);
        List<String> actualFood = lion.getFood();
        assertEquals("Лев должен возвращать список еды для хищников",
                expectedFood, actualFood);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLionConstructorThrowsIllegalArgumentException() throws Exception {
        new Lion("Самка", null);
    }
}