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
                    Set<EmployeePosition> employeePositions,
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
        this.employeePositions = employeePositions;
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

    @OneToMany(mappedBy = "employee")
    private Set<EmployeePosition> employeePositions;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getActive() {
        return active;
    }

    public void setActive(Status active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Employee> getManagers() {
        return managers;
    }

    public void setManagers(Set<Employee> managers) {
        this.managers = managers;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }

    public Set<EmployeePosition> getEmployeePositions() {
        return employeePositions;
    }

    public void setEmployeePositions(Set<EmployeePosition> employeePositions) {
        this.employeePositions = employeePositions;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<UserProject> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(Set<UserProject> userProjects) {
        this.userProjects = userProjects;
    }
}
