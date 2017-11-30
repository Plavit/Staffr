package system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import system.business.Skill;
import system.business.User;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Repository
public class SkillDao extends BaseDao<Skill>{
    protected SkillDao() {
        super(Skill.class);
    }

    public List<Skill> getAllSkillsByUser(User user){
        try {
            return em.createNamedQuery("Skill.findByUser", Skill.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
