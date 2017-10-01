package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Degree;
import system.business.Project;

import static org.junit.Assert.*;

/**
 * Created by krystof on 10/1/17.
 */
public class DegreeDaoTest extends BaseDaoTestRunner{

    @Autowired
    private DegreeDao degreeDao;

    @Test
    public void findByName() throws Exception {
        final Degree degree = new Degree();
        degree.setName("Advanced Situational Comedy");
        degreeDao.persist(degree);
        final Degree result = degreeDao.findByName(degree.getName());
        assertNotNull(result);
        assertEquals(degree.getId(), result.getId());
    }

}