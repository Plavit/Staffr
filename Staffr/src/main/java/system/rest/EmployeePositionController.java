package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import system.business.EmployeePosition;
import system.business.UserProject;
import system.dao.EmployeePositionDao;
import system.dao.UserProjectDao;

import java.util.List;

/**
 * Created by krystof on 10/8/17.
 */

@RestController
@RequestMapping("/employeePosition")
public class EmployeePositionController {

    @Autowired
    private EmployeePositionDao dao;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeePosition> getAll() {
        return dao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody EmployeePosition employeePosition) {
        dao.persist(employeePosition);
    }
}
