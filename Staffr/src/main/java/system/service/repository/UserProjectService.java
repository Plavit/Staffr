package system.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.business.User;
import system.business.UserProject;
import system.dao.GenericDao;
import system.dao.UserProjectDao;

import java.util.List;

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

    public UserProject getUserServisForUserOnProject(int userId, int projectId){
        List<UserProject> all = dao.findAll();
        for (UserProject up:all) {
            if(up.getEmployee().getId() == userId && up.getProject().getId() == projectId){
                return up;
            }
        }
        return null;
    }
}
