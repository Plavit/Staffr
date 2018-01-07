
package system.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    UserDao userDao;

    @Autowired
    ProjectDao projectDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void joinUserWithProject(User user, Project project, UserProject userProject) {
        user.addUserProject(userProject);
        project.addUserProject(userProject);
        userDao.update(user);
        projectDao.update(project);
    }
}
