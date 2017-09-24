package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import system.business.Employee;
import system.business.User;
import system.business.enums.Role;
import system.business.enums.Status;
import system.service.security.EmployeeService;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataSetup {

    @Autowired
    private EmployeeService employeeService;

    private Employee initEmployee(){
        return new Employee("Marek","Selezszzs",1996,
                "theBigD@staffr.com","cool guy",
                111111111, Status.MATERNITY_LEAVE,
                null,
                null,null,null,null,null,
                null,null,null);
    }
        @PostConstruct
        private void setupData() {
            employeeService.persist(initEmployee());
        }
    }


