<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<style>
    body { font-family: Arial, sans-serif; background:#f4f6f9; display:flex; justify-content:center; align-items:center; height:100vh; }
    .container { background:#fff; padding:30px 40px; border-radius:12px; box-shadow:0 4px 12px rgba(0,0,0,0.15); width:350px; text-align:center; }
    h2 { color:#007bff; }
    .error { color:red; margin:10px 0; }
    input[type=text], input[type=password] { width:90%; padding:10px; margin:8px 0; border:1px solid #ccc; border-radius:6px; }
    button { background:#007bff; color:#fff; border:none; padding:10px 20px; border-radius:6px; cursor:pointer; }
    button:hover { background:#0056b3; }
    a { display:block; margin-top:15px; color:#28a745; text-decoration:none; }
    a:hover { text-decoration:underline; }
</style>
</head>
<body>
<div class="container">
    <h2>Đăng nhập</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="username" placeholder="Tên đăng nhập" required><br>
        <input type="password" name="password" placeholder="Mật khẩu" required><br>
        <button type="submit">Đăng nhập</button>
    </form>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <a href="${pageContext.request.contextPath}/Views/Register.jsp">Chưa có tài khoản? Đăng ký</a>
</div>
</body>
</html>
