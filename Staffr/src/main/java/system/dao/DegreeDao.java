package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.business.Degree;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 10/1/17.
 */
@Repository
public class DegreeDao extends BaseDao<Degree>{

    protected DegreeDao() {
        super(Degree.class);
    }

    @Transactional(readOnly = true)
    public Degree findByName(String name) {
        Objects.requireNonNull(name);
        try {
            return em.createNamedQuery("Experience.findByName", Degree.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

