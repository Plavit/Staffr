package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.Skill;
import system.business.User;
import system.business.enums.SkillProfficiency;
import system.dao.GenericDao;
import system.dao.SkillDao;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class SkillService extends AbstractRepositoryService<Skill> {
//Test
    private final SkillDao dao;

    @Autowired
    public SkillService(SkillDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<Skill> getPrimaryDao() {
        return dao;
    }

    public List<Skill> getAllSkillsByUser(User user) {
        return dao.getAllSkillsByUser(user);
    }

    public List<Skill> getAllExpiriencesByUserWithAMinimalProficiency(User user, SkillProfficiency skillProfficiency) {
        List<Skill> skills = dao.getAllSkillsByUser(user);
        skills.stream().forEach(skill -> {
            if (skill.getProfficiency() != skillProfficiency) skills.remove(skill);
        });
        return skills;
    }


}
