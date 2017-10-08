package system.business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by krystof on 10/8/17.
 */

@Entity()
public class EmployeePosition extends AbstractBusinessObject {
    @ManyToOne()
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name = "PROJECT_ID")
    private Position position;

    public EmployeePosition() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
