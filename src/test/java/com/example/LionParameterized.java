package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterized {
    private String sex;
    private boolean result;
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    public LionParameterized(String sex, boolean result) {
        this.sex = sex;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }
    @Test
    public void testdoesHaveMane() throws Exception {
        lion = new Lion(sex,feline);
        boolean hasMane = lion.doesHaveMane();
        assertEquals(result, hasMane);
    }
}