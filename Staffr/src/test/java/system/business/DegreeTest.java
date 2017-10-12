package system.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import system.business.enums.DegreeType;

/**
 * Created by Marek on 10.10.2017.
 */
public class DegreeTest {

    Degree d;
    String tstName;
    DegreeType tstType;


    @Before
    public void setUp() throws Exception {
        d = new Degree();
        tstType = DegreeType.BACHELOR;
        d.setType(tstType);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getType() throws Exception {
        assert (d.getType()==tstType);
    }

    @Test
    public void setType() throws Exception {
        DegreeType tstType2=DegreeType.DOCTOR;
        d.setType(tstType2);

        assert (d.getType()==tstType2);
    }

    @Test
    public void getName() throws Exception {
        assert (d.getName()== tstName);
    }

    @Test
    public void setName() throws Exception {
        String tstName2 = "pooptest";
        d.setName(tstName2);

        assert (d.getName()== tstName2);
    }
    /* TODO
    @Test
    public void getFrom() throws Exception {

    }

    @Test
    public void setFrom() throws Exception {

    }

    @Test
    public void getTo() throws Exception {

    }

    @Test
    public void setTo() throws Exception {

    }

    @Test
    public void getEmployee() throws Exception {

    }

    @Test
    public void setEmployee() throws Exception {

    }

    @Test
    public void getUniversity() throws Exception {

    }

    @Test
    public void setUniversity() throws Exception {

    }*/

}