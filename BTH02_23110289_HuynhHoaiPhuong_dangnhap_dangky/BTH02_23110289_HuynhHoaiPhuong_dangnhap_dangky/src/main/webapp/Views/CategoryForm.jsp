<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="Model.Category" %>

<%
Category category = (Category) request.getAttribute("category");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category != null ? "Sửa Category" : "Thêm Category"}</title>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f4f6f9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background: #fff;
    padding: 30px;
    border-radius: 12px;
    width: 400px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.15);
}

h2 {
    text-align: center;
    color: #333;
}

input, textarea, button {
    width: 100%;
    padding: 10px;
    margin: 8px 0;
    border-radius: 6px;
    border: 1px solid #ccc;
    font-size: 14px;
}

button {
    background: #007bff;
    color: #fff;
    font-weight: bold;
    cursor: pointer;
    transition: background 0.3s;
}

button:hover {
    background: #0056b3;
}

a {
    display: block;
    text-align: center;
    margin-top: 10px;
    color: #007bff;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
<div class="container">
    <h2>${category != null ? "Sửa Category" : "Thêm Category"}</h2>
    <form action="${pageContext.request.contextPath}/category" method="post">
        <input type="hidden" name="id" value="${category != null ? category.id : ''}">
        <input type="text" name="name" placeholder="Tên Category" 
               value="${category != null ? category.name : ''}" required>
        <textarea name="description" placeholder="Mô tả" rows="3">${category != null ? category.description : ''}</textarea>
        <button type="submit">${category != null ? "Cập nhật" : "Thêm mới"}</button>
    </form>
    <a href="${pageContext.request.contextPath}/category-list">Quay lại danh sách</a>
</div>
</body>
</html>
