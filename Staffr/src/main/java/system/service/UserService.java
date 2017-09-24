package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.Employee;
import system.business.User;
import system.dao.EmployeeDao;
import system.dao.UserDao;

/**
 * Created by krystof on 9/24/17.
 */

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void persist(User t) {
        userDao.persist(t);
    }

    public void update(User t){
        userDao.update(t);
    }
}
