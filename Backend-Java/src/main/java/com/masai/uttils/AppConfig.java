package com.masai.uttils;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {
	@Bean
	public SecurityFilterChain allowURLs(HttpSecurity http) throws Exception {
	
		
		http.sessionManagement(se -> se.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
		cors(cors ->{
			cors.configurationSource(new org.springframework.web.cors.CorsConfigurationSource(){
				
				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration configuration= new CorsConfiguration();
					configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
					configuration.setAllowedMethods(Collections.singletonList("*"));
					configuration.setAllowCredentials(true);
					configuration.setAllowedHeaders(Collections.singletonList("*"));
					configuration.setExposedHeaders(Arrays.asList("Authorization"));
					return configuration;
				}
			});
		}) .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST , "users", "books","mail").permitAll()
				.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
				.requestMatchers(HttpMethod.GET,"chat" ,"books","users","books/**" ).permitAll()
//				.requestMatchers(HttpMethod.GET,"users/wishList/**" ).permitAll()
//				.requestMatchers(HttpMethod.POST ,"books" ).permitAll()
//				.requestMatchers(HttpMethod.GET,"/hello","/users").hasRole("ADMIN")
//				.requestMatchers(HttpMethod.DELETE,"/orders/**").hasRole("ADMIN")
//				.requestMatchers(HttpMethod.POST, "/suppliers","/categories","/products/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/logini","/**").hasAnyRole("ADMIN" , "USER")
//				.requestMatchers(HttpMethod.PUT,"/orders/**").hasRole("USER")
				.anyRequest().authenticated())
				.csrf(csrf -> csrf.disable())
				.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
				.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		
		return http.build() ;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
