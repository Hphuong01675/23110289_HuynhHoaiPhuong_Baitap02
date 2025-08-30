package DAO;

import Model.User;

public interface UserDao {
    User login(String username, String password);
    boolean register(User user);
    boolean checkExistUsername(String username);
    boolean resetPassword(String username, String fullname, String sdt, String newPass);
}
