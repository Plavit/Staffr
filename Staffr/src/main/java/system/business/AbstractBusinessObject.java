package system.business;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by MarekS on 26.08.2017.
 */

@MappedSuperclass
public abstract class AbstractBusinessObject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
