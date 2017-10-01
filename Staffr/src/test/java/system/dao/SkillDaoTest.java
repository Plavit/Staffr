package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.business.Skill;
import system.business.enums.SkillProfficiency;

import static org.junit.Assert.*;

/**
 * Created by krystof on 10/1/17.
 */
public class SkillDaoTest extends BaseDaoTestRunner{

    @Autowired
    private SkillDao skillDao;

    @Test
    public void findByName() throws Exception {
        final Skill skill = new Skill();
        skill.setName("lollygagging");
        skill.setProfficiency(SkillProfficiency.MASTER);
        skillDao.persist(skill);
        final Skill result = skillDao.findByName(skill.getName());
        assertNotNull(result);
        assertEquals(skill.getId(), result.getId());
    }

}