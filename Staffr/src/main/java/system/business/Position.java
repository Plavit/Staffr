package system.business;

import javax.persistence.*;

/**
 * Created by krystof on 9/3/17.
 */

@Entity
public class Position extends AbstractBusinessObject {

    @Column()
    private String name;

    public Position() {

    }
}
