package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import system.business.Project;
import system.business.User;
import system.dao.UserDao;

import java.util.Date;
import java.util.List;

/**
 * Created by krystof on 9/24/17.
 */

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean exists(String username) {
        return userDao.findByUsername(username) != null;
    }

    public void persist(User user) {
        if (exists(user.getUserName())) {
            //TODO: USERNAME ALLREADY IN USE
        } else {
            try {
                user.encodePassword(passwordEncoder);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            userDao.persist(user);
        }
    }

    public void update(User user) {
        if (exists(user.getUserName())) {
            //TODO: USERNAME DOES NOT EXIST
        } else {
            try {
                user.encodePassword(passwordEncoder);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            userDao.update(user);
        }
    }
}
