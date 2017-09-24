package system.business;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */

@Entity
public class Office extends AbstractBusinessObject {

    @Column()
    private String name;

    @Column()
    private String note;

    @OneToMany()
    private Set<Employee> employee;


    public String getOfficeName() {
        return name;
    }

    public void setOfficeName(String officeName) {
        this.name = officeName;
    }

    public Office() {

    }

    @ManyToOne()
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

}
