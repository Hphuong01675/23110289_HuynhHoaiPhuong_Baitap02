<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<style>
    body { font-family: Arial; background:#f4f6f9; display:flex; justify-content:center; align-items:center; height:100vh; }
    .container { background:#fff; padding:30px; border-radius:12px; width:350px; text-align:center; box-shadow:0 4px 12px rgba(0,0,0,0.15); }
    input, button { width:100%; padding:10px; margin:8px 0; border-radius:6px; border:1px solid #ccc; }
    button { background:#007bff; color:#fff; cursor:pointer; }
    .message { color:green; }
    .error { color:red; }
</style>
</head>
<body>
<div class="container">
    <h2>Quên mật khẩu</h2>

    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/forgot-password" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required>
        <input type="text" name="fullname" placeholder="Họ tên" required>
        <input type="text" name="sdt" placeholder="Số điện thoại" required>
        <input type="password" name="newPassword" placeholder="Mật khẩu mới" required>
        <button type="submit">Cấp lại mật khẩu</button>
    </form>

    <div style="margin-top:10px;">
        <a href="${pageContext.request.contextPath}/Views/Login.jsp">Quay lại đăng nhập</a>
    </div>
</div>
</body>
</html>
