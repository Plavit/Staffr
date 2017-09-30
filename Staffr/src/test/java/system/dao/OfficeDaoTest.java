package system.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.bo.Location;
import system.business.Office;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Marek on 30.09.2017.
 */
public class OfficeDaoTest extends BaseDaoTestRunner{

    @Autowired
    private OfficeDao officeDao;

    @Test
    public void findByLocationName(){
        final Office o = new Office();
        o.setOfficeName("Prague");

        officeDao.persist(o);

        final Office result = officeDao.findByName(o.getOfficeName());
        assertNotNull(result);
        assertEquals(o.getId(), result.getId());
    }

}
