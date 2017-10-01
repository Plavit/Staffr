package system.business;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */

@Entity()
public class Address  extends AbstractBusinessObject{

    @Column()
    private String country;

    @Column()
    private String city;

    @Column()
    private int psc;

    @Column()
    private String street;

    @Column()
    private String cp;

    @OneToMany(mappedBy = "address")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "address")
    private Set<Office> offices;

    public Address() {

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPsc() {
        return psc;
    }

    public void setPsc(int psc) {
        this.psc = psc;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
