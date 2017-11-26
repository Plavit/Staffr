package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.business.enums.Role;
import system.business.enums.Status;


import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataSetup {

    @Autowired
    private UserService userService;

    @PostConstruct
    private void setupData() {
        User u = new User();
        UserProject up = new UserProject();
        Project p = new Project();
        p.setStartOfProject(new Date(1,1,2000));
        up.setProject(p);
        up.setEmployee(u);
        Set<UserProject> pList = new HashSet<>();
        u.setUserProjects(pList);
        userService.persist(u);
    }
}


