package system.business;

import javax.persistence.*;

/**
 * Created by Marek on 3.9.2017.
 */

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
