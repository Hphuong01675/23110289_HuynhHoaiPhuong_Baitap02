package Service;

import DAO.UserDao;
import DAO.UserDaoImpl;
import Model.User;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return dao.login(username, password);
    }

    @Override
    public boolean register(String username, String password, String fullname, String sdt) {
        if (dao.checkExistUsername(username)) {
            return false; // username đã tồn tại
        }
        User user = new User(username, password, fullname, sdt);
        return dao.register(user);
    }

    @Override
    public boolean resetPassword(String username, String fullname, String sdt, String newpass) {
        return dao.resetPassword(username, fullname, sdt, newpass);
    }
}
