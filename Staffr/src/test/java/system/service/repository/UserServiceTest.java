package system.service.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Skill;
import system.business.SoftSkill;
import system.business.User;
import system.business.enums.Role;
import system.business.enums.SkillProfficiency;
import system.business.enums.Status;
import system.dao.UserDao;
import system.service.repository.UserService;
import system.service.BaseServiceTestRunner;

import java.util.HashSet;
import java.util.Set;


public class UserServiceTest extends BaseServiceTestRunner {

    @Autowired
    UserService userService; //todo this fails bc of application context

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
        userService.persist(user);

        final User result = userService.find(user.getId());
        Assert.assertEquals(skills.size(), result.getSkills().size());
    }
}