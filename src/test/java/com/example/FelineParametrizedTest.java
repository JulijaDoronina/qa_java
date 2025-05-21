package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

        private final int expected;
        private final int kittensCount;

        public FelineParametrizedTest(int expected, int kittensCount){
            this.expected = expected;
            this.kittensCount = kittensCount;
        }
        @Parameterized.Parameters(name = "Тестовые данные:{0}{1}") // добавили аннотацию с аргументом name, где {0}{1} - индексы параметров
        public static Object[][] data() {
            return new Object[][]{
                    {1, 1},
                    {9, 9},
                    {0, 0}
            };
        }
    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}

