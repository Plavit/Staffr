package system.business;

import system.business.enums.DegreeType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marek on 3.9.2017.
 */

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
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne()
    @JoinColumn(name="UNIVERSITY_ID")
    private University university;

}
