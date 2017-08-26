package system.business;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {

    @Column()
    String firstName;

    @Column()
    String lastName;

    @Column()
    int birthYear;

    @Column
    private String email;

    @Column
    private String note;

    @Column
    private int phoneNumber;

    //TODO: isSupervisorOf

    @OneToMany()
    @JoinTable(name = "EMPLOYEE_DEGREE",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "DEGREE_ID", referencedColumnName = "ID"))
    private Set<Object> employeeDegrees;


    @OneToOne
    @JoinTable(name = "EMPLOYEE_POSITION",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID"))
    private Set<Object> employeePosition;

    // TODO: Missing relations to other classes
}
