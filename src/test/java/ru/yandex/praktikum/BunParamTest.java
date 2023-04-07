package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParamTest {
    private final String name;
    private final float price;
    private Bun bun;

    public BunParamTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тест BunParamTest = {0} -> {1}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988f},
                {"Краторная булка", 1255},
                {"null", -9999999f},
                {null, 9999999f},
                {"0", -3.4e+38f},
                {"", 3.4E+38f},
                {"=-)(*&^%$#@!}]{[", 0f},
                {"qwertyuiopasdfghjklzxcvbnm white bun black bun", 1.1f},
                {"QWERTYUIOPASDFGHJKLZXCVBNM BUN OF WHITE", 0.1f},
                {"2344578992234", 1234567.9875f},
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(name, price);
    }

    @Test//Тест проверки названия булки
    public void checkGetBunNameTest() {
        String expectedName = name;
        String actualName = bun.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test//Тест проверки стоимости булки
    public void checkGetBunPriceTest() {
        float expectedPrice = price;
        float actualPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }
}
