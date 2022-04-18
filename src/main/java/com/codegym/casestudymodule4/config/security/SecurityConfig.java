package com.codegym.casestudymodule4.config.security;

import com.codegym.casestudymodule4.config.CustomAccessDeniedHandler;
import com.codegym.casestudymodule4.config.JwtAuthenticationFilter;
import com.codegym.casestudymodule4.config.RestAuthenticationEntryPoint;
import com.codegym.casestudymodule4.model.role.Role;
import com.codegym.casestudymodule4.model.user.User;
import com.codegym.casestudymodule4.service.role.IRoleService;
import com.codegym.casestudymodule4.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //bean mã hóa pass
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //lấy user từ DB
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());//Tùy chỉnh lại thông báo 401 thông qua class restEntryPoint
        http.authorizeRequests()
                .antMatchers("/image/**",
                        "/login",
                        "/register",
                        "**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }

    @PostConstruct
    public void init() {
        List<User> users = (List<User>) userService.findAll();
        List<Role> roleList = (List<Role>) roleService.findAll();
        if (roleList.isEmpty()) {
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setName("ROLE_ADMIN");
            roleService.save(roleAdmin);

            Role roleCoach = new Role();
            roleCoach.setId(2L);
            roleCoach.setName("ROLE_USER");
            roleService.save(roleCoach);

            Role roleSeller = new Role();
            roleSeller.setId(3L);
            roleCoach.setName("ROLE_SELLER");
            roleService.save(roleSeller);

            Role roleBlock = new Role();
            roleSeller.setId(4L);
            roleCoach.setName("ROLE_BLOCK");
            roleService.save(roleBlock);
        }
        if (users.isEmpty()) {
            User admin = new User("admin", "123456");
            userService.saveAdmin(admin);
        }
    }

}