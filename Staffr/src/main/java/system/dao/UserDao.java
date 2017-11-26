package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.business.User;

import javax.persistence.NoResultException;

/**
 * Created by HMT on 06.01.2017.
 */
@Repository
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }

    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        try {
            return em.createNamedQuery("User.findByUsername", User.class).setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    @Transactional
    public void deleteById(int id) {
        try {
            em.createNamedQuery("User.deleteById", User.class).setParameter("id", id).executeUpdate();


        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }


}
