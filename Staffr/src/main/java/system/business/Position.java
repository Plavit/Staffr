package system.business;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */

@NamedQueries({
        @NamedQuery(name = "Position.findByName",
                query = "SELECT l FROM Position l WHERE LOWER(l.name) = :name"),

        @NamedQuery(name = "Position.findAll", query = "SELECT l FROM Position l")
})

@Entity
public class Position extends AbstractBusinessObject {

    private String name;

    @ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
    public User user;

    public Position() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
