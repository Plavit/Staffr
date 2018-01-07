package system.service.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.*;
import system.business.enums.Role;
import system.business.enums.SkillProfficiency;
import system.business.enums.Status;
import system.service.BaseServiceTestRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserServiceTest extends BaseServiceTestRunner {


    @Autowired
    private UserService us;

    @Autowired
    private ProjectService projectService;

    Skill testSkill1B = new Skill("testSkill1",SkillProfficiency.BEGINNER);
    Skill testSkill1P = new Skill("testSkill1",SkillProfficiency.PROFFICIENT);
    Skill testSkill2B = new Skill("testSkill2",SkillProfficiency.BEGINNER);
    User testUser = new User("tstUser","tstPass",Role.USER_ROLE);
    User testUser2 = new User("tstUser","tstPass",Role.USER_ROLE);
    final Project p = new Project();
    final UserProject up = new UserProject();
    Set<UserProject> upSet = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        testUser.setFirstName("Pablo");
        testUser.setLastName("Neruda");
        testUser.setEmail("Poems@Yahoo.com");
        testUser.setRole(Role.USER_ROLE);
        Set<Skill> skillset=new HashSet<>();
        skillset.add(testSkill1B);
        testUser.setSkills(skillset);

        p.setName("ProjectT1");
        p.setDescription("Test project");

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

        testUser2.setFirstName("Kwek");
        testUser2.setLastName("Kookal");
        testUser2.setEmail("Poems@Yahoo.com");
        testUser2.setRole(Role.USER_ROLE);
        us.create(testUser2);

    }

    @After
    public void tearDown() throws Exception {
        //us.getPrimaryDao().remove(testUser);
    }

    @Test
    public void findUsersBySkill() throws Exception {

        List<User> output = us.findUsersBySkill(testSkill1B);
        assert (output.contains(testUser));

        output=us.findUsersBySkill(testSkill1P);
        assert (output.contains(testUser));

        output = us.findUsersBySkill(testSkill2B);
        assert (!output.contains(testUser));
    }

    @Test
    public void findUsersBySkillProfficiency() throws Exception {

        List<User> output = us.findUsersBySkillProfficiency(testSkill1B);
        assert (output.contains(testUser));

        output=us.findUsersBySkillProfficiency(testSkill1P);
        assert (!output.contains(testUser));

        output = us.findUsersBySkillProfficiency(testSkill2B);
        assert (!output.contains(testUser));
    }

    //TODO test project duration tests

    @Test
    public void findUsersByProjectContains() throws Exception {
        List<User> output = us.findUsersByProject(p.getId());
        assert (output.contains(testUser));
    }

    @Test
    public void findUsersByProjectNotContains() throws Exception {
        List<User> output = us.findUsersByProject(p.getId());
        assert (!output.contains(testUser2));
    }

    @Test
    public void findUsersByProjectByDurationSearchMin() throws Exception {
        List<User> output = us.findUsersByProjectByDuration(p.getId(),1);
        assert (output.contains(testUser));

    }

    @Test
    public void findUsersByProjectByDurationSearchMed() throws Exception {
        List<User> output = us.findUsersByProjectByDuration(p.getId(),12);
        assert (output.contains(testUser));

    }

    @Test
    public void findUsersByProjectByDurationSearchExact() throws Exception {
        List<User> output = us.findUsersByProjectByDuration(p.getId(),14);
        assert (output.contains(testUser));
    }

    @Test
    public void findUsersByProjectByDurationSearchOver() throws Exception {

        List<User> output = us.findUsersByProjectByDuration(p.getId(),32);
        assert (!output.contains(testUser));
    }

    @Test
    public void persistCascadesForSkills() {
        final User user = new User("plavit","PSW", Role.USER_ROLE,"Marek","Szeles",1996,"a@b.com","",3, Status.ACTIVE);
        Set<Skill> skills=new HashSet<>();
        Skill skl_excel_3=new SoftSkill();
        skl_excel_3.setName("Excel");
        skl_excel_3.setProfficiency(SkillProfficiency.ADVANCED);
        skills.add(skl_excel_3);
        Skill skl_word_3=new SoftSkill();
        skl_word_3.setName("Word");
        skl_word_3.setProfficiency(SkillProfficiency.ADVANCED);
        skills.add(skl_word_3);

        user.setSkills(skills);
        us.create(user);

        final User result = us.find(user.getId());
        Assert.assertEquals(skills.size(), result.getSkills().size());

        for (Skill s:skills
             ) {
            assert (result.getSkills().contains(s));
        }
    }
}