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
package system.dao;


import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import system.config.PersistenceConfig;

/**
 * This class configures our tests so that we can use the Spring features in them - e.g. autowiring.
 * <p>
 * It is often good to extract this setup into a common superclass, so that we need not set the configuration on every test class.
 */
@RunWith(SpringJUnit4ClassRunner.class) // Tell JUnit to use Spring's test runner
/*
Which configuration classes should Spring load. This also means that for example service classes and REST controllers
won't be available for autowiring in tests inheriting from this class.
 */
@ContextConfiguration(classes = {PersistenceConfig.class})
// Reset the Spring context after each tests, recreating all the beans
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//extend the transactions to whole tests in order to rollback the changes after each test
// Se also http://docs.spring.io/spring/docs/current/spring-framework-reference/html/integration-testing.html#testcontext-tx
@Transactional(transactionManager = "txManager")
public abstract class BaseDaoTestRunner {
}
