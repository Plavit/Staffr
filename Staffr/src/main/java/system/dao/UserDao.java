package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.business.Skill;
import system.business.User;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Krystof&Marek on 06.01.2017.
 */
@Repository
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }

    public User findByUsername(String username) {
        try {
            return em.createNamedQuery("User.findByUsername", User.class).setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        try {
            return em.createNamedQuery("User.findAll", User.class)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean exists(String username) {
        try {
            return em.createNamedQuery("User.findByUsername", User.class)
                    .setParameter("username", username)
                    .getResultList().size() > 0;
        } catch (NoResultException e) {
            return false;
        }
    }

    public void addSkill(Skill newSkill) {
        em.createNamedQuery("User.addSkill", User.class).setParameter("newSkill", newSkill).executeUpdate();
    }
}
