package com.example.KiemThuPhanMemBai1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("123456", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("123456", 100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    void testGetBalance() {
        BankAccount account = new BankAccount("123456", 100.0);
        assertEquals(100.0, account.getBalance());
    }
}
