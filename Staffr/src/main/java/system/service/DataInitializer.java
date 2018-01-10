package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.business.*;
import system.business.enums.Role;
import system.business.enums.SkillProfficiency;
import system.service.data.UserProjectJoinService;
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
    private final UserProjectJoinService userProjectJoinService;

    @Autowired
    public DataInitializer(ProjectService projectService, UserService userService, UserProjectSearchService userProjectSearchService, SkillService skillService, UserProjectJoinService userProjectJoinService) {
        this.projectService = projectService;
        this.userService = userService;
        this.userProjectSearchService = userProjectSearchService;
        this.skillService = skillService;
        this.userProjectJoinService = userProjectJoinService;
    }

    @PostConstruct
    private void init() {

//        User u1 = new User();
//        Project p1 = new Project();
//        projectService.persist(p1);
//        UserProject up1 = new UserProject();
//        userProjectJoinService.joinUserWithProject(u1,p1,up1);
//        System.out.println();


        /**
         * Initializing interface hierarchy
         *
         * [User]u
         * -[Project]p
         *
         * [User]Peter_Smith
         * -[Experience]exp_asMoE
         * -[SoftSkill]skl_excel_1
         * -[SoftSkill]skl_word_3
         * -[SoftSkill]skl_eng_3
         * -[Project]prj_duedil1
         *
         * [User]Charlotte_Guido
         * -[Experience]exp_csMoF
         * -[SoftSkill]skl_excel_3
         * -[SoftSkill]skl_word_2
         * -[SoftSkill]skl_eng_1
         * -[Project]prj_duedil1
         * -[Project]prj_pmi1
         *
         * [User]Ivan_Terrible
         * -[SoftSkill]skl_excel_2
         * -[SoftSkill]skl_word_1
         * -[SoftSkill]skl_eng_2
         * -[Project]prj_pmi1
         *
         */


        //PROJECTS
//        final Project p = new Project();
//        p.setName("Project1");
//        p.setDescription("Test project");
//        projectService.persist(p);

        final Project prj_pmi1 = new Project();
        prj_pmi1.setName("PMI for Avast-AVG");
        prj_pmi1.setDescription("Post Merger Integration for a large Software company.");
        projectService.persist(prj_pmi1);

        final Project prj_duedil1 = new Project();
        prj_duedil1.setName("DD for Danske Bank");
        prj_duedil1.setDescription("Due Dilligence for major European Bank");
        projectService.persist(prj_duedil1);

        //USERS
        final User u = new User();
        u.setFirstName("Anon");
        u.setLastName("Anonymous");
        u.setEmail("anon@4chan.org");
        u.setUserName("admin");
        u.setPassword("heslo");
        u.setRole(Role.ADMIN_ROLE);
        //u.setId(123);

        final User Peter_Smith = new User();
        Peter_Smith.setFirstName("Peter");
        Peter_Smith.setLastName("Smith");
        Peter_Smith.setBirthYear(1990);
        Peter_Smith.setEmail("P.SmithYo@Yahoo.com");
        //u.setId(124);

        final User Charlotte_Guido = new User();
        Charlotte_Guido.setFirstName("Charlotte");
        Charlotte_Guido.setLastName("Guido");
        Charlotte_Guido.setBirthYear(1986);
        Charlotte_Guido.setEmail("CG-see-gay@seznam.cz");
        //u.setId(125);

        final User Ivan_Terrible = new User();
        Ivan_Terrible.setFirstName("Ivan");
        Ivan_Terrible.setLastName("Terrible");
        Ivan_Terrible.setBirthYear(1875);
        Ivan_Terrible.setEmail("Impala@google.com");
        //u.setId(126);

        //SKILLS
        // todo - would be best to move proficiency to relational table USERSKILLS for better instantialization
        Skill skl_excel_1 = new SoftSkill();
        skl_excel_1.setName("Excel");
        skl_excel_1.setProfficiency(SkillProfficiency.BEGINNER);

        Skill skl_excel_2 = new SoftSkill();
        skl_excel_2.setName("Excel");
        skl_excel_2.setProfficiency(SkillProfficiency.INTERMEDIATE);

        Skill skl_excel_3 = new SoftSkill();
        skl_excel_3.setName("Excel");
        skl_excel_3.setProfficiency(SkillProfficiency.ADVANCED);

        Skill skl_eng_1 = new SoftSkill();
        skl_eng_1.setName("English");
        skl_eng_1.setProfficiency(SkillProfficiency.BEGINNER);

        Skill skl_eng_2 = new SoftSkill();
        skl_eng_2.setName("English");
        skl_eng_2.setProfficiency(SkillProfficiency.INTERMEDIATE);

        Skill skl_eng_3 = new SoftSkill();
        skl_eng_3.setName("English");
        skl_eng_3.setProfficiency(SkillProfficiency.ADVANCED);


        Skill skl_word_1 = new SoftSkill();
        skl_word_1.setName("Word");
        skl_word_1.setProfficiency(SkillProfficiency.BEGINNER);

        Skill skl_word_2 = new SoftSkill();
        skl_word_2.setName("Word");
        skl_word_2.setProfficiency(SkillProfficiency.INTERMEDIATE);

        Skill skl_word_3 = new SoftSkill();
        skl_word_3.setName("Word");
        skl_word_3.setProfficiency(SkillProfficiency.ADVANCED);


        //EXPERIENCES
        Skill exp = new Experience();
        exp.setName("SkillExp extend test");
//        skillService.persist(exp);

        Experience exp_asMoE = new Experience("Assistant", "Ministry of Education", LocalDate.of(2005, 1, 1), LocalDate.of(2007, 1, 1));
//        exp_asMoE.setUser(Peter_Smith);
//        skillService.create(exp_asMoE);

        Experience exp_csMoF = new Experience("Consultant", "Ministry of Finance", LocalDate.of(2015, 1, 1), LocalDate.of(2017, 1, 1));
//        exp_csMoF.setUser(Charlotte_Guido);
//        skillService.create(exp_csMoF);


        //FINISH - Skill to user stick
        Set<Skill> skillsPS = new HashSet<>();
        skillsPS.add(exp_asMoE);
        Peter_Smith.setSkills(skillsPS);

        Set<Skill> skillsCG = new HashSet<>();
        skillsPS.add(exp_csMoF);
        Charlotte_Guido.setSkills(skillsCG);

        //FINISH - create users
        userService.create(u);
        userService.create(Peter_Smith);
        userService.create(Charlotte_Guido);
        userService.create(Ivan_Terrible);

        //USERPROJECTS
        final UserProject upPS = new UserProject();
        upPS.setFrom(LocalDate.ofYearDay(2017,333));
        upPS.setEnd(LocalDate.ofYearDay(2017,343));
        userProjectJoinService.joinUserWithProject(Peter_Smith,prj_duedil1,upPS);

        final UserProject upCG1 = new UserProject();
        upCG1.setFrom(LocalDate.ofYearDay(2016,133));
        upCG1.setEnd(LocalDate.ofYearDay(2017,333));
        userProjectJoinService.joinUserWithProject(Charlotte_Guido,prj_duedil1,upCG1);

        final UserProject upCG2 = new UserProject();
        upCG2.setFrom(LocalDate.ofYearDay(2017,233));
        upCG2.setEnd(LocalDate.ofYearDay(2017,333));
        userProjectJoinService.joinUserWithProject(Charlotte_Guido,prj_pmi1,upCG2);

        final UserProject upIT = new UserProject();
        upIT.setFrom(LocalDate.ofYearDay(2017,233));
        upIT.setEnd(LocalDate.ofYearDay(2017,250));
        userProjectJoinService.joinUserWithProject(Ivan_Terrible,prj_pmi1,upIT);

        final UserProject up1 = new UserProject();
        up1.setFrom(LocalDate.ofYearDay(2017,1));
        up1.setEnd(LocalDate.now());
        userProjectJoinService.joinUserWithProject(u, prj_pmi1, up1);
        //userProjectJoinService.joinUserWithProject(u, prj_duedil1, up1);


//        Set<UserProject> allUserProjects = new HashSet<>();
//        allUserProjects.addAll(p.getUserProject());
//        allUserProjects.addAll(prj_pmi1.getUserProject());
//        allUserProjects.addAll(prj_duedil1.getUserProject());
//        for (UserProject k : u.getUserProjects()) {
//            for (UserProject l: allUserProjects) {
//                if (k.getFuj() == l.getFuj()){
//                    System.out.println();
//                }
//                if (k.getFuj().equals(l.getFuj())){
//                    System.out.println();
//                }
//            }
//        }

        //ALL-CONTAINING SETS INIT
        List<User> users = userService.findAll();
        List<Project> projectsRet = userProjectSearchService.getUsersProjectsFromDate(u, LocalDate.of(2000, 1, 1));
        List<Skill> skillsRet = skillService.getAllSkillsByUser(u);

        System.out.println("Data initialization complete");

    }
}
