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

    @Autowired
    private final ProjectService projectService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserProjectSearchService userProjectSearchService;

    @Autowired
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

        /**
         * Initializing interface hierarchy
         *
         * [User]Peter_Smith
         * -[Experience]exp_asMoE
         * -[Experience]exp_csMoF
         * -[SoftSkill]skl_excel_1
         * -[SoftSkill]skl_word_3
         * -[Project]prj_duedil1
         *
         * [User]Charlotte_Guido
         * -[Experience]exp_asMoE
         * -[Experience]exp_csMoF
         * -[SoftSkill]skl_excel_3
         * -[SoftSkill]skl_word_2
         * -[Project]prj_duedil1
         *
         *
         */


        //SKILLS


        //EXPERIENCES
        Skill exp = new Experience();
        exp.setName("SkillExp extend test");
        skillService.persist(exp);

        //PROJECTS
        final Project p = new Project();

        //USERS
        final User u = new User();
        u.setId(123);
        p.setName("Project1");
        p.setDescription("Test project");
        projectService.persist(p);

        //USERPROJECTS //TODO: this might be this should be handled by service
        final UserProject up = new UserProject();
        up.setProject(p);
        up.setEmployee(u);
        up.setFrom(LocalDate.now());
        Set<UserProject> upSet = new HashSet<>();
        upSet.add(up);
        u.setUserProjects(upSet);

        Set<Skill> skills = new HashSet<>();
        Experience exp_asMoE = new Experience("Assistant","Ministry of Education",LocalDate.of(2005,1,1),LocalDate.of(2005,1,1));
        exp_asMoE.setUser(u);

        skills.add(exp_asMoE);
        u.setSkills(skills);

        userService.persist(u);

        //ALL-CONTAINING SETS INIT
        List<User> users = userService.findAll();

        List<Project> projectsRet = userProjectSearchService.getUsersProjectsFromDate(u,LocalDate.of(2000,1,1));
        List<Skill> skillsRet = skillService.getAllSkillsByUser(u);

        System.out.println("Data initialization complete");

    }
}
