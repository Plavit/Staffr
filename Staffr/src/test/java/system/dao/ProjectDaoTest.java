package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Project;

import static org.junit.Assert.*;

/**
 * Created by krystof on 10/1/17.
 */
public class ProjectDaoTest extends BaseDaoTestRunner{

    @Autowired
    private ProjectDao projectDao;

    @Test
    public void findByName() throws Exception {
        final Project project = new Project();
        project.setName("Staffr First Project");
        project.setDescription("The bestest project in the world.");
        projectDao.persist(project);
        final Project result = projectDao.findByName(project.getName());
        assertNotNull(result);
        assertEquals(project.getId(), result.getId());
    }

}