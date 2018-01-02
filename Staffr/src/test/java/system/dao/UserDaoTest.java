package system.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.User;
import system.business.enums.Role;
import system.business.enums.Status;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class UserDaoTest  extends BaseDaoTestRunner {

    @Autowired
    private UserDao dao;

    @Test
    public void findAllReturnsUsersOrderedByNameDescending() {

        final User Peter_Smith = new User("PS","PSW", Role.USER_ROLE,"Peter","Smith",1986,"P.SmithYo@Yahoo.com","",3, Status.ACTIVE);

        final User Charlotte_Guido = new User("CG","PSW", Role.USER_ROLE,"Charlotte","Guido",1986,"CG-see-gay@seznam.cz","",3, Status.ACTIVE);

        final User Ivan_Terrible = new User("IT","PSW", Role.USER_ROLE,"Ivan","Terrible",1986,"Impala@google.com","",3, Status.ACTIVE);

        List<User> users = new LinkedList<>();
        users.add(Ivan_Terrible);
        users.add(Charlotte_Guido);
        users.add(Peter_Smith);

        Collections.shuffle(users);
        dao.persist(users);

        final List<User> result = dao.findAll();
        Assert.assertEquals(users.size(), result.size());
        assertNameDescendingOrder(result);
    }

    private void assertNameDescendingOrder(List<User> users) {
        if (users.size() == 0) {
            return;
        }

        User previous = users.get(0);
        for (int i = 1; i < users.size(); i++) {
            final User current = users.get(i);
            assertTrue(current.getLastName().compareTo(previous.getLastName())<=0);
            previous = current;
        }
    }
}