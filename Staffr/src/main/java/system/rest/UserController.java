package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import system.business.User;
import system.service.repository.ProjectService;
import system.service.repository.UserService;

import java.security.Principal;
import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/current", produces=MediaType.APPLICATION_JSON_VALUE)
    public User getCurrent(Principal pr) {
        String userName = pr.getName();
        User ret = service.findUserByUsername(userName);
        return ret;
    }

    @RequestMapping(value = "/current", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCurrentUser(@RequestBody User user) {
        service.update(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user) {
        service.update(user);
    }

    @RequestMapping(method = RequestMethod.GET, value="/admin", produces=MediaType.APPLICATION_JSON_VALUE)
    public User getAdmin() {
        User ret = service.findUserByUsername("admin");
        return ret;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userId") int id) {
        return service.find(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        service.create(user);
    }

    @RequestMapping(value = "onProject/{projectId}", method = RequestMethod.GET)
    public List<User> getUsersOnProject(@PathVariable("projectId") int id) {
        //Project p = projectService.find(id);
        return service.findUsersByProject(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") int id) {
        service.removeById(id);
    }

    @RequestMapping(value = "getUsersByProject/{projectId}", method = RequestMethod.GET)
    public List<User> getUsersByProject(@PathVariable("projectId") int id) {
        return service.findUsersByProject(id);
    }

    @RequestMapping(value = "getUsersByProjectDuration/{projectId}/{duration}", method = RequestMethod.GET)
    public List<User> getUsersByProjectDuration(@PathVariable("projectId") int id, @PathVariable("duration") long days) {
        return service.findUsersByProjectByDuration(id,days);
    }

    @RequestMapping(value = "getUsersBySkill/{skillId}", method = RequestMethod.GET)
    public List<User> getUsersBySkill(@PathVariable("skillId") int id) {
        return service.findUsersBySkill(id);
    }

    @RequestMapping(value = "getUsersBySkillProfficiency/{skillId}", method = RequestMethod.GET)
    public List<User> getUsersBySkillProfficiency(@PathVariable("skillId") int id) {
        return service.findUsersBySkillProfficiency(id);
    }
}
