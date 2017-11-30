package system.dao;

import org.springframework.stereotype.Repository;
import system.business.User;
import system.business.UserProject;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */

@Repository
public class UserProjectDao extends BaseDao<UserProject> {

    protected UserProjectDao() {
        super(UserProject.class);
    }

    public List<UserProject> findByUserAndStartingDate(User userID, LocalDate startingDate) {
        try {
            List<UserProject> ret = em.createNamedQuery("UserProject.findByUserAndStartingDate", UserProject.class)
                    .setParameter("userID",userID).setParameter("startingDate",startingDate).getResultList();
            return ret;
        } catch (NoResultException e) {
            return null;
        }
    }
}
