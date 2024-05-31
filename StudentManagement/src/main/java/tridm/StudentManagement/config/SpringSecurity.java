package tridm.StudentManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

        @Autowired
        private UserDetailsService userDetailsService;

        @Bean
        public static PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests((authorize) -> authorize
                                                .requestMatchers("/register/**")
                                                .permitAll()
                                                .requestMatchers("/index").permitAll()
                                                .requestMatchers("/**","/students/**", "/teachers/**", "/departments/**", "/subjects/**", "/results/**").permitAll() // Cho phép truy cập vào /students
                                                .requestMatchers("/css/**", "/js/**", "/fonts/**", "/tinymce/**", "/lightgray/**", "/theme/**", 
                                                "/modern/**").permitAll() // Cho phép truy cập tài nguyên CSS
                                                .requestMatchers("/users").hasRole("ADMIN"))
                                .formLogin(
                                                form -> form
                                                                .loginPage("/login")
                                                                .loginProcessingUrl("/login")
                                                                .defaultSuccessUrl("/students")
                                                                .permitAll())
                                .logout(
                                                logout -> logout
                                                                .logoutRequestMatcher(
                                                                                new AntPathRequestMatcher("/logout"))
                                                                .permitAll());
                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth
                                .userDetailsService(userDetailsService)
                                .passwordEncoder(passwordEncoder());
        }
}