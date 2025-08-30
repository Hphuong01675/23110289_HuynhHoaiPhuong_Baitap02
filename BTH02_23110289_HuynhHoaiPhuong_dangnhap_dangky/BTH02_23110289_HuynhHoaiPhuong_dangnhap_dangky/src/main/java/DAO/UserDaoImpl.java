package DAO;

import Model.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(String username, String password) {
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("fullname"),
                        rs.getString("sdt")
                );
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean checkExistUsername(String username) {
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean register(User user) {
        if (checkExistUsername(user.getUsername())) return false;
        try (Connection conn = DBConnect.getConnection()) {
            String sql = "INSERT INTO users(username,password,fullname,sdt) VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getSdt());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean resetPassword(String username, String fullname, String sdt, String newPass) {
        try (Connection conn = DBConnect.getConnection()) {
            String sqlCheck = "SELECT * FROM users WHERE username=? AND fullname=? AND sdt=?";
            PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setString(1, username);
            psCheck.setString(2, fullname);
            psCheck.setString(3, sdt);
            ResultSet rs = psCheck.executeQuery();
            if (rs.next()) {
                String sqlUpdate = "UPDATE users SET password=? WHERE username=?";
                PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
                psUpdate.setString(1, newPass);
                psUpdate.setString(2, username);
                return psUpdate.executeUpdate() > 0;
            }
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
