package system.business;

import javax.persistence.*;

/**
 * Created by krystof on 9/3/17.
 */

@Entity()
public class Address  extends AbstractBusinessObject{

    @Column()
    private String country;

    @Column()
    private String city;

    @Column()
    private int psc;

    @Column()
    private String street;

    @Column()
    private String cp;

    public Address() {

    }
}
