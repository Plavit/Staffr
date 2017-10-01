package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import system.business.Project;
import system.business.Skill;
import system.dao.ProjectDao;
import system.dao.SkillDao;

import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillDao dao;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Skill> getAll() {
        return dao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Skill skill) {
        dao.persist(skill);
    }
}
