<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<%@ page import="Model.Category" %>
<%@ page import="DAO.CategoryDaoImpl" %>

<%
User user = (User) session.getAttribute("user");
if (user == null) {
    response.sendRedirect(request.getContextPath() + "/Views/Login.jsp");
    return;
}
CategoryDaoImpl dao = new CategoryDaoImpl();
List<Category> categories = dao.getCategoriesByUser(user.getUsername());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách Category</title>
<style>
body {
    font-family: Arial, sans-serif;
    background: #f4f6f9;
    padding: 20px;
}

h2 {
    color: #333;
    text-align: center;
}

a.add-btn {
    display: inline-block;
    background: #28a745;
    color: #fff;
    padding: 8px 12px;
    border-radius: 6px;
    text-decoration: none;
    margin-bottom: 10px;
}

a.add-btn:hover {
    background: #218838;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
    background: #fff;
    border-radius: 6px;
    overflow: hidden;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}

th, td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
    text-align: center;
}

th {
    background: #007bff;
    color: white;
}

tr:hover {
    background: #f1f1f1;
}

a.delete-btn {
    color: #dc3545;
    text-decoration: none;
    font-weight: bold;
}

a.delete-btn:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
<h2>Danh sách Category của ${user.username}</h2>
<a class="add-btn" href="${pageContext.request.contextPath}/Views/CategoryAdd.jsp">Thêm Category</a>
<table>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Thao tác</th>
    </tr>
    <%
    for (Category c : categories) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getName() %></td>
        <td><%= c.getDescription() %></td>
        <td>
            <a class="delete-btn" href="<%= request.getContextPath() %>/category?action=delete&id=<%= c.getId() %>">Xóa</a>
        </td>
    </tr>
    <%
    }
    %>
</table>
</body>
</html>
