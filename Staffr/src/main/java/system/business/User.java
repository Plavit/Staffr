package system.business;

import org.springframework.security.crypto.password.PasswordEncoder;
import system.business.enums.Role;

import javax.persistence.*;

/**
 * Created by krystof on 9/3/17.
 */

@Table(name = "users")
@NamedQueries(
        {@NamedQuery(name = "User.findByUsername", query = "SELECT p FROM User p WHERE p.userName=:username"),
                @NamedQuery(name = "User.deleteById", query = "DELETE FROM User p WHERE p.id=:id")})

@Entity
public class User extends AbstractBusinessObject {
    @Column
    private String userName;

    @Column
    private String password;

    public void encodePassword(PasswordEncoder encoder) {
        if (password == null || password.isEmpty()) {
            throw new IllegalStateException("Cannot encode an empty password.");
        }
        this.password = encoder.encode(password);
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User() {

    }

    public User(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void erasePassword() {
        this.password = null;
    }

    @Column
    private Role role;

}
