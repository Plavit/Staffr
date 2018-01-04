package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.User;
import system.dao.GenericDao;
import system.dao.UserDao;

import java.util.Optional;


@Service
public class UserService extends AbstractRepositoryService<User> {

    private final UserDao dao;

    @Autowired
    public UserService(UserDao dao) {
        this.dao = dao;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected GenericDao<User> getPrimaryDao() {
        return dao;
    }

    @Override
    void prePersist(User instance) {
        persistSkills(instance);
    }

    @Override
    @Transactional
    public void persist(User instance) {
        try {
            if (exists(instance.getUserName())) {
                System.out.println("User already exists");
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

    private void persistSkills(User instance) {
        Optional.ofNullable(instance.getSkills())
                .ifPresent(
                        skills -> skills.stream()
                                .filter(t -> t.getUser() == null)
                                .forEach(
                                        t -> {
                                            t.setUser(instance);
                                        }
                                )
                );
    }
}
