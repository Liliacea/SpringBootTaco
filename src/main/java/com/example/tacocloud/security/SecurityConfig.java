package com.example.tacocloud.security;

import com.example.tacocloud.User;
import com.example.tacocloud.data.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) {
                return user;
            }
            throw new UsernameNotFoundException(
                    "User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .mvcMatchers("/design", "/orders").hasRole("USER")
                .anyRequest().permitAll()

                .and()
                .formLogin()
                .loginPage("/login")


                .and()
                .logout()
                .logoutSuccessUrl("/")

                // Make H2-Console non-secured; for debug purposes
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")

                // Allow pages to be loaded in frames from the same origin; needed for H2-Console
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .build();
    }

}

            /*    .authorizeRequests()
                .antMatchers("/design", "/orders").hasRole("USER")
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .and()

                .formLogin()//менять путь и наименования полей формы
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .and()


                .formLogin()//перенаправление после успешного входа
                .loginPage("/login")
                .defaultSuccessUrl("/design")
                .and()
                .build();

             */

/*хранение в памяти
 * @Bean
 * public UserDetailsService userDetailsService(PasswordEncoder encoder) {
 *  List<UserDetails> usersList = new ArrayList<>();
 *  usersList.add(new User(
 *  "buzz", encoder.encode("password"),
 *  Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
 *  usersList.add(new User(
 *  "woody", encoder.encode("password"),
 *  Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
 *  return new InMemoryUserDetailsManager(usersList);
 * }
 * @param userRepo
 * @return
 */