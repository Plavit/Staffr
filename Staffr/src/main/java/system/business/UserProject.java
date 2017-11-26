package system.business;

import javax.persistence.*;
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

    @ManyToOne()
    private User user;

    @ManyToOne()
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    public UserProject() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public User getEmployee() {
        return user;
    }

    public void setEmployee(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
