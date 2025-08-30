<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style>
    body { font-family: Arial, sans-serif; background:#f4f6f9; display:flex; justify-content:center; align-items:center; height:100vh; }
    .container { background:#fff; padding:30px 40px; border-radius:12px; box-shadow:0 4px 12px rgba(0,0,0,0.15); width:350px; text-align:center; }
    h2 { color:#28a745; }
    a { display:block; margin-top:15px; color:#007bff; text-decoration:none; }
    a:hover { text-decoration:underline; }
</style>
</head>
<body>
<%
    // Lấy user từ session
    User user = (User) session.getAttribute("user");

    // Nếu chưa login, redirect về Login.jsp
    if(user == null) {
        response.sendRedirect(request.getContextPath() + "/Views/Login.jsp");
        return;
    }
%>
<div class="container">
    <h2>Chào mừng, <%= user.getUsername() %>!</h2>
    <p>Bạn đã đăng nhập thành công 🎉</p>
    <a href="<%= request.getContextPath() %>/Views/Login.jsp">Đăng xuất</a>
</div>
</body>
</html>
