package system.business;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */

@Entity
public class Position extends AbstractBusinessObject {

    @Column()
    private String name;

    @ManyToMany(mappedBy = "positions")
    Set<Employee> employee;

    public Position() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
