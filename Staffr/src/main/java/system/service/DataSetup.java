package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.business.Employee;
import system.business.User;
import system.business.enums.Role;
import system.business.enums.Status;


import javax.annotation.PostConstruct;

@Component
public class DataSetup {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;

    private Employee initEmployee(User user) {
        return new Employee("Marek", "Selezszzs", 1996,
                "theBigD@staffr.com", "cool guy",
                111111111, Status.MATERNITY_LEAVE,
                user,
                null, null, null, null, null,
                null, null, null);
    }

    private User initUser() {
        return new User("mksz", "1234", Role.ADMIN_ROLE);
    }

    @PostConstruct
    private void setupData() {
        User user = initUser();
        Employee employee = initEmployee(user);
        userService.persist(user);
        employeeService.persist(employee);
    }
}


