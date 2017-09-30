package system.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import system.business.Office;
import system.dao.OfficeDao;

import java.util.List;

/**
 * Created by Marek on 9/30/17.
 */

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeDao officeDao;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Office> getAll() {
        return officeDao.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Office office) {
        officeDao.persist(office);
    }

}
