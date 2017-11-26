package system.business;

/**
 * Created by Marek on 3.9.2017.
 */

import system.business.enums.SkillProfficiency;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Skill.findByName",
                query = "SELECT l FROM Skill l WHERE LOWER(l.name) = :name"),

        @NamedQuery(name = "Skill.findAll", query = "SELECT l FROM Skill l")
})

@Entity
public class Skill extends AbstractBusinessObject {

    @Column()
    private String name;

    @Enumerated()
    private SkillProfficiency profficiency;

    @ManyToOne
    User user;

    public Skill() {

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

    public User getEmployee() {
        return user;
    }

    public void setEmployee(User user) {
        this.user = user;
    }
}
