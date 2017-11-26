package system.business;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Experience extends Skill{


    @Column(name = "startingFrom")
    private Date from;

    @Column(name = "endingDate")
    private Date to;

    public Experience() {

    }
    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}
