package system.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.Employee;
import system.dao.EmployeeDao;

/**
 * Created by krystof on 9/24/17.
 */

@Service
public class EmployeeService {

        @Autowired
        private EmployeeDao employeDao;

    public void persist(Employee employee) {
        employeDao.persist(employee);
    }

    public void update(Employee employee){
        employeDao.update(employee);
    }

}
