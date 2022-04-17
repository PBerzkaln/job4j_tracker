package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];
    ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    //private int size = 0;

    public Tracker() {
    }

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item name) {
       int index = indexOf(id);
       boolean rsl = index != -1;
       if (rsl) {
           name.setId(id);
           items.set(index, name);
       }
       return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            /*System.arraycopy(items, index + 1, items, index, size - index - 1);
            items.set(size - 1, null);
            size--;*/
            items.remove(index);
        }
        return rsl;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        ArrayList<Item> rsl = new ArrayList<>();
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl.add(count, item);
                count++;
            }
        }
        return List.copyOf(rsl);
    }
}