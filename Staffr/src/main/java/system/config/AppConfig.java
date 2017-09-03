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
package system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * Root configuration file of our project - it sets up basic Spring configuration and imports additional configuration files.
 * <p>
 * It is good to separate configuration of different components of the application, because they can then be configured
 * independently for example in tests.
 */
// This annotation is required when services without separate interfaces are used. It causes cglib-based proxies of
// the services to be used - see http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/EnableAspectJAutoProxy.html#proxyTargetClass--
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration  // This class is a Spring configuration
@Import({WebAppConfig.class, PersistenceConfig.class, ServiceConfig.class}) // Import additional configuration classes
public class AppConfig {
}
