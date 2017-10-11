package system.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import system.business.enums.Status;

/**
 * Created by Marek on 10.10.2017.
 */
public class EmployeeTest {
    Employee tstE;
    String tstName;
    String tstLast;
    int tstBday;
    Status tstSt;
    String tstMail;
    Address tstAdr;

    @Before
    public void setUp() throws Exception {
        tstE = new Employee();
        tstName="Pavel";
        tstLast="Destroyer";
        tstBday=1998;
        tstSt=Status.ACTIVE;



        tstE.setFirstName(tstName);
        tstE.setLastName(tstLast);
        tstE.setActive(tstSt);
        tstE.setAddress(tstAdr);
        tstE.setBirthYear(tstBday);
        tstE.setEmail(tstMail);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getFirstName() throws Exception {
        assert(tstE.getFirstName()==tstName);
    }

    @Test
    public void setFirstName() throws Exception {
        String newF = "Olda";
        tstE.setFirstName(newF);
        assert(tstE.getFirstName()==newF);
        tstE.setFirstName(tstName);
    }

    @Test
    public void getLastName() throws Exception {
        assert(tstE.getLastName()==tstLast);
    }

    @Test
    public void setLastName() throws Exception {
        String newL = "Olda";
        tstE.setLastName(newL);
        assert(tstE.getLastName()==newL);
        tstE.setLastName(tstLast);
    }

    /*
    @Test
    public void getBirthYear() throws Exception {

    }

    @Test
    public void setBirthYear() throws Exception {

    }

    @Test
    public void getEmail() throws Exception {

    }

    @Test
    public void setEmail() throws Exception {

    }

    @Test
    public void getNote() throws Exception {

    }

    @Test
    public void setNote() throws Exception {

    }

    @Test
    public void getPhoneNumber() throws Exception {

    }

    @Test
    public void setPhoneNumber() throws Exception {

    }

    @Test
    public void getActive() throws Exception {

    }

    @Test
    public void setActive() throws Exception {

    }

    @Test
    public void getUser() throws Exception {

    }

    @Test
    public void setUser() throws Exception {

    }

    @Test
    public void getManagers() throws Exception {

    }

    @Test
    public void setManagers() throws Exception {

    }

    @Test
    public void getDegrees() throws Exception {

    }

    @Test
    public void setDegrees() throws Exception {

    }

    @Test
    public void getEmployeePositions() throws Exception {

    }

    @Test
    public void setEmployeePositions() throws Exception {

    }

    @Test
    public void getSkills() throws Exception {

    }

    @Test
    public void setSkills() throws Exception {

    }

    @Test
    public void getOffice() throws Exception {

    }

    @Test
    public void setOffice() throws Exception {

    }

    @Test
    public void getAddress() throws Exception {

    }

    @Test
    public void setAddress() throws Exception {

    }

    @Test
    public void getExperiences() throws Exception {

    }

    @Test
    public void setExperiences() throws Exception {

    }

    @Test
    public void getUserProjects() throws Exception {

    }

    @Test
    public void setUserProjects() throws Exception {

    }*/

}