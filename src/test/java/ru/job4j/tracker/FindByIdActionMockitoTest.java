package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionMockitoTest {
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
        FindByIdAction rep = new FindByIdAction(out);
        when(input.askInt(any(String.class))).thenReturn(1);
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Find item by id ===", item));
    }

    @Test
    public void notExecute() {
        FindByIdAction rep = new FindByIdAction(out);
        when(input.askInt(any(String.class))).thenReturn(-1);
        rep.execute(input, tracker);
        assertThat(out.toString()).isEqualTo(String.format("%s%n%s%n", "=== Find item by id ===",
                "Заявка с введенным id: -1 не найдена."));
    }
}