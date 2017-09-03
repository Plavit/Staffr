package system.business.enums;

import javax.persistence.*;

/**
 * Created by krystof on 9/3/17.
 */

@Entity()
public class User {
    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private Role role;

}
