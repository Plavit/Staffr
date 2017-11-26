package system.business;

/**
 * Created by Marek on 3.9.2017.
 */

import system.business.enums.SkillProfficiency;

import javax.persistence.*;

public class SoftSkill extends Skill {

    @Enumerated()
    private SkillProfficiency profficiency;

    @Column()
    private String note;

    public SoftSkill() {

    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public SkillProfficiency getProfficiency() {
        return profficiency;
    }

    public void setProfficiency(SkillProfficiency profficiency) {
        this.profficiency = profficiency;
    }

}
