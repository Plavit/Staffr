package system.service.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import system.business.*;
import system.config.ServiceConfig;
import system.service.repository.ProjectService;
import system.service.repository.UserService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional(transactionManager = "txManager")
public class UserProjectSearchServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserProjectSearchService userProjectSearchService;

    final Project p = new Project();
    final User u = new User();
    final UserProject up = new UserProject();

    @Before
    public void setUp() throws Exception {

        up.setProject(p);
        up.setEmployee(u);

        Set<UserProject> upSet = new HashSet<>();

        upSet.add(up);

        p.setName("Project1");
        p.setDescription("Test project");

        projectService.persist(p);

        u.setUserProjects(upSet);

        userService.persist(u);
    }

    @Test
    public void getUsersProjectsFromDate() throws Exception {
        List<Project> projects = userProjectSearchService.getUsersProjectsFromDate(u,null);
        Assert.assertEquals(p,projects.get(0));
    }

}