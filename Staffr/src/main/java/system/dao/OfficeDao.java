package system.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;
import system.business.Employee;
import system.business.Office;

import javax.persistence.NoResultException;
import java.util.Objects;

/**
 * Created by Marek on 9/30/17.
 */
@Repository
public class OfficeDao extends BaseDao<Office>{

    protected OfficeDao() {
        super(Office.class);
    }

    @Transactional(readOnly = true)
    public Office findByName(String firstName, String lastName) {
        Objects.requireNonNull(firstName);
        Objects.requireNonNull(lastName);
        try {
            return em.createNamedQuery("Office.findByName", Office.class)
                    .setParameter("firstName", firstName.toLowerCase())
                    .setParameter("lastName", lastName.toLowerCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
