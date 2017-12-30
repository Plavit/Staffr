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
    private Set<User> user;

    @ManyToOne()
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public Office() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
