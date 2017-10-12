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
    int tstPhone;
    String tstNote;


    @Before
    public void setUp() throws Exception {
        tstE = new Employee();
        tstName="Pavel";
        tstLast="Destroyer";
        tstBday=1998;
        tstSt=Status.ACTIVE;
        tstMail="tst@tst.tst";
        tstPhone=123456789;
        tstNote="testnote";

        tstE.setFirstName(tstName);
        tstE.setLastName(tstLast);
        tstE.setActive(tstSt);
        tstE.setAddress(tstAdr);
        tstE.setBirthYear(tstBday);
        tstE.setEmail(tstMail);
        tstE.setPhoneNumber(tstPhone);
        tstE.setNote(tstNote);
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


    @Test
    public void getBirthYear() throws Exception {
        assert(tstE.getBirthYear()==tstBday);
    }

    @Test
    public void setBirthYear() throws Exception {
        tstE.setBirthYear(1202);
        assert(tstE.getBirthYear()==1202);
    }

    @Test
    public void getEmail() throws Exception {
        assert tstE.getEmail()==tstMail;
    }

    @Test
    public void setEmail() throws Exception {
        tstE.setEmail("test2@gloglo.cz");
        assert tstE.getEmail()=="test2@gloglo.cz";
    }

    @Test
    public void getNote() throws Exception {
        assert(tstE.getNote()==tstNote);
    }

    @Test
    public void setNote() throws Exception {
        tstE.setNote("poop");
        assert(tstE.getNote()=="poop");
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assert (tstE.getPhoneNumber()==tstPhone);
    }

    @Test
    public void setPhoneNumber() throws Exception {
        tstE.setPhoneNumber(98765432);
        assert (tstE.getPhoneNumber()==98765432);
    }

    @Test
    public void getActive() throws Exception {
        assert(tstE.getActive()==tstSt);
    }

    @Test
    public void setActive() throws Exception {
        tstE.setActive(Status.INACTIVE);
        assert(tstE.getActive()==Status.INACTIVE);
        tstE.setActive(Status.ACTIVE);
        assert(tstE.getActive()==Status.ACTIVE);
        tstE.setActive(Status.MATERNITY_LEAVE);
        assert(tstE.getActive()==Status.MATERNITY_LEAVE);
        tstE.setActive(Status.RETIRED);
        assert(tstE.getActive()==Status.RETIRED);
    }

    /*
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