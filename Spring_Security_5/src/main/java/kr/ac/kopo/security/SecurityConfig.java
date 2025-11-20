package kr.ac.kopo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserDetailsService userDetailsService) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(req -> req
						.requestMatchers("/", "/login", "/error").permitAll()
						.anyRequest().authenticated())
				// .formLogin(Customizer.withDefaults())
				.formLogin(login -> login
						.loginPage("/login"))
				.logout(logout -> logout
						.logoutSuccessUrl("/")
						.invalidateHttpSession(true))
				.csrf(csrf -> csrf.disable())
				.userDetailsService(userDetailsService)
				.build();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new PlainPasswordEncoder();
	}
	
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	

}
