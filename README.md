**Mô tả:**

Viết một chương trình Java đơn giản để quản lý một tài khoản ngân hàng, bao gồm các chức năng cơ bản như gửi tiền, rút tiền, và kiểm tra số dư. Sau đó, viết các kiểm thử đơn vị để đảm bảo các chức năng hoạt động đúng.

**Yêu cầu chi tiết:**

**Tạo lớp BankAccount với các thuộc tính và phương thức sau:**

Thuộc tính:
  accountNumber (String): Số tài khoản.
  balance (double): Số dư tài khoản.
Phương thức:
  deposit(double amount): Gửi tiền vào tài khoản.
  withdraw(double amount): Rút tiền từ tài khoản. Nếu số dư không đủ, ném IllegalArgumentException.
  getBalance(): Trả về số dư hiện tại.
**Viết lớp BankAccountTest để kiểm thử các phương thức trong BankAccount. Sử dụng JUnit 5.**

**Các kiểm thử cần thực hiện:**

Kiểm tra phương thức deposit():
  Đảm bảo số tiền được cộng vào số dư chính xác.
  Đảm bảo không cho phép gửi số tiền âm.
Kiểm tra phương thức withdraw():
  Đảm bảo số tiền được trừ khỏi số dư chính xác.
  Đảm bảo không cho phép rút số tiền lớn hơn số dư hiện tại.
  Đảm bảo không cho phép rút số tiền âm.
Kiểm tra phương thức getBalance():
  Đảm bảo trả về số dư đúng.

[Chat gpt tại đây!](https://chatgpt.com/share/677b56b8-8214-8004-b497-74d92085c2ab)

![image](https://github.com/user-attachments/assets/a20af14e-2b77-4ea8-85d7-9b231f9ea607)
