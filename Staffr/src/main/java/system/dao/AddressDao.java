package system.dao;

import org.springframework.stereotype.Repository;
import system.business.Address;

/**
 * Created by krystof on 10/1/17.
 */

@Repository
public class AddressDao extends BaseDao<Address>{

    protected AddressDao() {
        super(Address.class);
    }
}