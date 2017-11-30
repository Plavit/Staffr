package system.business;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Experience extends Skill{


    @Column(name = "startingFrom")
    private LocalDate from;

    @Column(name = "endingDate")
    private LocalDate to;

    public Experience() {

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
