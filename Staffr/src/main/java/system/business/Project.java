package system.business;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by krystof on 9/3/17.
 */
@NamedQueries({
        @NamedQuery(name = "Project.findByName",
                query = "SELECT l FROM Project l WHERE LOWER(l.name) = :name"),

        @NamedQuery(name = "Project.findAll", query = "SELECT l FROM Project l")
})

@Entity()
public class Project extends AbstractBusinessObject {

    private String name;


    private String description;


    private Set<String> goals;


    private Date startOfProject;


    private Date endOfProject;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserProject> userProject;

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

    public Set<UserProject> getUserProject() {
        return userProject;
    }

    public void setUserProject(Set<UserProject> userProject) {
        this.userProject = userProject;
    }

    public void addUserProject(UserProject up){
        if(userProject==null) userProject=new HashSet<>();
        userProject.add(up);
    }
}
