package system.business;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by krystof on 9/3/17.
 */

@NamedQueries({
        @NamedQuery(name = "UserProject.findByUserAndStartingDate",
                query = "SELECT l FROM UserProject l WHERE l.user = :userID " +
                        "AND l.from >= :startingDate"),
})

@Entity()
public class UserProject extends AbstractBusinessObject {

    private String role;

    @Column(name = "starting_date")
    private LocalDate from;

    @Column(name = "ending_date")
    private LocalDate end;

    @ManyToOne()
    @JoinColumn(name = "USER_ID")
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

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
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
