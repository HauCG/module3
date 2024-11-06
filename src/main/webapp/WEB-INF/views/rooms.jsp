<%--
  Created by IntelliJ IDEA.
  User: maitr
  Date: 11/6/2024
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Room Management System</title>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1>Danh sách Phòng</h1>

    <a href="/rooms?action=create" class="btn btn-success float-end">Add New Room</a>

    <table class="table table-bordered">
        <thead class="table-light">
        <tr>
            <th>ID phòng</th>
            <th>Tên người thuê</th>
            <th>Số điện thoại người thuê</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Trả tiền thuê theo</th>
            <th>Ghi chú</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td>${room.roomId}</td>
                <td>${room.renterName}</td>
                <td>${room.renterPhoneNumber}</td>
                <td>${room.rentStartDate}</td>
                <td>${room.paymentMethodName}</td>
                <td>${room.note}</td>
                <td>
                    <a class="btn btn-danger btn-sm" href="/rooms?action=delete&idRoom=${room.roomId}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
