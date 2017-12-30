package system.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Experience extends Skill{

    @Column()
    private String institution;

    @Column(name = "startingFrom")
    private LocalDate from;

    @Column(name = "endingDate")
    private LocalDate to;

    public Experience() {

    }

    public Experience(String name,String institution, LocalDate from, LocalDate to) {
        this.setName(name);
        this.setInstitution(institution);
        this.setFrom(from);
        this.setTo(to);
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

}
