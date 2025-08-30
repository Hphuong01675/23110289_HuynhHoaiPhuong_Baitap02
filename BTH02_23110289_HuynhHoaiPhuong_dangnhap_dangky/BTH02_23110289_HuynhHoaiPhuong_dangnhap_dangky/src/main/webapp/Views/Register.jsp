<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<style>
    body { font-family: Arial, sans-serif; background:#f4f6f9; display:flex; justify-content:center; align-items:center; height:100vh; }
    .container { background:#fff; padding:30px 40px; border-radius:12px; box-shadow:0 4px 12px rgba(0,0,0,0.15); width:350px; text-align:center; }
    h2 { color:#28a745; }
    .error { color:red; margin:10px 0; }
    .success { color:green; margin:10px 0; }
    input[type=text], input[type=password] { width:90%; padding:10px; margin:8px 0; border:1px solid #ccc; border-radius:6px; }
    button { background:#28a745; color:#fff; border:none; padding:10px 20px; border-radius:6px; cursor:pointer; }
    button:hover { background:#1e7e34; }
    a { display:block; margin-top:15px; color:#007bff; text-decoration:none; }
    a:hover { text-decoration:underline; }
</style>
</head>
<body>
<div class="container">
    <h2>Đăng ký</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required><br>
        <input type="password" name="password" placeholder="Mật khẩu" required><br>
        <input type="text" name="fullname" placeholder="Họ tên" required><br>
        <input type="text" name="sdt" placeholder="Số điện thoại" required><br>
        <button type="submit">Đăng ký</button>
    </form>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty success}">
        <div class="success">${success}</div>
    </c:if>
    <a href="${pageContext.request.contextPath}/Views/Login.jsp">Đã có tài khoản? Đăng nhập</a>
</div>
</body>
</html>
