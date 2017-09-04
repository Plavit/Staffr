package system.business;

import javax.persistence.*;

/**
 * Created by krystof on 9/3/17.
 */

@Entity
public class Office extends AbstractBusinessObject {

    @Column()
    private String name;

    @Column()
    private String note;

    //relations

    /*
    @ManyToOne()
    @JoinColumn(name="ADDRESS_ID")
    private Address address;
    */

}
