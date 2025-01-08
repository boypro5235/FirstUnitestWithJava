package com.example.KiemThuPhanMemBai1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    // Phương thức này sẽ được gọi trước mỗi kiểm thử để khởi tạo đối tượng BankAccount
    @BeforeEach
    void setUp() {
        account = new BankAccount("123456", 100.0); // Thiết lập đối tượng mới trước mỗi kiểm thử
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testWithdraw() {
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    void testGetBalance() {
        assertEquals(100.0, account.getBalance());
    }

    // Kiểm thử các trường hợp biên
    @Test
    void testDepositBoundaryCases() {
        // Gửi tiền với số tiền bằng 0 (không hợp lệ)
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));

        // Gửi tiền hợp lệ
        account.deposit(100.0);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    void testWithdrawBoundaryCases() {
        // Rút tiền bằng 0 (không hợp lệ)
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));

        // Rút toàn bộ số dư
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        // Rút nhiều hơn số dư hiện tại
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200.0));
    }

    // Kiểm thử tính đồng nhất và độc lập của các phương thức
    @Test
    void testIndependentMethods() {
        // Thực hiện nhiều lần để đảm bảo tính lặp lại
        for (int i = 0; i < 5; i++) {
            account.deposit(100.0);
            assertEquals(100.0 + (i + 1) * 100.0, account.getBalance());
        }
    }
}
