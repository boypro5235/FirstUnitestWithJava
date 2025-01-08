# **Mô tả:**

Viết một chương trình Java đơn giản để quản lý một tài khoản ngân hàng, bao gồm các chức năng cơ bản như gửi tiền, rút tiền, và kiểm tra số dư. Sau đó, viết các kiểm thử đơn vị để đảm bảo các chức năng hoạt động đúng.

# **Yêu cầu chi tiết:**

**Tạo lớp BankAccount với các thuộc tính và phương thức sau:**

Thuộc tính:
  accountNumber (String): Số tài khoản.
  balance (double): Số dư tài khoản.
Phương thức:
  deposit(double amount): Gửi tiền vào tài khoản.
  withdraw(double amount): Rút tiền từ tài khoản. Nếu số dư không đủ, ném IllegalArgumentException.
  getBalance(): Trả về số dư hiện tại.
  
# **Viết lớp BankAccountTest để kiểm thử các phương thức trong BankAccount. Sử dụng JUnit 5.**

**Mục tiêu kiểm thử**
Kiểm tra tính năng cơ bản của lớp BankAccount:

deposit(): Thêm tiền vào tài khoản.
withdraw(): Rút tiền từ tài khoản.
getBalance(): Lấy số dư hiện tại của tài khoản.
Đảm bảo tính đúng đắn của các chức năng:

Xử lý các trường hợp biên (số tiền bằng 0, số tiền âm, rút toàn bộ số dư).
Xử lý các trường hợp lỗi như rút nhiều hơn số dư.
Đảm bảo tính an toàn khi sử dụng trong môi trường đa luồng:

Kiểm tra tính đồng bộ của các thao tác gửi tiền và rút tiền khi có nhiều luồng truy cập đồng thời.

**Tuân theo nguyên tắc FIRST của kiểm thử phần mềm:**

Nhanh chóng (Fast): Các kiểm thử được thiết kế đơn giản và chạy nhanh.
Độc lập (Independent): Các kiểm thử không phụ thuộc vào kết quả của nhau.
Có thể lặp lại (Repeatable): Mỗi lần chạy kiểm thử đều cho kết quả giống nhau trong cùng điều kiện.
Tự xác nhận (Self-validating): Các kiểm thử sử dụng các biểu thức kiểm tra (assertEquals, assertThrows) để xác minh kết quả.
Kịp thời (Timely): Tập trung vào các chức năng chính của ứng dụng.
Các kịch bản kiểm thử chính
**Kiểm thử cơ bản:**

testDeposit(): Đảm bảo tiền gửi được cộng chính xác vào số dư. Kiểm tra trường hợp gửi số tiền âm.
testWithdraw(): Đảm bảo tiền rút được trừ chính xác từ số dư. Kiểm tra các trường hợp lỗi như rút quá số dư, rút số tiền âm.
testGetBalance(): Đảm bảo số dư trả về đúng với trạng thái hiện tại của tài khoản.
**Kiểm thử trường hợp biên:**

Gửi tiền bằng 0 (không hợp lệ).
Rút tiền bằng 0 (không hợp lệ).
Rút toàn bộ số dư.
Kiểm thử tính đồng thời:

Kiểm tra tính an toàn khi nhiều luồng thực hiện thao tác gửi tiền và rút tiền đồng thời.
**Kiểm thử tính đồng nhất và độc lập:**

Kiểm tra tính nhất quán của các phương thức khi được thực thi lặp đi lặp lại.


[Chat gpt tại đây!](https://chatgpt.com/share/677b56b8-8214-8004-b497-74d92085c2ab)

![image](https://github.com/user-attachments/assets/f44acea3-9f59-49f8-9174-8e2a5a18b6f0)

