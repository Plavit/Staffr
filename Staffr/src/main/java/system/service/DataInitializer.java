package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.business.*;
import system.service.data.UserProjectSearchService;
import system.service.repository.ProjectService;
import system.service.repository.SkillService;
import system.service.repository.UserService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInitializer {

    private final ProjectService projectService;

    private final UserService userService;

    private final UserProjectSearchService userProjectSearchService;

    private final SkillService skillService;

    @Autowired
    public DataInitializer(ProjectService projectService, UserService userService, UserProjectSearchService userProjectSearchService, SkillService skillService) {
        this.projectService = projectService;
        this.userService = userService;
        this.userProjectSearchService = userProjectSearchService;
        this.skillService = skillService;
    }

    @PostConstruct
    private void init() {
        Skill sk = new Experience();
        sk.setName("Not the right one");
        skillService.persist(sk);

        final Project p = new Project();
        final User u = new User();
        final UserProject up = new UserProject();
        up.setProject(p);
        up.setEmployee(u);
        up.setFrom(LocalDate.now());

        u.setId(123);

        Set<UserProject> upSet = new HashSet<>();

        upSet.add(up);

        p.setName("Project1");
        p.setDescription("Test project");
//        p.setUserProject(upSet);

        projectService.persist(p);

        u.setUserProjects(upSet);
        Set<Skill> skills = new HashSet<>();
        Experience experience = new Experience();
        experience.setName("EXP1");
        experience.setFrom(LocalDate.of(2005,1,1));
        experience.setTo(LocalDate.of(2007,1,1));
        experience.setUser(u);
        skills.add(experience);
        u.setSkills(skills);

        userService.persist(u);

        List<User> users = userService.findAll();

        List<Project> projectsRet = userProjectSearchService.getUsersProjectsFromDate(u,LocalDate.of(2000,1,1));
        List<Skill> skillsRet = skillService.getAllSkillsByUser(u);
        System.out.println("Done");

    }
}
