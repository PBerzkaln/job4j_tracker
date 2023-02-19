package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionMockitoTest {
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
        Item item = new Item("Added item");
        tracker.add(item);
        FindByNameAction rep = new FindByNameAction(out);
        when(input.askStr(any(String.class))).thenReturn("Added item");
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Find items by name ===", item));
    }

    @Test
    public void notExecute() {
        FindByNameAction rep = new FindByNameAction(out);
        when(input.askStr(any(String.class))).thenReturn("Added item");
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Find items by name ===",
                "Заявки с именем: Added item не найдены."));
    }
}