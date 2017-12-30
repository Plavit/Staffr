package system.business;

import system.business.enums.DegreeType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marek on 3.9.2017.
 */

@NamedQueries({
        @NamedQuery(name = "Degree.findByName",
                query = "SELECT l FROM Degree l WHERE LOWER(l.name) = :name"),

        @NamedQuery(name = "Degree.findAll", query = "SELECT l FROM Degree l")
})

@Entity
public class Degree extends AbstractBusinessObject {

    @Enumerated()
    private DegreeType type;

    @Column()
    private String name;

    @Column(name = "startingDate")
    private Date from;

    @Column(name = "endingDate")
    private Date to;

    public Degree() {

    }

    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne()
    @JoinColumn(name="UNIVERSITY_ID")
    private University university;

    public DegreeType getType() {
        return type;
    }

    public void setType(DegreeType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
