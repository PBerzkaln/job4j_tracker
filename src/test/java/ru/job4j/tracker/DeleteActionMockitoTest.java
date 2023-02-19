package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionMockitoTest {
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
        DeleteAction rep = new DeleteAction(out);
        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Delete item ===",
                "Заявка удалена успешно."));
    }

    @Test
    public void notExecute() {
        DeleteAction rep = new DeleteAction(out);
        when(input.askInt(any(String.class))).thenReturn(-1);
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Delete item ===",
                "Ошибка удаления заявки."));
    }
}