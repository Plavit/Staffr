package system.business;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */


@NamedQueries({
        @NamedQuery(name = "Office.findByName",
                query = "SELECT l FROM Office l WHERE LOWER(l.name) = :name"),

        @NamedQuery(name = "Office.findAll", query = "SELECT l FROM Office l")
})




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
