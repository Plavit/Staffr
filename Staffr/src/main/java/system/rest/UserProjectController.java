package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.dao.ProjectDao;
import system.dao.UserProjectDao;
import system.service.repository.UserProjectService;

import java.util.List;

/**
 * Created by krystof on 10/1/17.
 */


@RestController
@RequestMapping("/userProject")
public class UserProjectController {

    @Autowired
    private UserProjectService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserProject> getAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody UserProject userProject) {
        service.persist(userProject);
    }
}
