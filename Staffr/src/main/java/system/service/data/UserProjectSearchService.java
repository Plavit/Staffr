package system.service.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.business.*;
import system.business.UserProject;
import system.dao.ProjectDao;
import system.dao.UserProjectDao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class UserProjectSearchService {

    @Autowired
    UserProjectDao userProjectDao;

    @Autowired
    ProjectDao projectDao;

    public List<Project> getUsersProjectsFromDate(User userId, LocalDate start) {
        List<Project> ret = new LinkedList<>();
        List<UserProject> upList = userProjectDao.findByUserAndStartingDate(userId, start);
        for (UserProject up : upList) {
            ret.add(up.getProject());
        }
        return ret;
    }
}
