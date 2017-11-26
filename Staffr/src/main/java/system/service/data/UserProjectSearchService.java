package system.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.*;
import system.business.UserProject;
import system.dao.ProjectDao;
import system.dao.UserProjectDao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserProjectSearchService {

    @Autowired
    UserProjectDao userProjectDao;

    @Autowired
    ProjectDao projectDao;

    public List<Project> getUsersProjectsFromDate(int userId, Date start) {
        List<Project> ret = new LinkedList<>();
        List<UserProject> upList = userProjectDao.findByUserAndStartingDate(userId, start);
        for (UserProject up : upList) {
            ret.add(projectDao.find(up.getId()));
        }
        return ret;
    }
}
