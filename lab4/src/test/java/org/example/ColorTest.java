package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    public void testColorWithinValidRange() {
        assertDoesNotThrow(() -> new Color(50, 75, 125, 200));
    }

    @Test
    public void testRedValueBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(-10, 50, 50, 50));
    }

    @Test
    public void testGreenValueBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(50, -20, 50, 50));
    }

    @Test
    public void testBlueValueBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(50, 50, -30, 50));
    }

    @Test
    public void testAlphaValueBelowMinimum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(50, 50, 50, -40));
    }

    @Test
    public void testRedValueAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(300, 50, 50, 50));
    }

    @Test
    public void testGreenValueAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(50, 300, 50, 50));
    }

    @Test
    public void testBlueValueAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(50, 50, 300, 50));
    }

    @Test
    public void testAlphaValueAboveMaximum() {
        assertThrows(IllegalArgumentException.class, () -> new Color(50, 50, 50, 300));
    }
}
