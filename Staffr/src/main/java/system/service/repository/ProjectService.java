package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.Project;
import system.business.User;
import system.business.UserProject;
import system.dao.GenericDao;
import system.dao.ProjectDao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
        Set<UserProject> upSet = userService.find(userId).getUserProjects();
        List<Project> ret = new LinkedList<>();
        for (UserProject up : upSet) {
            ret.add(up.getProject());
        }
        return ret;
    }
}
