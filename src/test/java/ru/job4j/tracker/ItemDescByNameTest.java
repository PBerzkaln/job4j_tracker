package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
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
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}