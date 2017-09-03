package system.business;

import system.business.enums.DegreeType;
import system.business.enums.SkillProfficiency;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Degree {

    @Enumerated()
    private DegreeType type;

    @Column()
    private String name;

    @Column()
    private Date from;

    @Column()
    private Date to;
}
