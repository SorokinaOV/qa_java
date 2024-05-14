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
        int actual = feline.getKittens();
        Mockito.verify(feline).getKittens(1);
        Assert.assertEquals("Количество хищников не соответствует", 1, feline.getKittens());
    }

    @Test
    public void testGetKittens() {
        int actual = feline.getKittens(5);
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        Assert.assertEquals("Количество хищников не соответствует", 5, actual);
    }

    @Test
    public void testGetFamily() {
        String actual = feline.getFamily();
        Mockito.verify(feline, Mockito.times(1)).getFamily();
        Assert.assertEquals("Наименование семейства не соответствует", "Кошачьи", actual);
    }
}
