package ru.job4j.tracker;

public class MassDeleteAction implements UserAction {
    private final Output out;

    public MassDeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete 300_000 items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete 299_000 items ===");
        int id = input.askInt("Enter id: ");
        for (int i = 0; i < 300000; i++) {
            if (tracker.delete(id++)) {
                out.println("Заявка удалена успешно.");
            } else {
                out.println("Ошибка удаления заявки.");
            }
        }
        return true;
    }
}