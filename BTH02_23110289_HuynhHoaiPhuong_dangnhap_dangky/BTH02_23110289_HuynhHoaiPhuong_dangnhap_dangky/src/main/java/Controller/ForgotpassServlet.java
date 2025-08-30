package Controller;

import DAO.UserDao;
import DAO.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/forgot-password")
public class ForgotpassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String sdt = request.getParameter("sdt");
        String newPassword = request.getParameter("newPassword");

        boolean success = userDao.resetPassword(username, fullname, sdt, newPassword);

        if (success) {
            request.setAttribute("message", "Mật khẩu đã được cấp lại thành công!");
        } else {
            request.setAttribute("error", "Thông tin không đúng hoặc có lỗi, vui lòng thử lại!");
        }

        request.getRequestDispatcher("/Views/Forgotpass.jsp").forward(request, response);
    }
}
