package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.business.Employee;
import system.business.Experience;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 10/1/17.
 */

@Repository
public class ExperienceDao extends BaseDao<Experience>{

    protected ExperienceDao() {
        super(Experience.class);
    }

    @Transactional(readOnly = true)
    public Experience findByName(String name) {
        Objects.requireNonNull(name);
        try {
            return em.createNamedQuery("Experience.findByName", Experience.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
