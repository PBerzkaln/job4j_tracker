package ru.job4j.tracker;

public class MassCreateAction implements UserAction {
    private final Output out;

    public MassCreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add 299_000 items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create 299_000 new items ===");
        String name = input.askStr("Enter name: ");
        for (int i = 0; i < 300000; i++) {
            Item item = new Item(name);
            tracker.add(item);
            out.println("Добавленная заявка: " + item);
        }
        return true;
    }
}
