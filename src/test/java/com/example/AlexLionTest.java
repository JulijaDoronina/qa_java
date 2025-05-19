package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class AlexLionTest {
    @Mock
    private InterfaseFeline felineMock;

    @Test
    public void testConstructorMaleSex() throws Exception {

        AlexLion alex = new AlexLion("ЛюбоеЗначение", felineMock);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void testGetFriends() throws Exception {
        AlexLion alex = new AlexLion("Самец", felineMock);
        List<String> expectedFriends = List.of(
                "зебра Марти",
                "бегемотиха Глория",
                "жираф Мелман"
        );
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        AlexLion alex = new AlexLion("Самец", felineMock);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() throws Exception {
        AlexLion alex = new AlexLion("Самец", felineMock);
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testConstructorInvalidSex() throws Exception {
        // работает с любым полом, но всегда использует "Самец"
        AlexLion alex = new AlexLion("ЛюбоеЗначение", felineMock);
        assertTrue(alex.doesHaveMane()); // Проверяем что это самец
    }
}