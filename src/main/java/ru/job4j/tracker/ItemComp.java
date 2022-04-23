package ru.job4j.tracker;

import java.util.Collections;
import java.util.List;

public class ItemComp {
    public List<Item> itemAscByName(List<Item> items) {
        Collections.sort(items, new ItemCompare());
        return items;
    }

    public List<Item> itemDescByName(List<Item> items) {
        Collections.sort(items, new ItemCompare().reversed());
        return items;
    }
}
