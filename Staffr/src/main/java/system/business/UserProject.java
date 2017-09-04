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

    @Column()
    private Date start;

    @Column()
    private Date end;

//relations

    /*

    @ManyToOne()
    @JoinColumn(name="PROJECT_ID")
    private Project project;

    */
}
