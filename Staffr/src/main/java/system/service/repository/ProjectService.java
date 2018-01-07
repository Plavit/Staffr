package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.Project;
import system.dao.GenericDao;
import system.dao.ProjectDao;

@Service
@Transactional
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

    @Transactional
    @Override
    public void update(Project instance) {
        super.update(instance);
    }

    public void removeById(int id) {
        super.remove(dao.find(id));
    }
}
