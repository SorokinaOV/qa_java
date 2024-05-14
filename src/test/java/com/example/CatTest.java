package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;
    @Mock
    private Feline feline;

    @Before
    public void setCat() {
        cat = new Cat(feline);
    }

    @Test
    public void testGetFoodPositive() throws Exception {
        List<String> expected = List.of("Животные", "Птица", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птица", "Рыба"));
        Assert.assertEquals(expected, cat.getFood());
    }

    @Test
    public void testGetFoodNegative() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птица", "Рыба"));
        Assert.assertNotEquals(expected, cat.getFood());
    }

    @Test
    public void testGetSound() {
        assertEquals("Кот должен мяукать", "Мяу", cat.getSound());
    }
}