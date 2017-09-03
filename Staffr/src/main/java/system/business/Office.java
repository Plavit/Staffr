package system.business;

import javax.persistence.*;

/**
 * Created by krystof on 9/3/17.
 */

@Entity
public class Office {

    @Column()
    private String name;

    @Column()
    private String note;

    @ManyToOne()
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

}
