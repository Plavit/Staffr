package system.dao;

import org.springframework.transaction.annotation.Transactional;
import system.business.Project;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 10/1/17.
 */
public class ProjectDao extends BaseDao<Project> {

    protected ProjectDao() {
        super(Project.class);
    }

    @Transactional(readOnly = true)
    public Project findByName(String name) {
        Objects.requireNonNull(name);
        try {
            return em.createNamedQuery("Project.findByName", Project.class)
                    .setParameter("name", name.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}