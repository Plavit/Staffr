package system.business;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marek on 3.9.2017.
 */

@Entity
public class Experience {

    @Column()
    private String name;

    @Column()
    private Date from;

    @Column()
    private Date to;

    @Column()
    private String note;
}
