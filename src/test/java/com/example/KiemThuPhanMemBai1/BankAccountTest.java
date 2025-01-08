package com.example.KiemThuPhanMemBai1;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    // Kiểm thử các trường hợp biên
    @Test
    void testDepositBoundaryCases() {
        BankAccount account = new BankAccount("123456", 100.0);

        // Gửi tiền với số tiền bằng 0 (không hợp lệ)
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));

        // Gửi tiền hợp lệ
        account.deposit(100.0);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void testWithdrawBoundaryCases() {
        BankAccount account = new BankAccount("123456", 100.0);

        // Rút tiền bằng 0 (không hợp lệ)
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));

        // Rút toàn bộ số dư
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        BankAccount account = new BankAccount("123456", 100.0);

        // Rút nhiều hơn số dư hiện tại
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    // Kiểm thử tính đồng thời
    @Test
    void testConcurrentAccess() throws InterruptedException {
        BankAccount account = new BankAccount("123456", 1000.0);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 10 luồng gửi tiền 100 vào tài khoản
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> account.deposit(100.0));
        }

        // 10 luồng rút tiền 50 từ tài khoản
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> account.withdraw(50.0));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Chờ cho đến khi tất cả luồng hoàn thành
        }

        // Kiểm tra số dư cuối cùng
        assertEquals(1500.0, account.getBalance());
    }

    // Kiểm thử tính đồng nhất và độc lập của các phương thức
    @Test
    void testIndependentMethods() {
        BankAccount account = new BankAccount("123456", 500.0);

        // Thực hiện nhiều lần để đảm bảo tính lặp lại
        for (int i = 0; i < 5; i++) {
            account.deposit(100.0);
            assertEquals(500.0 + (i + 1) * 100.0, account.getBalance());
        }
    }
}
