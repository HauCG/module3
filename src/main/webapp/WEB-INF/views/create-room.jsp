<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 11/6/2024
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Phòng Mới</title>
</head>
<body>
<div class="container">
    <h1>Thêm Phòng Mới</h1>
    <form action="rooms" method="post">
        <input type="hidden" name="action" value="create">

        <div class="form-group">
            <label for="renterName">Tên Người Thuê:</label>
            <input type="text" id="renterName" name="renterName" required>
        </div>

        <div class="form-group">
            <label for="renterPhoneNumber">Số Điện Thoại:</label>
            <input type="text" id="renterPhoneNumber" name="renterPhoneNumber" required>
        </div>

        <div class="form-group">
            <label for="rentStartDate">Ngày Bắt Đầu Thuê:</label>
            <input type="date" id="rentStartDate" name="rentStartDate" required>
        </div>

        <div class="form-group">
            <label for="paymentMethodId">Phương Thức Thanh Toán:</label>
            <select id="paymentMethodId" name="paymentMethodId" required>
                <option value="1">Theo tháng</option>
                <option value="2">Theo quý</option>
                <option value="3">Theo năm</option>
            </select>
        </div>

        <div class="form-group">
            <label for="note">Ghi Chú:</label>
            <input type="text" id="note" name="note">
        </div>

        <button type="submit">Lưu Phòng</button>
    </form>

    <a href="rooms" class="btn-secondary">Quay lại Danh Sách Phòng</a>
</div>
</body>
</html>
