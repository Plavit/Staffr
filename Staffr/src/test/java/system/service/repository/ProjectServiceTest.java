package system.service.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.business.enums.Role;
import system.service.BaseServiceTestRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectServiceTest extends BaseServiceTestRunner {

    @Autowired
    private UserService us;

    @Autowired
    private ProjectService projectService;

    User testUser = new User("tstUser","tstPass",Role.USER_ROLE);
    User testUser2 = new User("tstUser","tstPass",Role.USER_ROLE);
    final Project p = new Project();
    final Project p2 = new Project();
    final UserProject up = new UserProject();
    Set<UserProject> upSet = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        testUser.setFirstName("Pablos");
        testUser.setLastName("Nerudas");
        testUser.setEmail("Poemss@Yahoo.com");
        testUser.setRole(Role.USER_ROLE);

        p.setName("ProjectT1P");
        p.setDescription("Test projectP");

        //up.setProject(p);
        //up.setEmployee(testUser);

        //2 weeks
        up.setFrom(LocalDate.ofYearDay(2017,333));
        up.setEnd(LocalDate.ofYearDay(2017,347));

        upSet.add(up);

        p.setUserProject(upSet);
        projectService.persist(p);

        testUser.setUserProjects(upSet);
        us.create(testUser);

        testUser2.setFirstName("Kweks");
        testUser2.setLastName("Kookals");
        testUser2.setEmail("Poemssos@Yahoo.com");
        testUser2.setRole(Role.USER_ROLE);
        us.create(testUser2);

    }

    @After
    public void tearDown() throws Exception {
        //us.getPrimaryDao().remove(testUser);
    }

    @Test
    public void findProjectsByUserContains() throws Exception {
        List<Project> output = projectService.findProjectsByUser(testUser.getId());
        assert (output.contains(p));
    }

    @Test
    public void findProjectsByUserNotContains() throws Exception {
        List<Project> output = projectService.findProjectsByUser(testUser.getId());
        assert (!output.contains(p2));
    }

}