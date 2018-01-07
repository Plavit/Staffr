package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.dao.GenericDao;
import system.dao.ProjectDao;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ProjectService extends AbstractRepositoryService<Project> {

    private final ProjectDao dao;

    @Autowired
    private UserService userService;

    @Autowired
    public ProjectService(ProjectDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<Project> getPrimaryDao() {
        return dao;
    }

    @Transactional
    @Override
    public void update(Project instance) {
        super.update(instance);
    }

    public void removeById(int id) {
        super.remove(dao.find(id));
    }

    public List<Project> findProjectsByUser(int userId) {

        List<Project> found = new LinkedList<>();

        User user = userService.find(userId);

        for (Project project : dao.findAll()) {
            for (UserProject up : project.getUserProject()) {
                for (UserProject upp : user.getUserProjects()) {
                    if (up.getId() == upp.getId()) {
                        found.add(project);
                    }
                }
            }
        }
        return found;
    }

}
