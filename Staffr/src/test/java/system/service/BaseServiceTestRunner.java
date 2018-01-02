/**
 * Copyright (C) 2016 Czech Technical University in Prague
 * <p>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package system.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import system.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestServiceConfig.class, TestPersistenceConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional(transactionManager = "txManager")
public abstract class BaseServiceTestRunner {

    @Autowired
    protected UserDao userDao;

//    @Autowired
//    protected PasswordEncoder passwordEncoder;
//
//    protected void persistUser(User p) {
//        p.encodePassword(passwordEncoder);
//        userDao.persist(p);
//    }
}
