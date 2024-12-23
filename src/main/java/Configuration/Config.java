package Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build();
        UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("user1")).roles("USER").build();
        UserDetails user2 = User.withUsername("user2").password(passwordEncoder().encode("user2")).roles("USER").build();
        return new InMemoryUserDetailsManager(user, user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests().requestMatchers("src/main/webapp/WEB-INF/views/index.jsp").permitAll()
                .requestMatchers("src/main/webapp/WEB-INF/views/HomePage.jsp").hasRole("ADMIN")
                .requestMatchers("src/main/webapp/WEB-INF/views/HomePage.jsp").hasRole("USER")
                .




    }


}
