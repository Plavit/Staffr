package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import system.business.Project;
import system.dao.ProjectDao;
import system.service.repository.ProjectService;

import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Project> getAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Project project) {
        service.persist(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project get(@PathVariable("id") int id) {
        return service.find(id);
    }
}
