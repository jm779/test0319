package kr.ac.kopo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, UserDetailsService userDetailsService) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(req -> req.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
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
