package system.service.repository;

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

}
