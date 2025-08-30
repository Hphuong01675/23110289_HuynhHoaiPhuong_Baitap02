package Controller;

import Service.UserService;
import Service.UserServiceImpl;
import Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String sdt = request.getParameter("sdt");

        boolean success = userService.register(username, password, fullname, sdt);

        if (success) {
            // Thêm thông báo thành công
            request.setAttribute("message", "Đăng ký thành công! Bạn có thể đăng nhập ngay.");
            request.getRequestDispatcher("/Views/Login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Tên đăng nhập đã tồn tại hoặc có lỗi. Vui lòng thử lại!");
            request.getRequestDispatcher("/Views/Register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/Views/Register.jsp");
    }
}
