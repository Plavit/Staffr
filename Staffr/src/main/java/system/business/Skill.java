package system.business;

/**
 * Created by Marek on 3.9.2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import system.business.enums.SkillProfficiency;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Skill.findByName",
                query = "SELECT l FROM Skill l WHERE LOWER(l.name) = :name"),
        @NamedQuery(name = "Skill.findAll", query = "SELECT l FROM Skill l"),
        @NamedQuery(name = "Skill.findByUser", query = "SELECT l FROM Skill l WHERE l.user = :user")
})

@Entity
public class Skill extends AbstractBusinessObject {

    @Column()
    private String name;

    @Enumerated()
    private SkillProfficiency profficiency;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User user;

    public Skill() {

    }

    public Skill(String name, SkillProfficiency profficiency) {
        this.name = name;
        this.profficiency = profficiency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillProfficiency getProfficiency() {
        return profficiency;
    }

    public void setProfficiency(SkillProfficiency profficiency) {
        this.profficiency = profficiency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
