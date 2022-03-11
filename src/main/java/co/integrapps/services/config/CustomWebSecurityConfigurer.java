package co.integrapps.services.config;

import co.integrapps.services.adapters.persistence.repository.JpaUserOmnilatam;
import co.integrapps.services.adapters.persistence.repository.JpaUserOmnilatamRepository;
import co.integrapps.services.application.service.ClearCacheService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;


@Configuration
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private JpaUserOmnilatamRepository jpaUserOmnilatamRepository;
    private static final Logger LOGGER = LogManager.getLogger(CustomWebSecurityConfigurer.class);

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        List<JpaUserOmnilatam> users = jpaUserOmnilatamRepository.findAllByIsActive(true);
        LOGGER.info("users : {}", new Gson().toJson(users));
        users.forEach(user -> {
            try {
                auth.inMemoryAuthentication().withUser(user.getUsername()).password(String.format("{noop}%s",user.getPasswrd())).roles("USER");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf()
                .disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}