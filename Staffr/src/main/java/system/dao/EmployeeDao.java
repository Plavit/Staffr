package system.dao;

import org.springframework.transaction.annotation.*;
import system.business.Employee;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by krystof on 9/3/17.
 */
public class EmployeeDao extends BaseDao<Employee>{

    protected EmployeeDao() {
        super(Employee.class);
    }

    @Transactional(readOnly = true)
    public Employee findByName(String firstName, String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        try {
            return em.createNamedQuery("Employee.findByName", Employee.class)
                    .setParameter("firstName", firstName.toLowerCase())
                    .setParameter("lastName", lastName.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
