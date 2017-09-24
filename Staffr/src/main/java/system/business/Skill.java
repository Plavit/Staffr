package system.business;

/**
 * Created by Marek on 3.9.2017.
 */

import system.business.enums.SkillProfficiency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Skill extends AbstractBusinessObject {

    @Column()
    private String name;

    @Enumerated()
    private SkillProfficiency profficiency;

    @ManyToOne
    Employee employee;

    public String getSkillName() {
        return name;
    }

    public void setSkillName(String skillName) {
        this.name = skillName;
    }

    public Skill() {

    }
}
