package system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

/**
 * Created by HMT on 25.11.2016.
 */
@Configuration
@ComponentScan(basePackages = "system.service")
public class ServiceConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * {@link RestTemplate} can be used to communicate with web services of another application -
     * see for example <a href="http://www.baeldung.com/rest-template">http://www.baeldung.com/rest-template</a>.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
