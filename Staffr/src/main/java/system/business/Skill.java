package system.business;

/**
 * Created by Marek on 3.9.2017.
 */

import system.business.enums.SkillProfficiency;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Skill {

    @Column()
    private String name;

    @Enumerated()
    private SkillProfficiency profficiency;

}
