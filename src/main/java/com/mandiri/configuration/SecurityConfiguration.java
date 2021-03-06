package com.mandiri.configuration;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mandiri.repository.UserProfileRepository;
import com.mandiri.service.UserProfileService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//protected void configure(AuthenticationManagerBuilder auth){
		//auth.inMemoryAuthentication()
        //    .withUser("2222222223").password("123").roles("CSR");
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
		//.passwordEncoder(bCryptPasswordEncoder);
		.passwordEncoder(new Md5PasswordEncoder());
		
		//------------------------------------------KETENTUAN WAJIB--------------------------
		//MD5 gak boleh upper case - harus lower case semua yang di database
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder(){
//	    //implements PasswordEncoder and overide encode method with the MD5 protocol
//	    return (PasswordEncoder) new MD5PasswordEncoder();
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder(){
//	    //PasswordEncoder encoder = (PasswordEncoder) new Md5PasswordEncoder();
//		return (PasswordEncoder) new Md5PasswordEncoder();
//	    //return encoder;
//	}
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll().antMatchers("/admin/**").hasAnyAuthority("*").anyRequest()
				.authenticated()
				.and()
				.csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/dashboard").usernameParameter("nip").passwordParameter("password")
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/assets/**", "/csscust/**", "/js/**", "/images/**", "/fonts/**", "/ico/**", "/icons/**", "/imgcust/**", "/avatars/**", "/css/**", "/font-awesome/**", "/img/**", "/swf/**");
	}
	
//	@Bean
//    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
//        return map -> {
//        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    		User user = new User();
//    		user.setUsername(auth.getName());
//    		user.setLastlogin(new Timestamp(System.currentTimeMillis()));
//    		userRepository.save(user);
//            return user;
//        };
//    }
}