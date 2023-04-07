package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ru.yandex.praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredientSecond;
    @Mock
    private Bun bun;
    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test//Тест метода выбоа булочки для бургера
    public void setBunsToBurgerTest() {
        Bun expected = bun;
        burger.setBuns(bun);
        Bun actual = burger.bun;
        Assert.assertEquals(expected, actual);
    }

    @Test//Тест метода добавления соуса или начинки в бургер
    public void addIngredientToBurgerTest() {
        int expectedSize = 1;
        burger.addIngredient(ingredient);
        int actualSize = burger.ingredients.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test//Тест метода удаления соуса или начинки из бургера
    public void deleteIngredientFromBurgerTest() {
        int expectedSize = 1;
        burger.ingredients.addAll(Arrays.asList(ingredient, ingredientSecond));
        burger.removeIngredient(0);
        int actualSize = burger.ingredients.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test//Тест метода перемещения начинки в бургере на новое место
    public void moveIngredientInBurgerTest() {
        List<Ingredient> expected = new ArrayList<>(Arrays.asList(ingredientSecond, ingredient));
        burger.ingredients.addAll(Arrays.asList(ingredient, ingredientSecond));
        burger.moveIngredient(0, 1);
        List<Ingredient> actual = burger.ingredients;
        Assert.assertEquals(expected, actual);
    }

    @Test//Тест метода расчета цены за весь бургер
    public void getPriceBurgerTest() {
        float expected = 700;
        burger.setBuns(bun);
        burger.ingredients.addAll(Arrays.asList(ingredient, ingredientSecond));
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(300F);
        float actual = burger.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test//Тест метода формирования рецепта бургера
    public void getReceiptBurgerTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("chili sauce");
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
 