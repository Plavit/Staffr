package system.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.User;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    @Autowired
    private UserDao dao;

    @Autowired
    private SkillDao skillDao;

    @Test
    public void findAllReturnsUsersOrderedByNameDescending() {

        final User Peter_Smith = new User();
        Peter_Smith.setFirstName("Peter");
        Peter_Smith.setLastName("Smith");
        Peter_Smith.setEmail("P.SmithYo@Yahoo.com");
        //u.setId(124);

        final User Charlotte_Guido = new User();
        Charlotte_Guido.setFirstName("Charlotte");
        Charlotte_Guido.setLastName("Guido");
        Charlotte_Guido.setEmail("CG-see-gay@seznam.cz");
        //u.setId(125);

        final User Ivan_Terrible = new User();
        Ivan_Terrible.setFirstName("Ivan");
        Ivan_Terrible.setLastName("Terrible");
        Ivan_Terrible.setEmail("Impala@google.com");
        //u.setId(126);

        List<User> users = new LinkedList<User>();
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