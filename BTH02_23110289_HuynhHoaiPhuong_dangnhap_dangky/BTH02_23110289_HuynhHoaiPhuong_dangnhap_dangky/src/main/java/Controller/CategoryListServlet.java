package Controller;

import DAO.CategoryDao;
import DAO.CategoryDaoImpl;
import Model.Category;
import Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/category-list")
public class CategoryListServlet extends HttpServlet {
    private CategoryDao categoryDao;

    @Override
    public void init() { categoryDao = new CategoryDaoImpl(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            response.sendRedirect(request.getContextPath() + "/Views/Login.jsp");
            return;
        }

        List<Category> categories = categoryDao.getCategoriesByUser(user.getUsername());
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/Views/CategoryList.jsp").forward(request, response);
    }
}
