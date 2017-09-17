package system.business;

import javax.persistence.*;
import javax.swing.text.Position;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Employee.findByName",
        query = "SELECT l FROM Employee l WHERE LOWER(l.firstName) = :firstName AND LOWER(l.lastName) = :lastName"),

        @NamedQuery(name = "Employee.findAll", query = "SELECT l FROM Employee l")
})
@Entity
public class Employee extends AbstractBusinessObject {

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

    public Employee() {

    }

    //relations


    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;


    @ManyToMany()
    @JoinTable(name = "EMPLOYEE_EMPLOYEE",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    )
    private Set<Employee> managers;

    /*
    @OneToMany(mappedBy = "Employee")
    private Set<Degree> degrees;

    /*
    @OneToOne
    @JoinColumn(name="POSITION_ID")
    private Set<Position> positions;

    @OneToMany(mappedBy = "Employee")
    private Set<Skill> skills;

    @ManyToOne()
    @JoinColumn(name="OFFICE_ID")
    private Office office;

    @ManyToOne()
    @JoinTable(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "Employee")
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "Employee")
    private Set<UserProject> userProjects;
*/

}
