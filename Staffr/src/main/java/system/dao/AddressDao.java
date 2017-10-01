package system.dao;

import system.business.Address;

/**
 * Created by krystof on 10/1/17.
 */
public class AddressDao extends BaseDao<Address>{

    protected AddressDao() {
        super(Address.class);
    }
}