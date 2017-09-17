package system.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */

@Entity()
public class Project extends AbstractBusinessObject {
    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private Set<String> goals;

    @Column()
    private Date startOfProject;

    @Column()
    private Date endOfProject;

    public Project() {

    }

}
