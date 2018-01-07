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
        List<Project> ret = new LinkedList<>();
        Set<UserProject> result = new HashSet<>();

        Set<UserProject> allUserProjectsInProjects = new HashSet<>();

        for (Project p : findAll()) {
            allUserProjectsInProjects.addAll(p.getUserProject());
        }

        Set<UserProject> allUserProjectsinUser = userService.find(userId).getUserProjects();

        for (UserProject a : allUserProjectsInProjects) {
            for (UserProject b : allUserProjectsinUser) {
                if (a.getFuj().equals(b.getFuj())) {
                    result.add(a);
                }
            }
        }

        for (Project p : findAll()) {
            for (UserProject up : result) {
                if(p.getUserProject().contains(up)){
                    ret.add(p);
                }
            }
        }

        return ret;
    }
}
