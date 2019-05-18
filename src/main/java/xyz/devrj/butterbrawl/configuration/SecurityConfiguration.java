package xyz.devrj.butterbrawl.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public SecurityConfiguration(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //Use to encode password with bCrypt encoding
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Configure custom username/password queries for spring security
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Get user authentication details via jdbc
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM user_account WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM user_account WHERE username=?")
                .passwordEncoder(passwordEncoder());


    }

    //Define security login specs
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup/user", "/signup/group").permitAll()
                .antMatchers("/", "/**").hasRole("USER")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/authenticateTheUser")
//                Logout Support
            .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorizedPage")
            .and()
                //Allow iframes
                .headers().frameOptions().sameOrigin();
    }

    //Security must ignore these patterns to include resources/static/ css and js
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**")
                .and()
        .ignoring().antMatchers("/signup/css/**")
                .and()
        .ignoring().antMatchers("/js/**")
                .and()
        .ignoring().antMatchers("/signup/js/**")
                .and()
        .ignoring().antMatchers("/images/**")
                .and()
        .ignoring().antMatchers("/signup/images/**");
    }




}
