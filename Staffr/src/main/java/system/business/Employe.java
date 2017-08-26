package system.bo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class Employe extends AbstractBusinessObject {
    @Column(length = 100, nullable = false)
    String firstname;
    @Column(length = 100, nullable = false)
    String lastname;
    @Column(nullable = false)
    Date dateOfBirth;
    @Column()
    String email;
    @Column()
    int phoneNumber;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    

}
