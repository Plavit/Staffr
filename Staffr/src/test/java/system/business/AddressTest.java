package system.business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Marek on 10.10.2017.
 */
public class AddressTest {
    Employee tstE;
    Address tstAdd;
    String tstCountry;
    Set<Employee> tstEmployees;
    String tstCp;
    String tstStreet;
    String tstCity;
    int tstPsc;
    Set<Employee> emp2;
    Employee tst1;
    Employee tst2;

    @Before
    public void setUp() throws Exception {
        tstAdd=new Address();
        tstCountry="CZ";

        tstE = new Employee();
        tstE.setFirstName("Testik");
        tstEmployees = new Set<Employee>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Employee> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Employee employee) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Employee> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        } ;

        tstEmployees.add(tstE);

        tstAdd.setCountry(tstCountry);
        tstAdd.setEmployees(tstEmployees);
        tstAdd.setCity(tstCity);
        tstAdd.setPsc(tstPsc);//int
        tstAdd.setStreet(tstStreet);
        tstAdd.setCp(tstCp);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCountry() throws Exception {
        assert(tstAdd.getCountry()==tstCountry);
    }

    @Test
    public void setCountry() throws Exception {
        tstAdd.setCountry("DE");
        assert (tstAdd.getCountry()=="DE");
    }

    @Test
    public void getCity() throws Exception {
        assert(tstAdd.getCity()==tstCity);
    }

    @Test
    public void setCity() throws Exception {
        tstAdd.setCity("Berlin");
        assert (tstAdd.getCity()=="Berlin");
    }

    @Test
    public void getPsc() throws Exception {
        assert(tstAdd.getPsc()==tstPsc);
    }

    @Test
    public void setPsc() throws Exception {
        tstAdd.setPsc(16000);
        assert (tstAdd.getPsc()==16000);
    }

    @Test
    public void getStreet() throws Exception {
        assert(tstAdd.getStreet()==tstStreet);
    }

    @Test
    public void setStreet() throws Exception {
        tstAdd.setStreet("Goetheho");
        assert (tstAdd.getStreet()=="Goetheho");
    }

    @Test
    public void getCp() throws Exception {
        assert(tstAdd.getCp()==tstCp);
    }

    @Test
    public void setCp() throws Exception {
        tstAdd.setCp("12");
        assert (tstAdd.getCp()=="12");
    }

    @Test
    public void getEmployees() throws Exception {
        assert(tstAdd.getEmployees()==tstEmployees);
    }

    @Test
    public void setEmployees() throws Exception {
        tst1 = new Employee();
        tst2 = new Employee();
        emp2 = new Set<Employee>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Employee> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Employee employee) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Employee> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };
        emp2.add(tst1);
        emp2.add(tst2);


        tstAdd.setEmployees(emp2);
        assert(tstAdd.getEmployees()==emp2);
    }
/*
    @Test
    public void getOffices() throws Exception {

    }

    @Test
    public void setOffices() throws Exception {

    }*/

}