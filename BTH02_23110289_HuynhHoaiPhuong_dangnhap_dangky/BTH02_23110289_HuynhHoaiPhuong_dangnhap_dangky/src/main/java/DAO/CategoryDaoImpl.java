package DAO;

import Model.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public List<Category> getCategoriesByUser(String username) {
        List<Category> list = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM Category WHERE username=? ORDER BY id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                list.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("username")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public boolean addCategory(Category category) {
        try (Connection conn = DBConnect.getConnection()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT ISNULL(MAX(id),0)+1 AS nextId FROM Category WHERE username='"+category.getUsername()+"'"
            );
            int nextId = 1;
            if(rs.next()) nextId = rs.getInt("nextId");

            String sql = "INSERT INTO Category(id,name,description,username) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, nextId);
            ps.setString(2, category.getName());
            ps.setString(3, category.getDescription());
            ps.setString(4, category.getUsername());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteCategory(int id, String username) { // ✅ thứ tự tham số giống interface
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "DELETE FROM Category WHERE username=? AND id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
