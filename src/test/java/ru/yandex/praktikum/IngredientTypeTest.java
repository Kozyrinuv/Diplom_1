package ru.yandex.praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test//Тест проверки значения перечисления <Начинки> типов инградиентов
    public void checkIngredientFillingTest() {
        assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

    @Test//Тест проверки значения перечисления <Соусы> типов инградиентов
    public void checkIngredientSauceTest() {
        assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

}
 