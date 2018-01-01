package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.User;
import system.dao.GenericDao;
import system.dao.UserDao;

import java.util.Objects;

@Service
@Transactional
public class UserService extends AbstractRepositoryService<User> {

    private final UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<User> getPrimaryDao() {
        return dao;
    }

    @Override
    public void persist(User instance) {
        try {
            if (exists(instance.getUserName())) {
                System.out.println("User allready exists");
            } else {
                if (instance.getPassword()!=null) {
                    instance.encodePassword(passwordEncoder);
                }
                super.persist(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findUserByUsername(String username) {
        return dao.findByUsername(username);
    }

    public boolean exists(String username) {
//        Objects.requireNonNull(username);
        return dao.exists(username);
    }
}
