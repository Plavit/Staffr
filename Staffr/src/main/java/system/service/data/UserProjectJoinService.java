
package system.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.*;
import system.business.UserProject;
import system.dao.ProjectDao;
import system.dao.UserDao;
import system.dao.UserProjectDao;
import system.service.repository.ProjectService;
import system.service.repository.UserProjectService;
import system.service.repository.UserService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UserProjectJoinService {

    @Autowired
    UserProjectService userProjectService;

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Transactional
    public void joinUserWithProject(User user, Project project, UserProject userProject) {
        userProject.setEmployee(user);
        userProject.setProject(project);
        user.addUserProject(userProject);
        project.addUserProject(userProject);
        if (!userService.exists(user.getId())) {
            userService.create(user);
        } else {
            userService.update(user);
        }
        if (!projectService.exists(project.getId())) {
            projectService.persist(project);
        } else {
            projectService.update(project);
        }
    }
}
