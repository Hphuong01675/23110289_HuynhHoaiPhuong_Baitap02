package DAO;

import Model.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getCategoriesByUser(String username);
    boolean addCategory(Category category);
    boolean deleteCategory(int id, String username); // thứ tự: int, String
}
