package system.dao;

import org.springframework.stereotype.Repository;
import system.business.UserProject;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */

@Repository
public class UserProjectDao extends BaseDao<UserProject> {

    protected UserProjectDao() {
        super(UserProject.class);
    }

    public List<UserProject> findByUserAndStartingDate(Integer userID, Date startingDate) {
        try {
            return em.createNamedQuery("UserProject.findByUserAndStartingDate", UserProject.class)
                            .setParameter(userID, startingDate).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
