package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EditActionMockitoTest {
    private final Output out = new StubOutput();
    private final MemTracker tracker = new MemTracker();

    @Mock
    Input input = mock(Input.class);

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void execute() {
        tracker.add(new Item("Deleted item"));
        String replacedName = "New item name";
        EditAction rep = new EditAction(out);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Edit item ===",
                "Заявка изменена успешно."));
        assertThat(tracker.findAll().get(0).getName()).isEqualTo(replacedName);
    }

    @Test
    public void notExecute() {
        tracker.add(new Item("Replaced item"));
        EditAction rep = new EditAction(out);
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Edit item ===",
                "Ошибка замены заявки."));
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Replaced item");
    }
}