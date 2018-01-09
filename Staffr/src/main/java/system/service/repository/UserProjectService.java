package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.UserProject;
import system.dao.GenericDao;
import system.dao.UserProjectDao;

@Service
public class UserProjectService extends AbstractRepositoryService<UserProject> {

    private final UserProjectDao dao;

    @Autowired
    public UserProjectService(UserProjectDao dao) {
        this.dao = dao;
    }

    @Override
    protected GenericDao<UserProject> getPrimaryDao() {
        return dao;
    }

    
}
