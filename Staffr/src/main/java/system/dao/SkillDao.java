package system.dao;

import org.springframework.transaction.annotation.Transactional;
import system.business.Skill;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 10/1/17.
 */
public class SkillDao extends BaseDao<Skill> {

    protected SkillDao() {
        super(Skill.class);
    }

    @Transactional(readOnly = true)
    public Skill findByName(String name) {
        Objects.requireNonNull(name);
        try {
            return em.createNamedQuery("Skill.findByName", Skill.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}