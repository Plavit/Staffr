package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import system.business.Project;
import system.business.UserProject;
import system.service.repository.ProjectService;
import system.service.repository.UserProjectService;

import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private UserProjectService userProjectService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Project project) {
        service.persist(project);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Project project) {
        service.update(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project get(@PathVariable("id") int id) {
        return service.find(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") int id) {
        service.removeById(id);
    }

    @RequestMapping(value = "getProjectsByUser/{userId}", method = RequestMethod.GET)
    public List<Project> getProjectsByUser(@PathVariable("userId") int id) {
        return service.findProjectsByUser(id);
    }

    @RequestMapping(value = "getUserProjectFor/{projectId}&{userId}", method = RequestMethod.GET)
    public UserProject getUserProjectForUserOnProject(@PathVariable("projectId") int projectId, @PathVariable("userId") int userId) {
        UserProject ret = userProjectService.getUserServisForUserOnProject(userId,projectId);
        return ret;
    }
}
