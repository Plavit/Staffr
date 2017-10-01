package system.dao;

import org.springframework.stereotype.Repository;
import system.business.UserProject;

/**
 * Created by krystof on 10/1/17.
 */

@Repository
public class UserProjectDao extends BaseDao<UserProject> {

    protected UserProjectDao() {
        super(UserProject.class);
    }
}
