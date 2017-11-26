package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.Project;
import system.dao.GenericDao;
import system.dao.ProjectDao;

@Service
public class ProjectService extends AbstractRepositoryService<Project> {

    private final ProjectDao dao;

    @Autowired
    public ProjectService(ProjectDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<Project> getPrimaryDao() {
        return dao;
    }
}
