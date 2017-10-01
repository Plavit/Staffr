package system.dao;

import org.springframework.transaction.annotation.Transactional;
import system.business.University;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 10/1/17.
 */
public class UniversityDao extends BaseDao<University> {

    protected UniversityDao() {
        super(University.class);
    }

    @Transactional(readOnly = true)
    public University findByName(String name) {
        Objects.requireNonNull(name);
        try {
            return em.createNamedQuery("University.findByName", University.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}