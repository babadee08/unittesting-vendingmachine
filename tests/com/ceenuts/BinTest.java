package com.ceenuts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinTest {

    private Bin bin;

    /*@Rule
    public ExpectedException thrown = ExpectedException.none();*/

    @BeforeEach
    void setUp() {
        bin = new Bin(10);
    }

    @Test
    void restockingWithDifferentItemIsNotAllowed() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            bin.restock("Cheetos", 1, 100, 50);
            bin.restock("Doritos", 1, 100, 50);
        });
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void restockingWithDifferentItemIsNotAllowed() throws Exception {
        bin.restock("Cheetos", 1, 100, 50);
        bin.restock("Doritos", 1, 100, 50);
    }*/

    @Test
    void whenEmptyPriceIsZero() {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    void whenEmptyNameIsNull() {
        assertNull(bin.getItemName());
    }

    @Test
    void overstockingNotAllowed() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            bin.restock("Fritos", 2600, 100, 50);
        });
        assertEquals("There are only 10 spots left", thrown.getMessage());

        /*thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");*/
    }
}