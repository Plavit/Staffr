package system.business;

import javax.persistence.*;

/**
 * Created by Marek on 3.9.2017.
 */

@NamedQueries({
        @NamedQuery(name = "University.findByName",
                query = "SELECT l FROM University l WHERE LOWER(l.name) = :name"),

        @NamedQuery(name = "University.findAll", query = "SELECT l FROM University l")
})

@Entity
public class University extends AbstractBusinessObject {

    @Column()
    private String name;

    public University() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
