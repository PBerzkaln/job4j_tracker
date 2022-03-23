package ru.job4j.tracker;

import javax.sound.midi.Track;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;
    private int id;
    private String name;

    public Tracker() {
    }

    public Tracker(String name) {
        this.name = name;
    }

    public Tracker(int id) {
        this.id = id;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}