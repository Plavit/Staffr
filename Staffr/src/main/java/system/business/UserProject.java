package system.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

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

    public UserProject() {

    }

//relations

    /*

    @ManyToOne()
    @JoinColumn(name="PROJECT_ID")
    private Project project;

    */
}
