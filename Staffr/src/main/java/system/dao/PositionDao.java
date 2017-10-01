package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import system.business.Position;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 10/1/17.
 */

@Repository
public class PositionDao extends BaseDao<Position>{

    protected PositionDao() {
        super(Position.class);
    }

    @Transactional(readOnly = true)
    public Position findByName(String name) {
        Objects.requireNonNull(name);
        try {
            return em.createNamedQuery("Position.findByName", Position.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

