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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getGoals() {
        return goals;
    }

    public void setGoals(Set<String> goals) {
        this.goals = goals;
    }

    public Date getStartOfProject() {
        return startOfProject;
    }

    public void setStartOfProject(Date startOfProject) {
        this.startOfProject = startOfProject;
    }

    public Date getEndOfProject() {
        return endOfProject;
    }

    public void setEndOfProject(Date endOfProject) {
        this.endOfProject = endOfProject;
    }
}
