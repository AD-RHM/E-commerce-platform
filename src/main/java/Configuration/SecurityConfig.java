package Configuration;

import Security.DefaultAuthenticationFailureHandler;
import Security.DefaultLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        Collection<UserDetails> users = new ArrayList<>();
        UserDetails user = User
                .withUsername("Adib@gmail.com")
                .password(passwordEncoder().encode("250922"))
                .roles("ADMIN")
                .build();
        UserDetails user2 = User
                .withUsername("Rahmane@gmail.com")
                .password(passwordEncoder().encode("0000"))
                .roles("USER")
                .build();
        users.add(user);
        users.add(user2);
        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/Dashboard/css/**","/Dashboard/images/**","/Dashboard/js/**","/Dashboard/fonts/**",
                                "/UserUI/css/**","/UserUI/images/**","/UserUI/js/**","/UserUI/fonts/**").permitAll()
                        .requestMatchers("/index").permitAll()
//                                .requestMatchers("/templates/Dashboard/**").hasRole("ADMIN")
//                        .requestMatchers("/templates/Dashboard/**").authenticated()
                                .anyRequest().authenticated()
//                        .requestMatchers("/homepage").hasRole("USER")

//                        .anyRequest().authenticated()
                        )
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .passwordParameter("password")
                        .usernameParameter("username")
                        .loginProcessingUrl("/performLogin")
//                        .defaultSuccessUrl("/dashboard", false)
                        .failureUrl("/login?error=true")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/performLogout")
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID")
                );
        return http.build();

    }
//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new DefaultAuthenticationFailureHandler();
//    }
//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() {
//        return new DefaultLogoutSuccessHandler();
//    }
}
