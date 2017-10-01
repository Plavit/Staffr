package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Experience;
import system.business.Project;

import static org.junit.Assert.*;

/**
 * Created by krystof on 10/1/17.
 */
public class ExperienceDaoTest extends BaseDaoTestRunner {

    @Autowired
    private ExperienceDao experienceDao;

    @Test
    public void findByName() throws Exception {
        final Experience experience = new Experience();
        experience.setName("Garbage collection");
        experience.setNote("bla, bla");
        experienceDao.persist(experience);
        final Experience result = experienceDao.findByName(experience.getName());
        assertNotNull(result);
        assertEquals(experience.getId(), result.getId());
    }

}