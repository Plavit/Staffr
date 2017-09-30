package system.business;

import system.business.enums.Status;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Employee.findByName",
        query = "SELECT l FROM Employee l WHERE LOWER(l.firstName) = :firstName AND LOWER(l.lastName) = :lastName"),

        @NamedQuery(name = "Employee.findAll", query = "SELECT l FROM Employee l")
})


@Entity
public class Employee extends AbstractBusinessObject {

    public Employee() {

    }

    public Employee(String firstName,
                    String lastName,
                    int birthYear,
                    String email,
                    String note,
                    int phoneNumber,
                    Status active,
                    User user,
                    Set<Employee> managers,
                    Set<Degree> degrees,
                    Set<Position> positions,
                    Set<Skill> skills,
                    Office office,
                    Address address,
                    Set<Experience> experiences,
                    Set<UserProject> userProjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.email = email;
        this.note = note;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.user = user;
        this.managers = managers;
        this.degrees = degrees;
        this.positions = positions;
        this.skills = skills;
        this.office = office;
        this.address = address;
        this.experiences = experiences;
        this.userProjects = userProjects;
    }

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

    @Column
    private Status active;

    @OneToOne
    @JoinColumn(name="USER_ID")
    private User user;


    @ManyToMany()
    @JoinTable(name = "EMPLOYEE_EMPLOYEE",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    )
    private Set<Employee> managers;

    @OneToMany(mappedBy = "employee")
    private Set<Degree> degrees;

    @ManyToMany()
    @JoinTable(name = "EMPLOYEE_POSITION",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
    )
    private Set<Position> positions;

    @OneToMany(mappedBy = "employee")
    private Set<Skill> skills;

    @ManyToOne()
    @JoinColumn(name="OFFICE_ID")
    private Office office;

    @ManyToOne()
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "employee")
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "employee")
    private Set<UserProject> userProjects;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String nfirstName) {
        this.firstName = nfirstName;
    }

    public String getLastName() {
        return firstName;
    }

    public void setLastName(String nlastName) {
        this.lastName = nlastName;
    }

    public int getPhone() { return phoneNumber; }

    public void setPhone(int phone) {
        this.phoneNumber = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }


}
