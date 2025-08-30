package Controller;

import DAO.CategoryDao;
import DAO.CategoryDaoImpl;
import Model.Category;
import Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;

    @Override
    public void init() {
        categoryDao = new CategoryDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/Views/Login.jsp");
            return;
        }

        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            categoryDao.deleteCategory(id, user.getUsername());
            response.sendRedirect(request.getContextPath() + "/category-list");
            return;
        }

        // mặc định show danh sách
        response.sendRedirect(request.getContextPath() + "/category-list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/Views/Login.jsp");
            return;
        }

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setUsername(user.getUsername());

        categoryDao.addCategory(category);
        response.sendRedirect(request.getContextPath() + "/category-list");
    }
}
