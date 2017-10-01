package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.business.Office;
import system.dao.OfficeDao;

/**
 * Created by Marek on 9/30/17.
 */

@Service
public class OfficeService{

    @Autowired
    private OfficeDao dao;

    public void persist(Office e) {
        dao.persist(e);
    }

    public void update(Office e){
        dao.update(e);
    }
}
