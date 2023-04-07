package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    private Ingredient ingredient;

    public IngredientParamTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест IngredientParamTest =  {0} -> {1} -> {2}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "Флюоресцентная булка R2-D3", 988f},
                {IngredientType.FILLING, "Краторная булка", 1255},
                {null, "Краторная булка", 1255},
                {null, null, -1255},
                {IngredientType.SAUCE, "null", -9999999f},
                {IngredientType.FILLING, null, 9999999f},
                {IngredientType.SAUCE, "0", -3.4e+38f},
                {IngredientType.FILLING, "", 3.4E+38f},
                {IngredientType.SAUCE, "=-)(*&^%$#@!}]{[", 0f},
                {IngredientType.FILLING, "qwertyuiopasdfghjklzxcvbnm white bun black bun", 1.1f},
                {IngredientType.SAUCE, "QWERTYUIOPASDFGHJKLZXCVBNM BUN OF WHITE", 0.1f},
                {IngredientType.FILLING, "2344578992234", 1234567.9875f},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test//Тест проверки стоимости инградиента
    public void checkGetPriceOfIngredientTest() {
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test//Тест проверки названия инградиента
    public void checkGetNameOfIngredientTest() {
        String expectedName = name;
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test//Тест проверки типа инградиента
    public void checkGetTypeOfIngredientTest() {
        IngredientType expectedType = type;
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}