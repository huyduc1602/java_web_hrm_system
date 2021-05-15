package tsg.net.vn.hrmweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import tsg.net.vn.hrmweb.service.MyUserDetailService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailService myUserDetailService;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//config phan xac thuc
		auth.userDetailsService(myUserDetailService).passwordEncoder(bcrypt);
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login","/css/**","/js/**","/build/**","/dist/**","/plugins/**").permitAll()
		.antMatchers("/signup").permitAll()
		.antMatchers("/signup-post").permitAll()
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.loginPage("/login").failureUrl("/login?error=true")
		.defaultSuccessUrl("/")
		.usernameParameter("username")
		.passwordParameter("password")
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/access-denied");
	}
	
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring()
//		.antMatchers("/css/*","/js/*","/build/*","/dist/*","/plugins/*");
//	}
//	
}
