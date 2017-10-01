package system.business;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Experience extends AbstractBusinessObject{

    @Column()
    private String name;

    @Column(name = "startingFrom")
    private Date from;

    @Column(name = "endingDate")
    private Date to;

    @Column()
    private String note;

    @ManyToOne()
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;

    public Experience() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
