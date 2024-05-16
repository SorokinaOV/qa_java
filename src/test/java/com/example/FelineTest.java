package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetKittensTest() {
        int expected = 1;
        Feline feline = new Feline();
        int actual = feline.getKittens();
        Assert.assertEquals("Количество хищников не соответствует",expected, actual);
    }

    @Test
    public void testGetKittens() {
        int expected = 5;
        Feline feline = new Feline();
        int actual = feline.getKittens(5);
        Assert.assertEquals("Количество хищников не соответствует",expected, actual);
    }

    @Test
    public void testGetFamily() {
        String expected = "Кошачьи";
        Feline feline = new Feline();
        String actual = feline.getFamily();
        Assert.assertEquals("Наименование семейства не соответствует",expected, actual);
    }
}
