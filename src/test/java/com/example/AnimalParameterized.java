package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterized {
    private Animal animal;
    private String animalKind;
    private List<String> foods;

    public AnimalParameterized(String animalKind, List<String> foods) {
        this.animalKind = animalKind;
        this.foods = foods;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals("Список еды для животных не совпадает с ожидаемым",
                foods, actual);
    }
}
