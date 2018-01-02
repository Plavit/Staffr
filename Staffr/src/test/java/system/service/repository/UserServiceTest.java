package system.service.repository;

import org.junit.Assert;
import org.junit.Test;
import system.business.Skill;
import system.business.SoftSkill;
import system.business.User;
import system.business.enums.SkillProfficiency;
import system.business.enums.Status;
import system.dao.UserDao;

import java.util.HashSet;
import java.util.Set;


public class UserServiceTest {
    @Test
    public void findUserByUsername() throws Exception {
        //todo
    }

    @Test
    public void exists() throws Exception {
        //todo
    }

    @Test
    public void persistCascadesForSkills() {
        final UserDao ud = new UserDao();
        final UserService us=new UserService(ud);

        final User user = new User("Marek","Szeles",1996,"a@b.com","",3, Status.ACTIVE);
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
        us.persist(user);

        final User result = us.find(user.getId());
        Assert.assertEquals(skills.size(), result.getSkills().size());
    }
}