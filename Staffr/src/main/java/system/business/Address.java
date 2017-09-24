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
}
