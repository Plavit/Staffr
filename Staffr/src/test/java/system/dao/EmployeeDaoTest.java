package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Employee;
import system.business.Office;
import system.business.Skill;
import system.business.enums.Status;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Marek on 24.9.2017.
 */
public class EmployeeDaoTest extends BaseDaoTestRunner{

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findEmployeeByName(){
        final Office prague = new Office();
        prague.setName("Prague");
        //locationDao.persist(Prague);

        final Office berlin = new Office();
        berlin.setName("Berlin");
        //locationDao.persist(Prague);

        final Office l = new Office();
        l.setName("asdf");
//        locationDao.persist(l);

        final Skill skill1 = new Skill();
        skill1.setName("HTML");
//        skillDao.persist(skill1);

        final Skill skill2 = new Skill();
        skill2.setName("CSS");
//        skillDao.persist(skill2);

        final Skill skill3 = new Skill();
        skill3.setName("PHP");
//        skillDao.persist(skill3);

        HashSet skills = new HashSet();
        skills.add(skill1);
        skills.add(skill3);

        HashSet ar = new HashSet();
        ar.add(prague);
        ar.add(berlin);

        final Employee v = new Employee();
        v.setFirstName("Antonin");
        v.setLastName("Smith");
        v.setEmail("Smith@Something.com");
        v.setPhoneNumber(111222333);

        employeeDao.persist(v);
        final Employee result = employeeDao.findByName(v.getFirstName(), v.getLastName());

        //testprint result
        System.out.println(result);

        //check if result not empty
        assertNotNull(result);
        assertEquals(v.getId(), result.getId());

    }
}
