package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import system.business.Employee;
import system.dao.EmployeeDao;

import java.util.List;

/**
 * Created by krystof on 9/3/17.
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAll() {
        return employeeDao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Employee skill) {
        employeeDao.persist(skill);
    }

}
