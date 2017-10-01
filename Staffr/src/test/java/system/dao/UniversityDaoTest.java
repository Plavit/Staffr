package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Project;
import system.business.University;

import static org.junit.Assert.*;

/**
 * Created by krystof on 10/1/17.
 */
public class UniversityDaoTest extends BaseDaoTestRunner {
    @Autowired
    private UniversityDao universityDao;

    @Test
    public void findByName() throws Exception {
        final University university = new University();
        university.setName("CVUT");
        universityDao.persist(university);
        final University result = universityDao.findByName(university.getName());
        assertNotNull(result);
        assertEquals(university.getId(), result.getId());
    }
}