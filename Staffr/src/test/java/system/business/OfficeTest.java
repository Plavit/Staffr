package system.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Marek on 1.10.2017.
 */
public class OfficeTest {
    Office o;
    String tstOffice;

    @Before
    public void setUp() throws Exception {
        o = new Office();
        tstOffice="Brno";
        o.setName(tstOffice);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getOfficeName() throws Exception {
        assert (o.getName()== tstOffice);
    }

    @Test
    public void setOfficeName() throws Exception {
        o.setName("Lisbon");
        assert (o.getName()=="Lisbon");
        o.setName(tstOffice);
    }

}