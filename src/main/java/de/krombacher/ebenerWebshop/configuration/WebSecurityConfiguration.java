package de.krombacher.ebenerWebshop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import de.krombacher.ebenerWebshop.security.AuthSuccessHandler;
import de.krombacher.ebenerWebshop.security.HttpAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	HttpAuthenticationEntryPoint entryPoint;
	
	@Bean
	public AuthSuccessHandler successHandler() {
		return new AuthSuccessHandler();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	     auth.inMemoryAuthentication().withUser("2095").password("admin").authorities("ROLE_USER");
	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.exceptionHandling().authenticationEntryPoint(entryPoint)
		.and().authorizeRequests().antMatchers("/").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/api/**").permitAll()
		
		.and()
		.formLogin()
		.successHandler(successHandler());		
	}


}
