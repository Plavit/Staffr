package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Project;
import system.business.User;

import static org.junit.Assert.*;

/**
 * Created by krystof on 10/1/17.
 */
public class UserDaoTest extends BaseDaoTestRunner {

    @Autowired
    private UserDao userDao;

    @Test
    public void findByName() throws Exception {
        final User user = new User();
        user.setUserName("seleszm");
        userDao.persist(user);
        final User result = userDao.findByUsername(user.getUserName());
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
    }

}