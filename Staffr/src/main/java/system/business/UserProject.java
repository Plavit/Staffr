package system.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by krystof on 9/3/17.
 */

@Entity()
public class UserProject {

    @ManyToOne()
    @JoinColumn(name="PROJECT_ID")
    private Project project;

    @Column()
    private String role;

    @Column()
    private Date start;

    @Column()
    private Date end;

}
