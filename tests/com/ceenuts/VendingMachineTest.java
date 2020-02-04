package com.ceenuts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    private VendingMachine machine;

    public class NotifierSub implements Notifier {

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @BeforeEach
    void setUp() throws Exception {
        Notifier notifier = new NotifierSub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "Twinkies", 9, 30, 75);
    }

    @Test
    void vendingWhenStockedReturnsItem() throws Exception {
        machine.addMoney(75);

        Item item = machine.vend("A1");

        assertEquals("Twinkies", item.getName());
    }

    @Test
    void runningSalesTotalIsIncrementedAfterEverySales() throws Exception {
        machine.addMoney(75);
        Item item = machine.vend("A1");

        assertEquals(75, machine.getRunningSalesTotal());
    }
}