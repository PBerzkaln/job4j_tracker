package ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNMinus1ThenException() {
        new Fact().calc(-1);
    }
}