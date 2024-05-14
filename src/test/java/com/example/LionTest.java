package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Lion lion;
    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood(Mockito.anyString());
    }

    @Test
    public void testdoesHaveManeTrue() throws Exception {
        lion = new Lion("Самец", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertTrue(hasMane);
    }
    @Test
    public void testdoesHaveManeFalsh() throws Exception {
        lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertFalse(hasMane);
    }
    @Test
    public void testExceptionAndCheckText() {
        feline = new Feline();
        Exception exception = Assert.assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}