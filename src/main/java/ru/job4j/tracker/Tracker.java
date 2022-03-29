package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Tracker() {
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item name) {
       int index = indexOf(id);
       if (indexOf(id) != -1) {
           name.setId(id);
           items[index] = name;
       }
       return false;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (indexOf(id) != -1) {
            System.arraycopy(items, index + 1, items, index, size - 1);
            items[size - 1] = null;
            size--;
        }
        return false;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[this.items.length];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                rsl[count] = items[index];
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }
}