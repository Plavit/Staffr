package system.business;

import org.springframework.security.crypto.password.PasswordEncoder;
import system.business.enums.Role;
import system.business.enums.Status;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = "Employee.findByName", query = "SELECT l FROM User l WHERE LOWER(l.firstName) = :firstName AND LOWER(l.lastName) = :lastName"),
        @NamedQuery(name = "User.findByUsername", query = "SELECT p FROM User p WHERE p.userName=:username"),
        @NamedQuery(name = "User.deleteById", query = "DELETE FROM User p WHERE p.id=:id"),
        @NamedQuery(name = "Employee.findAll", query = "SELECT l FROM User l")
})


@Entity
public class User extends AbstractBusinessObject {

    private String userName;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private int birthYear;
    private String email;
    private String note;
    private int phoneNumber;
    private Status active;

    @ManyToMany()
    @JoinTable(name = "EMPLOYEE_MANAGER",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID")
    )
    private Set<User> managers;

    @ManyToMany()
    @JoinTable(name = "MANAGER_EMPLOYEE",
            joinColumns = @JoinColumn(name = "MANAGER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    )
    private Set<User> users;

    @OneToMany(mappedBy = "employee")
    private Set<Degree> degrees;

    @OneToMany(mappedBy = "employee")
    private Set<Position> positions;

    @OneToMany(mappedBy = "employee")
    private Set<Skill> skills;

    @ManyToOne()
    @JoinColumn(name = "OFFICE_ID")
    private Office office;

    @ManyToOne()
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToMany(mappedBy = "employee")
    private Set<Experience> experiences;

    @OneToMany(mappedBy = "employee")
    private Set<UserProject> userProjects;

    public User() {
    }

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(String firstName, String lastName, int birthYear, String email, String note, int phoneNumber, Status active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.email = email;
        this.note = note;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    public User(String userName, String password, Role role, String firstName, String lastName, int birthYear, String email, String note, int phoneNumber, Status active) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.email = email;
        this.note = note;
        this.phoneNumber = phoneNumber;
        this.active = active;
    }

    public void encodePassword(PasswordEncoder encoder) {
        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("Cannot encode an empty password.");
        }
        this.password = encoder.encode(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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

    public Set<User> getManagers() {
        return managers;
    }

    public void setManagers(Set<User> managers) {
        this.managers = managers;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
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
