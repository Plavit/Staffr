package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.User;
import system.dao.GenericDao;
import system.dao.UserDao;

@Service
public class UserService extends AbstractRepositoryService<User> {

    private final UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<User> getPrimaryDao() {
        return dao;
    }
}
