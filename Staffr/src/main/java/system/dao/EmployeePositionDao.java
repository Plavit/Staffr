package system.dao;

import org.springframework.stereotype.Repository;
import system.business.EmployeePosition;

/**
 * Created by krystof on 10/8/17.
 */

@Repository
public class EmployeePositionDao extends BaseDao<EmployeePosition> {
    protected EmployeePositionDao () {
        super(EmployeePosition.class);
    }
}
