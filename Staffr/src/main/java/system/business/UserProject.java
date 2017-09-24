package system.business;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */

@Entity()
public class UserProject extends AbstractBusinessObject {

    @Column()
    private String role;

    @Column(name = "starting_date")
    private Date from;

    @Column(name = "ending_date")
    private Date end;

    @ManyToOne()
    private Employee employee;

    public UserProject() {

    }

    @ManyToOne()
    @JoinColumn(name = "PROJECT_ID")
    private Project project;
}
