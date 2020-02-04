package com.ceenuts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditorTest {

    private Creditor creditor;

    @BeforeEach
    void setUp() {
        creditor = new Creditor();
    }

    @Test
    void addingFundsIncrementsAvailableFunds() {
        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    void refundingReturnsAllAvailableFunds() {
        creditor.addFunds(10);

        int refund = creditor.refund();

        assertEquals(10, refund);
    }

    @Test
    void refundingResetsAvailableFundsToZero() {
        creditor.addFunds(10);

        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());
    }

    @Test
    void deductingMoreThanAllowedFundsIsNotAllowed() {
        assertThrows(NotEnoughFundsException.class, () -> {
            creditor.addFunds(10);
            creditor.deduct(12);
        });
    }
}