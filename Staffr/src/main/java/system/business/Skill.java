package system.business;

/**
 * Created by Marek on 3.9.2017.
 */

import system.business.enums.SkillProfficiency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Skill extends AbstractBusinessObject {

    @Column()
    private String name;

    @Enumerated()
    private SkillProfficiency profficiency;

    public Skill() {

    }
}
