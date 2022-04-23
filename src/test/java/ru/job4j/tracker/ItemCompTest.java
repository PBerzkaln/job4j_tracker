package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemCompTest {

    @Test
    public void itemAscByName() {
        Item one = new Item("Vanya");
        Item two = new Item("Kolya");
        Item three = new Item("Vasya");
        Item four = new Item("Genya");
        Item five = new Item("Tolya");
        List<Item> items = new ArrayList<>();
        items.add(one);
        items.add(two);
        items.add(three);
        items.add(four);
        items.add(five);
        List<Item> expected = List.of(four, two, five, one, three);
        assertThat(new ItemComp().itemAscByName(items), is(expected));
    }

    @Test
    public void itemDescByName() {
        Item one = new Item("Vanya");
        Item two = new Item("Kolya");
        Item three = new Item("Vasya");
        Item four = new Item("Genya");
        Item five = new Item("Tolya");
        List<Item> items = new ArrayList<>();
        items.add(one);
        items.add(two);
        items.add(three);
        items.add(four);
        items.add(five);
        List<Item> expected = List.of(three, one, five, two, four);
        assertThat(new ItemComp().itemDescByName(items), is(expected));
    }
}