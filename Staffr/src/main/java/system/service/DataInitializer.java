package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.service.repository.ProjectService;
import system.service.repository.UserProjectService;
import system.service.repository.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {

    private final ProjectService projectService;

    private final UserService userService;

    private final UserProjectService userProjectService;

    @Autowired
    public DataInitializer(ProjectService projectService, UserService userService, UserProjectService userProjectService) {
        this.projectService = projectService;
        this.userService = userService;
        this.userProjectService = userProjectService;
    }

    @PostConstruct
    private void init() {
        final Project p = new Project();
        final User u = new User();
        final UserProject up = new UserProject();
        up.setProject(p);
        up.setEmployee(u);

        Set<UserProject> upSet = new HashSet<>();

        upSet.add(up);

        p.setName("Project1");
        p.setDescription("Test project");
//        p.setUserProject(upSet);

        projectService.persist(p);

        u.setUserProjects(upSet);

        userService.persist(u);
    }
}
