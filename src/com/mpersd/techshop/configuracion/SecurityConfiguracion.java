package com.mpersd.techshop.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguracion extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	CustomSuccesHandler customSuccessHandler;
	

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.csrf().disable()
	  	.authorizeRequests()
	  	.antMatchers("/", "/index","/tienda","/api/carrito").permitAll()
	  	.antMatchers("/micuenta").access("hasRole('USER') and hasRole('ADMIN')")
	  	.antMatchers("/RealizarOrden").access("hasRole('USER')")
	  	.antMatchers("/RealizarOrden").access("hasRole('ADMIN')")
	  	.antMatchers("/index/**").access("hasRole('USER')")
	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
