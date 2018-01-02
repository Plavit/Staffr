package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import system.business.Project;
import system.business.User;
import system.dao.ProjectDao;
import system.dao.UserDao;
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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/current", produces=MediaType.APPLICATION_JSON_VALUE)
    public String getCurrent(Principal pr) {
        String userName = pr.getName();
        User ret = service.findUserByUsername(userName);
        return ret.getUserName();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody User user) {
        service.persist(user);
    }
}
