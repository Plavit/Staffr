package system.business;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Experience extends AbstractBusinessObject{

    @Column()
    private String name;

    @Column(name = "startingFrom")
    private Date from;

    @Column(name = "endingDate")
    private Date to;

    @Column()
    private String note;

    @ManyToOne()
    private Employee employee;

    public Experience() {

    }
}
