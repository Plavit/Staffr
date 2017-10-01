package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import system.business.Project;
import system.dao.ProjectDao;

/**
 * Created by krystof on 10/1/17.
 */
public class ProjectService {
    @Autowired
    private ProjectDao dao;

    public void persist(Project e) {
        dao.persist(e);
    }

    public void update(Project e){
        dao.update(e);
    }
}
